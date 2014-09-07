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

/**
 *
 * @author Tianyang
 */
@Stateless
@Named
public class BookBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    public BookBean(){
        
    }
    
    /**
     *
     * @param b
     */
    public void create(Book b){
        em.persist(b);
    }
    
    /**
     *
     * @param b
     */
    public void remove(Book b){
        em.remove(b);
    }
    
    /**
     *
     * @param b
     */
    public void update(Book b){
        em.merge(b);
    }
    
    /**
     *
     * @param ISBN
     * @return
     */
    public Book find(String ISBN){
        return em.find(Book.class, ISBN);
    }
    
    
    /**
     *
     * @return
     */
    public List<Book> findAll() {
        Query q = em.createQuery("select b from Book b");
        return q.getResultList();
    }

    
    public List<Book> findByBookName(String BookName) {
        Query q = em.createQuery("select b from Book b where b.Name = ?1 ", Book.class);
        q.setParameter(1,BookName);
        return q.getResultList();
    }
    
     /**
     *
     * @return
     */
    protected EntityManager getEntityManager(){
        return this.em;
    }
    
    
    public void removeBook(KMGR k, Book book){
        book = getEntityManager().getReference(Book.class, book.getISBN());
        k = getEntityManager().getReference(KMGR.class, k.getId());
        
        // first remove the pet from the owner
        k.removeBook(book);
        em.merge(k);
        
       for( Author a : book.getAuthors() ){
            a.getBooks().remove(book);
            getEntityManager().remove(a);
        }
       
       getEntityManager().remove(book);
       
    }

}
