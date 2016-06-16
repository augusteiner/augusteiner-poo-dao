
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DAOFactory {

    private class NullDAOFactory implements IDAOFactory {

        public <T> IDAO<T> createNew(Class<T> clazz) {

            return null;
        }
    }

    private static final DAOFactory INSTANCE = new DAOFactory();

    public static <T> IDAO<T> createNew(Class<T> clazz) {

        return INSTANCE.impl.createNew(clazz);
    }

    public static void register(IDAOFactory factoryImpl) {

        INSTANCE.impl = factoryImpl;
    }

    private IDAOFactory impl;

    private DAOFactory() {

        this.impl = new NullDAOFactory();
    }
}
