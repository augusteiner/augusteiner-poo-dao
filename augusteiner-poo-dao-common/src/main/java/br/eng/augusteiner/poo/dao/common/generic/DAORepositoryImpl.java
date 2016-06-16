
package br.eng.augusteiner.poo.dao.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
public class DAORepositoryImpl<K, V> implements IRepository<K, V> {

    private IDAO<K, V> dao;

    public DAORepositoryImpl(IDAO<K, V> dao) {

        this.dao = dao;
    }

    public boolean delete(V entity) {

        return this.dao.delete(entity);
    }

    public Iterable<V> findAll() {

        return this.dao.findAll();
    }

    public V findById(K id) {

        return this.dao.findById(id);
    }

    public boolean save(V entity) {

        return this.dao.save(entity);
    }

    public boolean saveOrUpdate(V entity) {

        return this.dao.saveOrUpdate(entity);
    }
}
