
package br.eng.augusteiner.poo.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IRegisterListener<T> {

    void onRegister(RegisterEventData<T> e);
}
