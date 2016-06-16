
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <T>
 */
class DAORepository<T> implements IRepository<T> {

    private IDAO<T> dao;

    public DAORepository(IDAO<T> dao) {

        this.dao = dao;
    }

    public boolean delete(T entity) {

        return this.dao.delete(entity);
    }

    public Iterable<T> findAll() {

        return this.dao.findAll();
    }

    public T findById(Integer id) {

        return this.dao.findById(id);
    }

    public boolean save(T entity) {

        return this.dao.save(entity);
    }

    public boolean saveOrUpdate(T entity) {

        return this.dao.saveOrUpdate(entity);
    }
}
