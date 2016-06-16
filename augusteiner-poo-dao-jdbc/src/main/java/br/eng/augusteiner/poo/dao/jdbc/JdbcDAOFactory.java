
package br.eng.augusteiner.poo.dao.jdbc;

import br.eng.augusteiner.poo.dao.common.IDAO;
import br.eng.augusteiner.poo.dao.common.IDAOFactory;
//import br.eng.augusteiner.poo.dao.common.IIdentifiable;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class JdbcDAOFactory implements IDAOFactory {

    public <T> IDAO<T> createNew(Class<T> clazz) {

        return new JdbcDAO<T>(JdbcMetadata.createNew(clazz));
    }
}
