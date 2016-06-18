
package br.eng.augusteiner.poo.dao.common;

import java.util.Iterator;

import br.eng.augusteiner.poo.common.IRepository;

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

    @Override
    public void add(T entity) {

        this.dao.save(entity);
    }

    @Override
    public Iterator<T> iterator() {

        return this.values().iterator();
    }

    @Override
    public void remove(T entity) {

        this.dao.delete(entity);
    }

    @Override
    public Iterable<T> values() {

        return null;
    }
}
