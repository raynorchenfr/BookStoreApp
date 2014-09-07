/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embeddable;



/**
 *
 * @author Tianyang
 */
@Embeddable
public class IdeoDescription implements Serializable {
    private String ideoName;
    private List<String> Descriptions;

    public String getName() {
        return ideoName;
    }

    public void setName(String ideoName) {
        this.ideoName = ideoName;
    }

    public List<String> getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(List<String> Descriptions) {
        this.Descriptions = Descriptions;
    }

    public void printDescription(){
        System.out.println(ideoName);
        for(String entry : Descriptions){
        System.out.println(entry);
        }
    }
   

}
