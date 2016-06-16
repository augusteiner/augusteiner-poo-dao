
package br.eng.augusteiner.poo;

import br.eng.augusteiner.poo.dao.common.IIdentifiable;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Pessoa implements IIdentifiable<Integer> {

    private Integer id;
    private String nome;

    public Pessoa() {

        this.id = 0;
    }

    public Pessoa(String nome) {

        this();

        this.nome = nome;
    }

    public Integer getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    @Override
    public String toString() {

        return String.format(
            "#%d - %s",
            this.getId(),
            this.getNome());
    }
}
