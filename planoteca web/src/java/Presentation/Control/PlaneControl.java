/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Control;

import Presentation.Model.PlaneModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos
 */
@ManagedBean(name="PlaneController")
@RequestScoped
public class PlaneControl {

    /**
     * Creates a new instance of PlaneControl
     */
    private PlaneModel Plane;
    
    public PlaneControl() {
        
       this.Plane = new PlaneModel(); 
        
    }

    public PlaneModel getPlane() {
        return Plane;
    }

    public void setPlane(PlaneModel Plane) {
        this.Plane = Plane;
    }
   
    
    
    
}
