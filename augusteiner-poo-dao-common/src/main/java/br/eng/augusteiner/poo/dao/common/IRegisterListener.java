
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IRegisterListener<T> {

    void onRegister(RegisterEventData<T> e);
}
