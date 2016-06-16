
package br.eng.augusteiner.poo.dao.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class LoggingRepositoryFactory implements IRepositoryFactory {

    private IRepositoryFactory previous;

    public <T> IRepository<T> createNew(Class<T> clazz) {

        IRepository<T> baseRepository = this.previous.createNew(clazz);

        Logger logger = Logger.getLogger("");
        logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
        logger.setLevel(Level.ALL);

        return new LoggingRepository<T>(
            baseRepository,
            logger);
    }

    public void onRegister(RegisterEventData<IRepositoryFactory> data) {

        this.previous = data.getPrevious();
    }
}
