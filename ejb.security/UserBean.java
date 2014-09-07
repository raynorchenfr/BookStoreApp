/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.User;
import ejb.AbstractUserBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sspyriso
 */

/*
 * This is copied from the example codes, since it is already perfectly written 
 * modified and adapted by Rui Chen(Tianyang is the username of this pc)
 */

@Stateless
public class UserBean extends AbstractUserBean<User> {

    /**
     *
     */
    public UserBean() {
        super(User.class);
    }

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return super.findAll("select u from User u");
    }
}
