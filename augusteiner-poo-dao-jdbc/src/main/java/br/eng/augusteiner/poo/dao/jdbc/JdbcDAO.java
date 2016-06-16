
package br.eng.augusteiner.poo.dao.jdbc;

import br.eng.augusteiner.poo.dao.common.IDAO;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <V>
 */
public class JdbcDAO<V> implements IDAO<V> {

    private final JdbcMetadata<V> meta;

    public JdbcDAO(JdbcMetadata<V> meta) {

        this.meta = meta;
    }

    public boolean delete(V entity) {

        Object query = JdbcUtils.deleteFromMeta(this.meta);

        return false;
    }

    public Iterable<V> findAll() {

        Object query = JdbcUtils.selectFromMeta(this.meta);

        return null;
    }

    public V findById(Integer id) {

        Object query = JdbcUtils.selectFromMeta(this.meta);

        return null;
    }

    public boolean save(V entity) {

        return false;
    }

    public boolean saveOrUpdate(V entity) {

        return false;
    }
}
