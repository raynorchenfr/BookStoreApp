/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Customer;
import domain.security.Group;
import domain.security.User;
import ejb.CustomerBean;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tianyang
 */

@Named
@RequestScoped
public class CustomerController {
    @EJB
    private CustomerBean customerBean;
    @EJB
    private UserBean userBean;
    @EJB
    private GroupBean groupBean;
    private FacesContext context;
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());
    
    private Customer customer;
    private User user;
    private Group group;
    private String username;
    private String password;

    public CustomerController() {
        context = FacesContext.getCurrentInstance();
        user = new User();
        group = new Group();
        customer = new Customer();
        username = new String();
        password = new String();
        
        
    }
    
    @PostConstruct
    private void init(){
        group = groupBean.findByGroupName("Customers");
        user.setUserName(username);
        user.setPassword(password);
        user.addGroup(group);
        customer.setUser(user);
    }
    
    
    public String doCreateCustomer(){

        LOG.info("creating user " + user.getUserName());
        userBean.create(user);
        LOG.info("creating customer " + customer.getNickName());
        customerBean.create(customer);
        LOG.info("checkpoint for process");
        context.addMessage(null, new FacesMessage("Your account has been created"));
        return "/login.xhtml";
    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    
    
}
