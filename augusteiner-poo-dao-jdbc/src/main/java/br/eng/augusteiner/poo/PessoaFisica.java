
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica() {

        super();
    }

    public PessoaFisica(String nome) {

        super(nome);
    }

    public PessoaFisica(
        String cpf,
        String nome) {

        this(nome);

        this.cpf = cpf;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    @Override
    public String toString() {

        return String.format(
            "#%s - %s",
            this.getCpf(),
            this.getNome());
    }
}
