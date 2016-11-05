/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Model;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class UserModel {
    
    private String Login;
    private String Password;
    private String State;
    private String Role;
    private int Cod_Operator;

    public UserModel() {
    }

    
    
    
    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Cod_Operator
     */
    public int getCod_Operator() {
        return Cod_Operator;
    }

    /**
     * @param Cod_Operator the Cod_Operator to set
     */
    public void setCod_Operator(int Cod_Operator) {
        this.Cod_Operator = Cod_Operator;
    }
    
    
    
}
