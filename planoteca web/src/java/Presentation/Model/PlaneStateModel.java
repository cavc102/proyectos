/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Model;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class PlaneStateModel {
    
    private int IdAssign;
    private int IdUserSystem;
    private int IdUserAssign;
    private String Area;
    private Date DateAssign;

    /**
     * @return the IdAssign
     */
    public int getIdAssign() {
        return IdAssign;
    }

    /**
     * @param IdAssign the IdAssign to set
     */
    public void setIdAssign(int IdAssign) {
        this.IdAssign = IdAssign;
    }

    /**
     * @return the IdUserSystem
     */
    public int getIdUserSystem() {
        return IdUserSystem;
    }

    /**
     * @param IdUserSystem the IdUserSystem to set
     */
    public void setIdUserSystem(int IdUserSystem) {
        this.IdUserSystem = IdUserSystem;
    }

    /**
     * @return the IdUserAssign
     */
    public int getIdUserAssign() {
        return IdUserAssign;
    }

    /**
     * @param IdUserAssign the IdUserAssign to set
     */
    public void setIdUserAssign(int IdUserAssign) {
        this.IdUserAssign = IdUserAssign;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * @return the DateAssign
     */
    public Date getDateAssign() {
        return DateAssign;
    }

    /**
     * @param DateAssign the DateAssign to set
     */
    public void setDateAssign(Date DateAssign) {
        this.DateAssign = DateAssign;
    }
    
    
    
    
    
    
}
