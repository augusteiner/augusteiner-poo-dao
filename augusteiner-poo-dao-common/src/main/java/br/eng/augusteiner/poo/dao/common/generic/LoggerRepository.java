
package br.eng.augusteiner.poo.dao.common.generic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
class LoggerRepository<K, V> extends DecoratedRepository<K, V>
    implements IRepository<K, V> {

    private Logger logger;

    public LoggerRepository(
        Logger logger,
        IRepository<K, V> repo) {

        super(repo);

        this.logger = logger;
    }

    @Override
    public boolean delete(V entity) {

        return super.delete(entity);
    }

    @Override
    public Iterable<V> findAll() {

        return super.findAll();
    }

    @Override
    public V findById(K id) {

        // logger.log(Level.INFO, "buscando {0} pelo id {1}", id);

        return super.findById(id);
    }

    @Override
    public boolean save(V entity) {

        logger.log(Level.INFO, "salvando entidade {0}", entity);

        return super.save(entity);
    }

    @Override
    public boolean saveOrUpdate(V entity) {

        return super.saveOrUpdate(entity);
    }
}
