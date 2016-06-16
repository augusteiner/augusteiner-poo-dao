
package br.eng.augusteiner.poo.dao.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
public class DAOImpl<K, V> implements IDAO<K, V> {

    public boolean delete(V entity) {

        return false;
    }

    public Iterable<V> findAll() {

        return null;
    }

    public V findById(K id) {

        return null;
    }

    public boolean save(V entity) {

        return false;
    }

    public boolean saveOrUpdate(V entity) {

        return false;
    }
}
