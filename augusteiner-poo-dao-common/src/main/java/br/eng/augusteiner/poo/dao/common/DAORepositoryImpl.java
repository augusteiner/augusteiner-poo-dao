
package br.eng.augusteiner.poo.dao.common;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * @param <V>
 */
class DAORepositoryImpl<V>
    extends br.eng.augusteiner.poo.dao.common.generic.DAORepositoryImpl<Integer, V>
    implements IRepository<V> {

    public DAORepositoryImpl(IDAO<V> dao) {

        super(dao);
    }
}
