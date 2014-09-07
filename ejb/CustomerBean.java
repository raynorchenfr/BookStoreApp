/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tianyang
 */
@Stateless
@Named
public class CustomerBean extends AbstractUserBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public void createCustomer(Customer newCustomer){
    getEntityManager().persist(newCustomer);

    }

    public CustomerBean(){
        super(Customer.class);
    }

    
    
    /**
     *
     * @return
     */
    public List<Customer> findAllAlternate(){
        Query Q = getEntityManager().createQuery("select c from Customer c");
        return Q.getResultList();
    }
    
    public List<Customer> findAll(){
        return super.findAll("select c from Customer c");
    }
    
    /**
     *
     * @param userName
     * @return
     */
    
    
    public Customer findByUserName(String userName){
        TypedQuery<Customer> query = getEntityManager().createNamedQuery("Customer.findByUserName", Customer.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
}
}
