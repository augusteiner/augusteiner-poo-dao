
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IDAOFactory {

    <T> IDAO<T> createNew(Class<T> clazz);
}
