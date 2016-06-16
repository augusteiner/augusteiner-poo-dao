
package br.eng.augusteiner.poo.dao.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
class DecoratedRepository<K, V> implements IRepository<K, V> {

    private IRepository<K, V> repo;

    public DecoratedRepository(IRepository<K, V> repo) {

        this.repo = repo;
    }

    public boolean delete(V entity) {

        return this.repo.delete(entity);
    }

    public Iterable<V> findAll() {

        return this.repo.findAll();
    }

    public V findById(K id) {

        return this.repo.findById(id);
    }

    public boolean save(V entity) {

        return this.repo.save(entity);
    }

    public boolean saveOrUpdate(V entity) {

        return this.repo.saveOrUpdate(entity);
    }
}
