
package br.eng.augusteiner.poo;

import br.eng.augusteiner.poo.dao.common.IIdentifiable;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Pessoa implements IIdentifiable<Integer> {

    private Integer id;
    private String nome;

    public Pessoa() { }

    public Pessoa(String nome) {

        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public Integer getId() {

        return id;
    }
}
