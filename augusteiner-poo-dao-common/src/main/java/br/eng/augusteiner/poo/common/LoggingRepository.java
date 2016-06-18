
package br.eng.augusteiner.poo.common;

import java.util.Iterator;
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

    @Override
    public void add(T entity) {

        logger.log(Level.FINE, "saving {0}", entity);

        this.baseRepository.add(entity);
    }

    @Override
    public Iterator<T> iterator() {

        return this.values().iterator();
    }

    @Override
    public void remove(T entity) {

        logger.log(Level.FINE, "deleting {0}", entity);

        this.baseRepository.remove(entity);
    }

    @Override
    public Iterable<T> values() {

        logger.log(Level.FINE, "finding all");

        return this.baseRepository.values();
    }
}
