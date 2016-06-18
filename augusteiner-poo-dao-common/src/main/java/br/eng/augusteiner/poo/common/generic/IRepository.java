
package br.eng.augusteiner.poo.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
public interface IRepository<K, V> extends Iterable<V> {

    void add(V entity);

    void remove(V entity);

    Iterable<V> values();
}
