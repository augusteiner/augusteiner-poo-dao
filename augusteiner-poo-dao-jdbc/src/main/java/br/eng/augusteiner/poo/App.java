
package br.eng.augusteiner.poo;

import br.eng.augusteiner.poo.dao.common.DAOFactory;
import br.eng.augusteiner.poo.dao.common.IRepository;
import br.eng.augusteiner.poo.dao.common.LoggingRepositoryFactory;
import br.eng.augusteiner.poo.dao.common.RepositoryFactory;
import br.eng.augusteiner.poo.dao.jdbc.JdbcDAOFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    static {

        DAOFactory.register(new JdbcDAOFactory());

        RepositoryFactory.register(new LoggingRepositoryFactory());
    }

    public static void main(String[] args) {

        IRepository<Pessoa> repo = RepositoryFactory.createNew(Pessoa.class);

        Pessoa p1 = new Pessoa("José Augusto");

        //System.out.println(p1);

        //Assert.assertNull(repo);
        //Assert.assertNull(dao);

        repo.save(p1);

        // System.out.println(repo.getClass().getName());
    }
}
