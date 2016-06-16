
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class RepositoryFactory {

    private static class Nested {

        private static final RepositoryFactory INSTANCE = new RepositoryFactory();

        private static RepositoryFactory getSingleton() {

            return INSTANCE;
        }

        private Nested() { }
    }

    private class RepositoryFactoryImpl implements IRepositoryFactory {

        public <T> IRepository<T> createNew(Class<T> clazz) {

            return new DAORepository<T>(DAOFactory.createNew(clazz));
        }

        public void onRegister(RegisterEventData<IRepositoryFactory> e) {

            //
        }
    }

    public static <T> IRepository<T> createNew(Class<T> clazz) {

        return getSingleton().impl.createNew(clazz);
    }

    private static RepositoryFactory getSingleton() {

        return Nested.getSingleton();
    }

    public static void register(IRepositoryFactory factoryImpl) {

        factoryImpl.onRegister(RegisterEventData.from(getSingleton().impl));

        getSingleton().impl = factoryImpl;
    }

    private IRepositoryFactory impl;

    private RepositoryFactory() {

        this.impl = new RepositoryFactoryImpl();
    }
}
