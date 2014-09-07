/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
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
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Name;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
    @ManyToOne
    private Ideology ideology;
    @Embedded
    private Biography Biography;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityTime;
    

    public Author() {
      
    }

    public Author(String Name) {
        this.Name = Name;
    }
    
    

    public Author(String Name, List<Book> books, Ideology ideology) {
        this.Name = Name;
        this.books = books;
        this.ideology = ideology;
    }
    
    /**
     * @param Name
     */

 
    public Biography getBiography() {
        return Biography;
    }

    public void setBiography(Biography Biography) {
        this.Biography = Biography;
    }
    
    
    /**
     * @param newbook
     */
    public void addBook(Book newbook){
        this.books.add(newbook);
        
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Ideology getIdeology() {
        return ideology;
    }

    public void setIdeology(Ideology ideology) {
        this.ideology = ideology;
    }
    
    @PrePersist
    @PreUpdate
    @PreRemove
    public void accessed(){
        this.activityTime = new Date();
    }
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Name != null ? Name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.Name == null && other.Name != null) || (this.Name != null && !this.Name.equals(other.Name))) {
            return false;
        }
        return true;
    }

    public String listWorks(){
        String BNameList = "";
        for (int i=0; i< books.size(); i++){
            BNameList = BNameList + books.get(i).getName()+ ", ";
        }
        return BNameList;
    }

    
    
}
