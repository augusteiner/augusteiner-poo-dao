
package br.eng.augusteiner.poo;

import br.eng.augusteiner.poo.common.IRepository;
import br.eng.augusteiner.poo.common.LoggingRepositoryFactory;
import br.eng.augusteiner.poo.dao.common.DAOFactory;
import br.eng.augusteiner.poo.dao.common.DAORepositoryFactory;
import br.eng.augusteiner.poo.dao.jdbc.JdbcDAOFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    static {

        DAOFactory.register(new JdbcDAOFactory());
        DAORepositoryFactory.register(new LoggingRepositoryFactory());
    }

    public static void main(String[] args) {

        IRepository<Pessoa> repo = DAORepositoryFactory
            .createNew(Pessoa.class);

        Pessoa p1 = new PessoaFisica();

        // System.out.println(p1);

        // Assert.assertNull(repo);
        // Assert.assertNull(dao);

        repo.add(p1);

        // System.out.println(repo.getClass().getName());
    }
}
