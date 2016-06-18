
package br.eng.augusteiner.poo.dao.common.generic;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <K>
 * @param <V>
 */
public interface IDAO<K, V> {

    boolean delete(V entity);

    /**
     * @return
     * @deprecated
     */
    @Deprecated
    Iterable<V> findAll();

    /**
     * @param id
     * @return
     * @deprecated
     */
    @Deprecated
    V findById(K id);

    boolean save(V entity);

    /**
     * @param entity
     * @return
     * @deprecated
     */
    @Deprecated
    boolean saveOrUpdate(V entity);
}
