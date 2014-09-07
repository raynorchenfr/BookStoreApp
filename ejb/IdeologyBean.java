/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Author;
import domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import domain.Ideology;
import domain.KMGR;
import javax.inject.Named;

/**
 *
 * @author Tianyang
 */
@Stateless
@Named
public class IdeologyBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    private Ideology defaultIdeo;
    

    /**
     *
     * @param Ideo
     */
    public void create(Ideology Ideo){
        em.persist(Ideo);
    }
    
    /**
     *
     * @param Ideo
     */
    public void remove(Ideology Ideo){
        em.remove(Ideo);
    }
    
    /**
     *
     * @param p
     */
    public void update(Ideology Ideo){
        em.merge(this);
    }
    
    /**
     *
     * @param Name
     * @return
     */
    public Ideology find(String Name){
        return em.find(Ideology.class, Name);
    }
    
    /**
     *
     * @return
     */
    public List<Ideology> findAll(){
        Query q = em.createQuery("select i from Ideology i", Ideology.class);
        return q.getResultList();
    }
    
    /**
     *
     * @return
     */
    protected EntityManager getEntityManager(){
        return this.em;
    }
    
    
    public void removeIdeology(KMGR k, Ideology i){
        i = getEntityManager().getReference(Ideology.class, i.getName());
        k = getEntityManager().getReference(KMGR.class, k.getId());
        defaultIdeo = new Ideology();
        
        // first remove the pet from the owner
        k.removeIdeology(i);
        em.merge(k);
        
       for( Book b : i.getBook()){
            b.setIdeology(defaultIdeo);
        }
       
       for ( Author atemp : i.getAuthor()){
            atemp.setIdeology(defaultIdeo);
       }
               
               
       getEntityManager().remove(i);
       
    }
}
