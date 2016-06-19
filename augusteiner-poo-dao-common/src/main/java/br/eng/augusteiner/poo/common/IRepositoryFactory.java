
package br.eng.augusteiner.poo.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IRepositoryFactory extends IRegisterListener<IRepositoryFactory> {

    <T> IRepository<T> createNew(Class<T> clazz);
}
