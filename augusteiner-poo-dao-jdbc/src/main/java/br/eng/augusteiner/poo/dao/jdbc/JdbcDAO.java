
package br.eng.augusteiner.poo.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean delete(V entity) {

        JdbcUtils.deleteFromMeta(this.meta);

        return false;
    }

    @Override
    public Iterable<V> findAll() {

        List<V> values = new ArrayList<V>();

        values.add(meta.newInstance());
        values.add(meta.newInstance());

        return values;
    }

    @Override
    public V findById(Integer id) {

        JdbcUtils.selectFromMeta(this.meta);

        return null;
    }

    @Override
    public boolean save(V entity) {

        JdbcUtils.insertFromMeta(
            this.meta,
            entity);

        return false;
    }

    @Override
    public boolean saveOrUpdate(V entity) {

        return false;
    }
}
