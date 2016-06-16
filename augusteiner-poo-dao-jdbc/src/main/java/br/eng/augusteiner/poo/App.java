
package br.eng.augusteiner.poo;

import br.eng.augusteiner.poo.dao.common.IRepository;
import br.eng.augusteiner.poo.dao.common.RepositoryFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 */
public class App {

    public static void main(String[] args) {

        IRepository<Pessoa> repo = RepositoryFactory.createNew(Pessoa.class);

        Pessoa p1 = new Pessoa();

        repo.save(p1);

        System.out.println(repo.getClass().getName());
    }
}
