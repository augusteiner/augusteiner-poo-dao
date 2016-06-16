
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class DAOFactory {

    private static IDAOFactory factory;

    public static <V> IDAO<V> createNew(Class<V> clazz) {

        return factory.createNew(clazz);
    }

    public static void register(IDAOFactory factoryImpl) {

        factory = factoryImpl;
    }
}
