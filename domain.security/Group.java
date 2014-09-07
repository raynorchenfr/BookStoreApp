/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sspyriso
 * 
 * 
 */

/*
 * This is copied from the example codes, since it is already perfectly written 
 * modified and adapted by Rui Chen(Tianyang is the username of this pc)
 */
@Entity
@Table(name = "GROUPS")
@NamedQuery(name = "Group.findByGroupName", query = "select g from Group g where g.groupName = :groupName")
public class Group implements Serializable {

    @Id
    private String groupName;
    private String groupDesc;
    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /**
     *
     * @param u
     */
    public void addUser(User u) {
        if (!this.users.contains(u)) {
            this.users.add(u);
        }
        if (!u.getGroups().contains(this)) {
            u.getGroups().add(this);
        }
    }

    /**
     *
     */
    public Group() {
    }

    /**
     *
     * @param groupName
     * @param groupDesc
     */
    public Group(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    /**
     * Get the value of groupName
     *
     * @return the value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Set the value of groupName
     *
     * @param groupName new value of groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Get the value of groupDesc
     *
     * @return the value of groupDesc
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * Set the value of groupDesc
     *
     * @param groupDesc new value of groupDesc
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
