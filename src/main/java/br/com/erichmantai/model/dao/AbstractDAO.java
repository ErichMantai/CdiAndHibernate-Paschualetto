package br.com.erichmantai.model.dao;

import br.com.erichmantai.model.connection.DBConnection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @authors fernando e erichmantai
 * @param <T> entidade a ser persistida no banco de dados
 */
public abstract class AbstractDAO<T> implements Serializable {

    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            getEntityManager().close();
        }
    }

    public List<T> listAll() {
        String hql = "select obj from " + clazz.getSimpleName() + " obj order by obj.id";
        Query query = getEntityManager().createQuery(hql);
        return query.getResultList();
    }
    
    public T find(Long id) {
        String hql = "select obj from " + clazz.getSimpleName() + " where obj.id = " + id;
        Query query = getEntityManager().createQuery(hql);
        return (T) query.getSingleResult();
    }

    protected EntityManager getEntityManager() {
        return DBConnection.newInstance().getEntityManager();
    }

}
