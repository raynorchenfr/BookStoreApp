/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Tianyang
 */
@Entity
public class PoliticalSpectrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Basic;
    //basic marking, or abbreviation for the spectrum, i.e: right wing/ left wing/ 
    @OneToOne
    Ideology ideology;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityTime;
    
    

    public PoliticalSpectrum() {
    }

    public PoliticalSpectrum(String Basic, Ideology ideology) {
        this.Basic = Basic;
        this.ideology = ideology;
        
    }
    
    /**
     * @param Basic
     */

    public PoliticalSpectrum(String Basic) {
        this.Basic = Basic;
    }
    
    

    public Ideology getIdeology() {
        return ideology;
    }

    public void setIdeology(Ideology ideology) {
        this.ideology = ideology;
    }


    
    public String getBasic() {
        return Basic;
    }

    public void setBasic(String Basic) {
        this.Basic = Basic;
    }
    
    @PrePersist
    @PreUpdate
    @PreRemove
    public void accessed(){
        this.activityTime = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Basic != null ? Basic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliticalSpectrum)) {
            return false;
        }
        PoliticalSpectrum other = (PoliticalSpectrum) object;
        if ((this.Basic == null && other.Basic != null) || (this.Basic != null && !this.Basic.equals(other.Basic))) {
            return false;
        }
        return true;
    }

    

    
    
}
