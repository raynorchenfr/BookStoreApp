/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.Group;
import ejb.AbstractUserBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sspyriso
 */

/*
 * This is copied from the example codes, since it is already perfectly written 
 * modified and adapted by Rui Chen(Tianyang is the username of this pc)
 */

@Stateless
public class GroupBean extends AbstractUserBean<Group>{
    

    EntityManager em;
    /**
     *
     */
    public GroupBean() {
        super(Group.class);
        
    }

    /**
     *
     * @return
     */
    public List<Group> findAll(){
        return super.findAll("select g from Group g");
    }
    
    /**
     *
     * @param groupname
     */
    public Group findCustomersbyGroupName(){
        em = getEntityManager();
        Query query = em.createQuery("select g from Group g where g.GROUPNAME='Customers'");
        Group tempGroup;
        tempGroup = (Group)query.getSingleResult();
        return tempGroup;
    }
    public Group findByGroupName(String groupName){
        TypedQuery<Group> query = getEntityManager().createNamedQuery("Group.findByGroupName", Group.class);
        query.setParameter("groupName", groupName);
        return query.getSingleResult();
}
}
