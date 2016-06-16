
package br.eng.augusteiner.poo.dao.common;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <T>
 */
public class LoggingRepository<T> implements IRepository<T> {

    private IRepository<T> baseRepository;
    private Logger logger;

    public LoggingRepository(
        IRepository<T> baseRepository,
        Logger logger) {

        this.baseRepository = baseRepository;
        this.logger = logger;
    }

    public boolean delete(T entity) {

        logger.log(Level.FINE, "deleting {0}", entity);

        return this.baseRepository.delete(entity);
    }

    public Iterable<T> findAll() {

        logger.log(Level.FINE, "finding all");

        return this.baseRepository.findAll();
    }

    public T findById(Integer id) {

        logger.log(Level.FINE, "finding by id {0}", id);

        return this.baseRepository.findById(id);
    }

    public boolean save(T entity) {

        logger.log(Level.FINE, "saving {0}", entity);

        return this.baseRepository.save(entity);
    }

    public boolean saveOrUpdate(T entity) {

        logger.log(Level.FINE, "deleting {0}", entity);

        return this.baseRepository.saveOrUpdate(entity);
    }
}
