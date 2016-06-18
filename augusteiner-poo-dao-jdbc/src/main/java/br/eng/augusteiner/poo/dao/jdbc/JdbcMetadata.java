
package br.eng.augusteiner.poo.dao.jdbc;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class JdbcMetadata<T> {

    private String table;
    private Collection<JdbcField> fields;

    private JdbcMetadata() {

        this.fields = new ArrayList<JdbcField>();
    }

    public Iterable<JdbcField> getFields() {

        return this.fields;
    }

    public String getTable() {

        return table;
    }

    public static <T> JdbcMetadata<T> createNew(Class<T> clazz) {

        JdbcMetadata<T> meta = new JdbcMetadata<T>();

        meta.table = clazz.getSimpleName();

        for (Method m : clazz.getMethods()) {

            if (m.getName().startsWith("get") &&
                Modifier.isPublic(m.getModifiers()))
            {
                Class<?> type = m.getReturnType();
                String jdbcType;

                if (type.equals(Integer.class)){

                    jdbcType = "integer";
                } else if (type.equals(String.class)) {

                    jdbcType = "varchar";
                } else if (type.equals(Double.class)) {

                    jdbcType = "real";
                } else {

                    continue;
                }

                meta.fields.add(new JdbcField(m.getName().substring(3), jdbcType));
            }
        }

        JdbcUtils.tableFromMeta(meta);

        for (JdbcField field : meta.fields) {

            System.out.println(field);
        }

        return meta;
    }
}
