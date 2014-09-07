/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.*;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Author;
import domain.Ideology;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Tianyang
 */

@Named
@RequestScoped
public class AuthorController {
    @EJB
    private AuthorBean authorBean;

    private static final Logger LOG = Logger.getLogger(AuthorController.class.getName());
    @Inject
    KnowledgeBean knowledgeBean;
    
    private FacesContext context;
    private Author author;
    

    
    public AuthorController() {
        context = FacesContext.getCurrentInstance();
        author = new Author();
        author.setIdeology(new Ideology());
    }

    public Author getAuthor() {
        return author;
    }
/**
     * Set the value of author
     *
     * @param author new value of author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
    
     public String doAuthorDetails(Author a){
        this.author = a;
        return "/UserPage/authorDisplay.xhtml";
    }
    
    public String doUpdateAuthor(){
        
        LOG.info("Updating author " + author.getName());
        authorBean.update(author);
        context.addMessage(null, new FacesMessage("Author has been updated"));
        return "/UserPage/KMGRPage.jsf";
    }

    public String doDeleteAuthor(){
        
        LOG.info("Deleting Author " + author.getName());
        authorBean.removeAuthor(knowledgeBean.getKmgr(), author);
        context.addMessage(null, new FacesMessage("Author has been deleted"));
        return "/UserPage/KMGRPage.jsf";
    }
    
}
