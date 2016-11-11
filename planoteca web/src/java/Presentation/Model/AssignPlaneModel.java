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
public class AssignPlaneModel {
    
    private int IdAssignPlane;
    private String CodPlane;
    private Date DateReturn;
    private int IdAssign;

    /**
     * @return the IdAssignPlane
     */
    public int getIdAssignPlane() {
        return IdAssignPlane;
    }

    /**
     * @param IdAssignPlane the IdAssignPlane to set
     */
    public void setIdAssignPlane(int IdAssignPlane) {
        this.IdAssignPlane = IdAssignPlane;
    }

    /**
     * @return the CodPlane
     */
    public String getCodPlane() {
        return CodPlane;
    }

    /**
     * @param CodPlane the CodPlane to set
     */
    public void setCodPlane(String CodPlane) {
        this.CodPlane = CodPlane;
    }

    /**
     * @return the DateReturn
     */
    public Date getDateReturn() {
        return DateReturn;
    }

    /**
     * @param DateReturn the DateReturn to set
     */
    public void setDateReturn(Date DateReturn) {
        this.DateReturn = DateReturn;
    }

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
    
    
    
}
