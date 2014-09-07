/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.PoliticalSpectrum;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tianyang
 */
@Stateless
@Named("PSBean")
public class PoliticalSpectrumBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    
    
    /**
     *
     * @param PS
     */
    public void create(PoliticalSpectrum PS){
        em.persist(PS);
    }
    
    /**
     *
     * @param PS
     */
    public void remove(PoliticalSpectrum PS){
        em.remove(PS);
    }
    
    /**
     *
     * @param PS
     */
    public void update(PoliticalSpectrum PS){
        em.merge(PS);
        
    }
    
    /**
     *
     * @param Basic
     * @return
     */
    public PoliticalSpectrum find(String Basic){
        return em.find(PoliticalSpectrum.class, Basic);
    }
    
    /**
     *
     * @return
     */
    public List<PoliticalSpectrum> findAll(){
        Query q = em.createQuery("select p from PolticalSpectrum p", PoliticalSpectrum.class);
        return q.getResultList();
    }

}
