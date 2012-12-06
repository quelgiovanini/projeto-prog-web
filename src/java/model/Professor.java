/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Quele
 */

public class Professor extends Pessoa implements Serializable {
    private Area area;
    
    public Professor(String nome, String email, String matricula, Area area){
        super(nome, email, matricula);
        this.setArea(area);
    }

    public Professor() {
        
    }
    
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return (super.toString() + 
                "Area: \n" + getArea() + "\n");
    }    
    
}
