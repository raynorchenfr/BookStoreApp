/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CustomerBean;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import domain.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Tianyang
 */

@RequestScoped
@Named        
public class CartBean {
    @EJB
    private CustomerBean customerBean;
    
    private Book boughtBook;
    private Customer customer;
    private FacesContext context;
    private List cartlist;
    
    private static final Logger LOG = Logger.getLogger(CartBean.class.getName());


    public CartBean() {
        context = FacesContext.getCurrentInstance();
        customer = new Customer(); 
        cartlist = new ArrayList<Book>();

    }
    
    @PostConstruct
    private void init() {
        customer = customerBean.findByUserName(context.getExternalContext().getRemoteUser());
        //set something
        boughtBook = new Book();
    }
    
    public String doPlaceBook(){
        LOG.info("Adding book " + boughtBook.getName() + " to your cart");
        customer.addBook(boughtBook);
        customerBean.update(customer);
        context.addMessage(null, new FacesMessage("Book order successfully placed!"));

        return "/UserPage/CustomerPage.xhtml";
    

    }
    
    public String doRemoveBook(Book tempBook){
        LOG.info("Remove Book " + boughtBook.getName() + " from your cart");
        customer.removeBook(tempBook);
        customerBean.update(customer);
        context.addMessage(null, new FacesMessage("Book order successfully removed!"));

        return "/UserPage/CustomerPage.xhtml";
    

    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public Book getBoughtBook() {
        return boughtBook;
    }

    public Customer getCustomer() {
        return customer;
    }

    public FacesContext getContext() {
        return context;
    }

    public List getCartlist() {
        return cartlist;
    }
    
    
}
