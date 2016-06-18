
package br.eng.augusteiner.poo.dao.jdbc;

import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.apache.ddlutils.platform.SqlBuilder;

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

        table.setName(meta.getTable().toUpperCase());
        table.setDescription(String.format(
            "Tabela %s",
            table.getName()));

        for (JdbcField field : meta.getFields())
        {
            Column column = new Column();

            if (field.getName().equals("Id")) {

                column.setPrimaryKey(true);
                column.setRequired(true);
                column.setAutoIncrement(true);
            }

            column.setName(field.getName());
            column.setType(field.getType().toLowerCase());

            table.addColumn(column);
        }

        return table;
    }

    public static <T> void insertFromMeta(JdbcMetadata<T> meta, T object) {

        Table table = tableFromMeta(meta);

        Platform platform = PlatformFactory.createNewPlatformInstance("mysql");

        Database db = new Database();
        db.addTable(table);

        String create = platform.getCreateTablesSql(db, true, true);

        SqlBuilder builder = platform.getSqlBuilder();

        String insert = builder.getInsertSql(table, meta.values(object), true);

        System.out.println(create);
        System.out.println(insert);
    }

    public static <T> Object deleteFromMeta(JdbcMetadata<T> meta) {

        return null;
    }

    public static <T> Object selectFromMeta(JdbcMetadata<T> meta) {

        return null;
    }
}
