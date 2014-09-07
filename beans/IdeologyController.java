/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import domain.Ideology;
import ejb.IdeologyBean;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tianyang
 */
@Named
@RequestScoped
public class IdeologyController {
    
    @EJB
    private IdeologyBean ideologyBean;

    private static final Logger LOG = Logger.getLogger(AuthorController.class.getName());
    @Inject
    KnowledgeBean knowledgeBean;
    
    private FacesContext context;
    private Ideology ideo;


    
    public IdeologyController() {
        context = FacesContext.getCurrentInstance();
        ideo = new Ideology();

    }

    public Ideology getIdeology() {
        return ideo;
    }
/**
     * Set the value of author
     *
     * @param ideo new value of author
     */
    public void setAuthor(Ideology ideo) {
        this.ideo = ideo;
    }
    
     public String doIdeologyDetails(Ideology i){
        this.ideo = i;
        return "/UserPage/IdeologyDisplay.xhtml";
    }
    
 
    public String doDeleteIdeology(){
        
        LOG.info("Deleting Author " + ideo.getName());
        ideologyBean.removeIdeology(knowledgeBean.getKmgr(), ideo);
        context.addMessage(null, new FacesMessage("Ideology has been deleted"));
        return "/UserPage/KMGRPage.jsf";
    }

    public Ideology getIdeo() {
        return ideo;
    }
    
}
