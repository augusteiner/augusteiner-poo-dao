
package br.eng.augusteiner.poo.dao.jdbc;

import java.util.Arrays;
import java.util.Collection;

import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Table;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class JdbcUtils {

    /**
     * @see {@link http://stackoverflow.com/questions/5620985/is-there-any-good-dynamic-sql-builder-library-in-java#answer-17492098}
     * @param meta
     * @return
     */
    public static <T> Table tableFromMeta(JdbcMetadata<T> meta) {

        Table table = new Table();

        table.setName(meta.getTable());
        table.setDescription(String.format(
            "Tabela %s",
            meta.getTable()));

        Column idColumn = new Column();

        idColumn.setPrimaryKey(true);
        idColumn.setName("id");
        idColumn.setType("int");
        idColumn.setRequired(true);

        table.addColumn(idColumn);

        return table;
    }

    public static <T> Object deleteFromMeta(JdbcMetadata<T> meta) {

        return null;
    }

    public static <T> Object selectFromMeta(JdbcMetadata<T> meta) {

        return null;
    }

    public static <T> Collection<String> fieldsFromMeta(JdbcMetadata<T> meta) {

        return Arrays.asList(new String[0]);
    }
}
