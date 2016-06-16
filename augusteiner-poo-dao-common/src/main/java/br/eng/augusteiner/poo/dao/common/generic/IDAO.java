
package br.eng.augusteiner.poo.dao.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
public interface IDAO<K, V> {

    boolean delete(V entity);

    Iterable<V> findAll();

    V findById(K id);

    boolean save(V entity);

    boolean saveOrUpdate(V entity);
}
