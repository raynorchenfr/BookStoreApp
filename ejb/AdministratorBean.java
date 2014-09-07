/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @param <T> 
 * @author Tianyang
 */
public class AbstractUserBean<T> {
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;

    private Class<T> entityClass;

    public AbstractUserBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    
    /**
     *
     * @return
     */
    protected EntityManager getEntityManager(){
        return this.em;
    }
    
    /**
     *
     * @param entity
     */
    public void create(T entity){
        em.persist(entity);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public T find(Object id){
        return em.find(entityClass, id);
    }
    
    /**
     *
     * @param jpql
     * @return
     */
    public List<T> findAll(String jpql){
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        return query.getResultList();
    }
    
    /**
     *
     * @param entity
     */
    public void update(T entity){
        em.merge(entity);
    }
    
    /**
     *
     * @param entity
     */
    public void delete(T entity){
        em.remove(entity);
    }
}   
    
    

