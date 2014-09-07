/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.KMGRBean;
import javax.ejb.EJB;
import domain.*;
import ejb.AuthorBean;
import ejb.BookBean;
import ejb.IdeologyBean;
import ejb.PoliticalSpectrumBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tianyang
 */

@RequestScoped
@Named
public class KnowledgeBean {
    @EJB
    private BookBean bookBean;
    @EJB
    private PoliticalSpectrumBean PSBean;
    @EJB
    private IdeologyBean ideologyBean;
    @EJB
    private AuthorBean authorBean;
    @EJB
    private KMGRBean KMGRBean;
    

    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    
    private KMGR kmgr;
    private Book book;
    private Author author;
    private Ideology ideo;
    private PoliticalSpectrum ps;
    private FacesContext context;
    
    private List<Author> authorlist;
    private List<Book> booklist;
    private List<Ideology> ideolist;
    private List<PoliticalSpectrum> pslist;
    
    private String bname;
    private String aname;
    private String iname;
    private String psbasic;
    
    @Inject
    private LoginBean loginBean;
    
    @PostConstruct
    private void init(){
        kmgr = KMGRBean.findByUserName(loginBean.getRemoteUser());
        author.setIdeology(ideo);
        book.setIdeology(ideo);
    }
 
    public String doAddAuthor(){  
        authorBean.create(author);
        kmgr.addAuthor(author);
        KMGRBean.update(kmgr);
        context.addMessage(null,new FacesMessage("Author Created"));
        return "/UserPage/KMGRPage.xhtml";
    }
    
    public String doAddBook(){  
        bookBean.create(book);
        kmgr.addBook(book);
        KMGRBean.update(kmgr);
        context.addMessage(null,new FacesMessage("Book Created"));
        return "/UserPage/KMGRPage.xhtml";
    }
    
    public String doAddIdeo(){  
        ideologyBean.create(ideo);
        kmgr.addIdeology(ideo);
        KMGRBean.update(kmgr);
        context.addMessage(null,new FacesMessage("Ideology Created"));
        return "/UserPage/KMGRPage.xhtml";
    }
    
    public String doAddPS(){  
        PSBean.create(ps);
        kmgr.addPS(ps);
        KMGRBean.update(kmgr);
        context.addMessage(null,new FacesMessage("Political Spectrum Created"));
        return "/UserPage/KMGRPage.xhtml";
    }
    
    
    public KnowledgeBean() {
        context=FacesContext.getCurrentInstance();
        book = new Book();
        author = new Author();
        ideo = new Ideology();
        ps = new PoliticalSpectrum();
        
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }


    /**
     * Set the value of author
     *
     * @param author new value of pet
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Ideology getIdeo() {
        return ideo;
    }

    public void setIdeo(Ideology ideo) {
        this.ideo = ideo;
    }

    public PoliticalSpectrum getPS() {
        return ps;
    }

    public void setPS(PoliticalSpectrum PS) {
        this.ps = PS;
    }

    public List<Author> getAuthorlist() {
        return authorlist;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public List<Ideology> getIdeolist() {
        return ideolist;
    }

    public List<PoliticalSpectrum> getPslist() {
        return pslist;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public KMGR getKmgr() {
        return kmgr;
    }
    
    
    
}
