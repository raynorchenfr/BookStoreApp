/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class Ideology implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Name;
    //basic name for the ideology, i.e. Liberalism, Libertarianism.
    @OneToMany(mappedBy = "ideology")
    private List<Book> book = new ArrayList<Book>();
    @OneToMany(mappedBy = "ideology")
    private List<Author> author = new ArrayList<Author>();
    
    @Embedded
    private IdeoDescription ideoDescription;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityTime;
    

    public IdeoDescription getIdeoDescription() {
        return ideoDescription;
    }

    public void setIdeoDescription(IdeoDescription ideoDescription) {
        this.ideoDescription = ideoDescription;
    }

    
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }


    public Ideology() {
    }
    
    /**
     * @param Name
     */

    public Ideology(String Name) {
        this.Name = Name;
    }

    public Ideology(String Name, IdeoDescription ideoDescription) {
        this.Name = Name;
        this.ideoDescription = ideoDescription;
    }
    
    public void addAuthor(Author newAuthor){
        if(!this.author.contains(newAuthor))
            this.author.add(newAuthor);
    }

    /**
     * @param newBook
     */
    public void addBook(Book newBook){
        if(!this.book.contains(newBook))
            this.book.add(newBook);
        
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
        if (!(object instanceof Ideology)) {
            return false;
        }
        Ideology other = (Ideology) object;
        if ((this.Name == null && other.Name != null) || (this.Name != null && !this.Name.equals(other.Name))) {
            return false;
        }
        return true;
    }

    public String listBooks(){
        String BNameList = "";
        for (int i=0; i< book.size(); i++){
            BNameList = BNameList + book.get(i).getName();
        }
        return BNameList;
    }
    
    public String listWriters(){
        String ANameList = "";
        for (int i=0; i< author.size(); i++){
            ANameList = ANameList + author.get(i).getName() + ", ";
        }
        return ANameList;
    }
}
