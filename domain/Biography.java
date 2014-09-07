/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Embeddable;

/**
 *
 * @author Tianyang
 */

@Embeddable
public class Biography {
    private String Title;
    private List<String> BioEntries;

    public Biography(String Title, List<String> BioEntries) {
        this.Title = Title;
        this.BioEntries = BioEntries;
    }

    public Biography(String Title) {
        this.Title = Title;
    }
    
    
    //this is a dummy method to generate a biography of certain length for the authors
    public void printBio() {
        System.out.println(Title);
        for(String entry : BioEntries){
        System.out.println(entry);
        }
    }
    //it will also be possible that such operations can be achieved by
    //inputting files

    public Biography() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public List<String> getBioEntries() {
        return BioEntries;
    }

    public void setBioEntries(List<String> BioEntries) {
        this.BioEntries = BioEntries;
    }

    @Override
    public String toString() {
        String retstring;
        retstring = Title;
        int size = BioEntries.size();
        for(int i=0; i<= size && BioEntries != null; i++ ){
            retstring = retstring+ "\t" + BioEntries.get(i);
        }
        return retstring;
    }
    
    
}
