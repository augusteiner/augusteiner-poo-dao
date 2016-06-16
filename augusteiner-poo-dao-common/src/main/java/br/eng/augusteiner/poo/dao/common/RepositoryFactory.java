
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class RepositoryFactory {

    public static <V> IRepository<V> createNew(Class<V> clazz) {

        IDAO<V> dao = DAOFactory.createNew(clazz);

        return new DAORepositoryImpl<V>(dao);
    }

    //public static <K, V> IRepository<V> createNew(Class<K> keyClazz, Class<V> clazz) {
    //
    //    IDAO<K, V> dao = new DAOImpl<K, V>();
    //
    //    return new DAORepositoryImpl<K, V>(dao);
    //}
}
