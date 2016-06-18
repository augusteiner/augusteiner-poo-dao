
package br.eng.augusteiner.poo.dao.jdbc;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class JdbcField {

    private String name;
    private String type;

    public JdbcField(String name, String type) {

        this.name = name;
        this.type = type;
    }

    public String getName() {

        return name;
    }

    public String getType() {

        return type;
    }

    @Override
    public String toString() {

        return String.format("%s:%s", this.getName(), this.getType().toUpperCase());
    }
}
