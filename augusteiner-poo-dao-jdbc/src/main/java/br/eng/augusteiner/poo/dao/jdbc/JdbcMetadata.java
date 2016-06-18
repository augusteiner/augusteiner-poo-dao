
package br.eng.augusteiner.poo.dao.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class JdbcMetadata<T> {

    public static <T> JdbcMetadata<T> createNew(Class<T> entityClass) {

        Constructor<T> ctor = null;

        try {

            ctor = entityClass.getDeclaredConstructor((Class<Object> [])null);
        } catch (Exception e) {

            e.printStackTrace();
        }

        if (ctor == null ||
            !Modifier.isPublic(ctor.getModifiers())) {

            throw new IllegalArgumentException("Argumento clazz deve ser POJO");
        }

        JdbcMetadata<T> meta = new JdbcMetadata<T>();

        meta.entityClass = entityClass;

        meta.table = meta.getEntityClass().getSimpleName();

        importFields(meta);

        JdbcUtils.tableFromMeta(meta);

        return meta;
    }

    private static <T> void importFields(JdbcMetadata<T> meta) {

        for (Method m : meta.getEntityClass().getMethods()) {

            if (m.getName().startsWith("get") &&
                Modifier.isPublic(m.getModifiers()))
            {
                Class<?> type = m.getReturnType();
                String jdbcType;

                if (type.equals(Integer.TYPE) ||
                    type.equals(Integer.class)){

                    jdbcType = "integer";

                } else if (type.equals(Double.TYPE) ||
                    type.equals(Float.TYPE) ||
                    type.equals(Double.class) ||
                    type.equals(Float.class)) {

                    jdbcType = "real";

                } else if (type.equals(String.class)) {

                    jdbcType = "varchar";

                } else if (type.equals(Date.class)) {

                    jdbcType = "datetime";

                } else {

                    continue;
                }

                meta.fields.add(new JdbcField(
                    m.getName().substring(3),
                    jdbcType));
            }
        }
    }

    private String table;

    private Class<T> entityClass;

    private Collection<JdbcField> fields;

    private JdbcMetadata() {

        this.fields = new ArrayList<JdbcField>();
    }

    protected Class<T> getEntityClass() {

        return this.entityClass;
    }

    public Iterable<JdbcField> getFields() {

        return this.fields;
    }

    public String getTable() {

        return table;
    }

    public T newInstance() {

        try {

            return this.entityClass.newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public Map<String, Object> values(T object) {

        Map<String, Object> values = new HashMap<String, Object>();

        for (JdbcField field : this.getFields()) {

            try {

                Method m = this.getEntityClass().getMethod("get" + field.getName());

                values.put(
                    field.getName(),
                    m.invoke(object, (Object[])null));

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return values;
    }
}
