/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Tianyang
 */

@Entity
@NamedQuery(name = "Administrator.findByUserName", query = "select a from Administrator a where a.user.userName = :userName")
public class Administrator extends CommonUser implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "administrator")
    private List<KMGR> KMGRs = new ArrayList<>();
    
    @OneToMany
    private List<Customer> customers = new ArrayList<>();
    
    private String name;
    private int kmgrcounter = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Administrator(String name) {
        this.name = name;
    }

    public List<KMGR> getKMGRs() {
        return KMGRs;
    }

    public void setKMGRs(List<KMGR> KMGRs) {
        this.KMGRs = KMGRs;
    }

    public void addKMGR(KMGR k){
        this.KMGRs.add(k);
    }

    public Administrator() {
    }
    

    
}
