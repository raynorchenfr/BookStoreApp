/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Tianyang
 */
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ISBN;
    private String Name;
    @ManyToMany
    private List<Author> authors;
    @ManyToOne
    private Ideology ideology;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityTime;
    

    public Book(String ISBN, String Name, List<Author> authors, Ideology ideology) {
        this.ISBN = ISBN;
        this.Name = Name;
        this.authors = authors;
        this.ideology = ideology;
    }

    public Book() {
    }

    /**
     * @param Name
     */
    
    public Book(String Name) {
        this.Name = Name;
    }

    public Book(String Name, List<Author> authors) {
        this.Name = Name;
        this.authors = authors;
    }
    
    @PrePersist
    @PreUpdate
    @PreRemove
    public void accessed(){
        this.activityTime = new Date();
    }
    
    /**
     * @param newAuthor
     */
    public void addAuthor(Author newAuthor){
        if(!this.authors.contains(newAuthor))
            this.authors.add(newAuthor);
    }
    

    

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * @param Name
     */
    public Ideology getIdeology() {
        return ideology;
    }

    public void setIdeology(Ideology ideology) {
        this.ideology = ideology;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        return true;
    }

    
    

    public String listWriters(){
        String ANameList = "";
        for (int i=0; i< authors.size(); i++){
            ANameList = ANameList + authors.get(i).getName() + ", ";
        }
        return ANameList;
    }

    
    
    
}
