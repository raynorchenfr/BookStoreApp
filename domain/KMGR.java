/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Tianyang
 */
@Entity
@NamedQuery(name = "KMGR.findByUserName", query = "select k from KMGR k where k.user.userName = :userName")
public class KMGR extends CommonUser implements Serializable {
    
    
    @ManyToOne
    private Administrator administrator;
    
    private String name;

    @OneToMany
    private List<Author> managedAuthors;
    @OneToMany
    private List<Book> managedBooks;
    @OneToMany
    private List<Ideology> managedIdeos;
    @OneToMany
    private List<PoliticalSpectrum> managedPSs;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public KMGR(String name) {
        this.name = name;
    }

    public KMGR() {
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getManagedAuthors() {
        return managedAuthors;
    }

    public void addAuthor(Author newAuthor){
        if(!this.managedAuthors.contains(newAuthor))
            this.managedAuthors.add(newAuthor);
    }
    
    public void removeAuthor(Author author){
        if(this.managedAuthors.contains(author))
            this.managedAuthors.remove(author);
    }
    
    public void setManagedAuthors(List<Author> managedAuthors) {
        this.managedAuthors = managedAuthors;
    }

    public List<Book> getManagedBooks() {
        return managedBooks;
    }
    
    public void addBook(Book newBook){
        if(!this.managedBooks.contains(newBook))
            this.managedBooks.add(newBook);
    }
    
    public void removeBook(Book book){
        if(this.managedBooks.contains(book))
            this.managedBooks.remove(book);
    }

    public void setManagedBooks(List<Book> managedBooks) {
        this.managedBooks = managedBooks;
    }

    public List<Ideology> getManagedIdeos() {
        return managedIdeos;
    }
    
    public void addIdeology(Ideology newIdeo){
        if(!this.managedIdeos.contains(newIdeo))
            this.managedIdeos.add(newIdeo);
    }
    
    public void removeIdeology(Ideology Ideo){
        if(this.managedIdeos.contains(Ideo))
            this.managedIdeos.remove(Ideo);
    }
    
    public void setManagedIdeos(List<Ideology> managedIdeos) {
        this.managedIdeos = managedIdeos;
    }

    public List<PoliticalSpectrum> getManagedPSs() {
        return managedPSs;
    }
    
    public void addPS(PoliticalSpectrum newPS){
        if(!this.managedPSs.contains(newPS))
            this.managedPSs.add(newPS);
    }
    
    public void removePS(PoliticalSpectrum PS){
        if(!this.managedPSs.contains(PS))
            this.managedPSs.add(PS);
    }

    public void setManagedPSs(List<PoliticalSpectrum> managedPSs) {
        this.managedPSs = managedPSs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    

    

 
}
