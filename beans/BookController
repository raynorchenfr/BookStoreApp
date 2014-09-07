/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import domain.Book;
import domain.Ideology;
import ejb.BookBean;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tianyang
 */

@Named
@RequestScoped
public class BookController {
    @EJB
    private BookBean bookBean;

    private static final Logger LOG = Logger.getLogger(AuthorController.class.getName());
    @Inject
    KnowledgeBean knowledgeBean;
    
    private FacesContext context;
    private Book book;
    

    
    public BookController() {
        context = FacesContext.getCurrentInstance();
        book = new Book();
        book.setIdeology(new Ideology());
    }

    public Book getBook() {
        return book;
    }
    /**
     * Set the value of author
     *
     * @param book new value of author
     */
    public void setBook(Book book) {
        this.book = book;
    }
    
     public String doBookDetails(Book b){
        this.book = b;
        return "/UserPage/bookDisplay.xhtml";
    }
    
    public String doUpdateBook(){ 
        LOG.info("Updating Book " + book.getName());
        bookBean.update(book);
        context.addMessage(null, new FacesMessage("book has been updated"));
        return "/UserPage/KMGRPage.jsf";
    }

    public String doDeleteBook(){
        
        LOG.info("Deleting Book" + book.getName());
        bookBean.removeBook(knowledgeBean.getKmgr(), book);
        context.addMessage(null, new FacesMessage("Book has been deleted"));
        return "/UserPage/KMGRPage.jsf";
    }
    
    
}
