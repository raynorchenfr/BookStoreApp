/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Administrator;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tianyang
 */
@Stateless
@Named
public class AdministratorBean extends AbstractUserBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    

    
    public AdministratorBean(){
        super(Administrator.class);
    }
    
    

    
    public List<Administrator> findAll(){
        return super.findAll("select a from Administrator a");
    }
    
    public Administrator findByUserName(String userName){
        TypedQuery<Administrator> query = getEntityManager().createNamedQuery("Administrator.findByUserName", Administrator.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }
}
