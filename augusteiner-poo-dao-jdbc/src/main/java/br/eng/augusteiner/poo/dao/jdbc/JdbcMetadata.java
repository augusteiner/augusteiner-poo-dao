
package br.eng.augusteiner.poo.dao.jdbc;

import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class JdbcMetadata<T> {

    private String table;
    private Collection<String> fields;

    private JdbcMetadata() { }

    public Iterable<String> getFields() {

        return this.fields;
    }

    public String getTable() {

        return table;
    }

    public static <T> JdbcMetadata<T> createNew(Class<T> clazz) {

        JdbcMetadata<T> meta = new JdbcMetadata<T>();

        meta.table = clazz.getSimpleName();

        meta.fields = JdbcUtils.fieldsFromMeta(meta);

        return meta;
    }
}
