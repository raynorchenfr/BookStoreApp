/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sspyriso
 */

/*
 * Modified and adapted by Rui Chen
 */
@SessionScoped
@Named
public class LoginBean implements Serializable{

    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    private String username;
    private String password;

    public LoginBean() {
    }
    
    public boolean isKMGR(){
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("KMGR");
    }

    public boolean isCustomer(){
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("CUSTOMER");
    }

    public boolean isAdmin(){
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN");
    }

    
    public String getRemoteUser(){
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
    
    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(username, password);
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Login", "Bad Login"));
            LOG.log(Level.SEVERE, null, ex);
            return "/login.xhtml";
        }
        
        
        if (context.getExternalContext().isUserInRole("KMGR")){
            return "/UserPage/KMGRPage.xhtml";
        }
        else if (context.getExternalContext().isUserInRole("ADMIN")){
            return "/UserPage/AdminPage.xhtml";
        }
        else if (context.getExternalContext().isUserInRole("Customer")){
            return "/UserPage/CustomerPage.xhtml";
        }
        
        return "/UserPage/welcomeGeneric.xhtml";
    }
    
     public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Logout", "Bad Logout"));
            LOG.log(Level.SEVERE, null, ex);
        }
        return "/login.xhtml";
    }
     
 
}
