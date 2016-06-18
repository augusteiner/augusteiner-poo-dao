
package br.eng.augusteiner.poo.dao.common;

import br.eng.augusteiner.poo.common.IRepository;
import br.eng.augusteiner.poo.common.IRepositoryFactory;
import br.eng.augusteiner.poo.common.RegisterEventData;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DAORepositoryFactory {

    private static class Nested {

        private static final DAORepositoryFactory INSTANCE = new DAORepositoryFactory();

        private static DAORepositoryFactory getSingleton() {

            return INSTANCE;
        }

        private Nested() { }
    }

    private class RepositoryFactoryImpl implements IRepositoryFactory {

        @Override
        public <T> IRepository<T> createNew(Class<T> clazz) {

            return new DAORepository<T>(DAOFactory.createNew(clazz));
        }

        @Override
        public void onRegister(RegisterEventData<IRepositoryFactory> e) {

            //
        }
    }

    public static <T> IRepository<T> createNew(Class<T> clazz) {

        return getSingleton().impl.createNew(clazz);
    }

    private static DAORepositoryFactory getSingleton() {

        return Nested.getSingleton();
    }

    public static void register(IRepositoryFactory factoryImpl) {

        factoryImpl.onRegister(RegisterEventData.from(getSingleton().impl));

        getSingleton().impl = factoryImpl;
    }

    private IRepositoryFactory impl;

    private DAORepositoryFactory() {

        this.impl = new RepositoryFactoryImpl();
    }
}
