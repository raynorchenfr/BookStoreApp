/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import domain.security.User;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Tianyang
 */


@MappedSuperclass
public class CommonUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityTime;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    @PrePersist
    @PreUpdate
    @PreRemove
    public void accessed(){
        this.activityTime = new Date();
        
    }

    /**
     * Get the value of activityTime
     *
     * @return the value of activityDate
     */
    public Date getActivityTime() {
        return activityTime;
    }

    /**
     * Set the value of activityTime
     *
     * @param activityDate new value of activityDate
     */
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    
    
}
