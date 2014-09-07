/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Author;
import domain.Book;
import domain.KMGR;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tianyang
 */
@Stateless
@Named
public class AuthorBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    public AuthorBean(){
        
    }
    
    /**
     *
     * @param author
     */
    public void create(Author author){
        em.persist(author);
    }
    
    /**
     *
     * @param author
     */
    public void remove(Author author){
        em.remove(author);
    }
    
    /**
     *
     * @param author
     */
    public void update(Author author){
        em.merge(author);
    }
    
    /**
     *
     * @param Name
     * @return
     */
    public Author find(String Name){
        return em.find(Author.class, Name);
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
     * @return
     */
    public List<Author> findAll() {
        Query q = em.createQuery("select a from Author a");
        return q.getResultList();
    }

    public void removeAuthor(KMGR k, Author a){
        a = getEntityManager().getReference(Author.class, a.getName());
        k = getEntityManager().getReference(KMGR.class, k.getId());
        
        // first remove the pet from the owner
        k.removeAuthor(a);
        em.merge(k);
        
       for( Book b : a.getBooks() ){
            b.getAuthors().remove(a);
            getEntityManager().remove(b);
        }
       
       getEntityManager().remove(a);
       
    }
   

}
