/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Tianyang
 */
@Entity
@NamedQuery(name = "Customer.findByUserName", query = "select c from Customer c where c.user.userName = :userName")
public class Customer extends CommonUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nickName;
    

    @OneToMany
    private List<Book> BookInCart = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public Customer(String nickName) {
        this.nickName = nickName;
    }

    
    public List<Book> getBookInCart() {
        return BookInCart;
    }

    public void setBookInCart(List<Book> BookInCart) {
        this.BookInCart = BookInCart;
    }
    
    /**
     * @param book
     */
    public void addBook(Book book){
        if (!this.BookInCart.contains(book))
        this.BookInCart.add(book);
    }
    
    public void removeBook(Book book){
        if (this.BookInCart.contains(book))
        this.BookInCart.remove(book);
    }

    public User getUser() {
        return user;
    }
    
 
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Customer() {
    }
  
    
    
}
