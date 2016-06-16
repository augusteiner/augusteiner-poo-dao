
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <T>
 */
public class RegisterEventData<T> {

    private T previous;

    private RegisterEventData(T previous) {

        this.previous = previous;
    }

    public T getPrevious() {

        return previous;
    }

    static <T> RegisterEventData<T> from(T data) {

        return new RegisterEventData<T>(data);
    }
}
