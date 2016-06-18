
package br.eng.augusteiner.poo.dao.jdbc;

import java.util.Arrays;
import java.util.Collection;

import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.io.DatabaseIO;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
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

        for (JdbcField field : meta.getFields())
        {
            Column column = new Column();

            if (field.getName().equals("Id")) {

                column.setPrimaryKey(true);
                column.setRequired(true);
            }

            column.setName(field.getName());
            column.setType(field.getType().toLowerCase());

            table.addColumn(column);
        }

        Platform platform = PlatformFactory.createNewPlatformInstance("mysql");

        Database db = new Database();
        db.addTable(table);

        String create = platform.getCreateTablesSql(db, true, true);

        System.out.println(create);

        return table;
    }

    public static <T> Object deleteFromMeta(JdbcMetadata<T> meta) {

        return null;
    }

    public static <T> Object selectFromMeta(JdbcMetadata<T> meta) {

        return null;
    }
}
