/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Control;

import Logic.Administrator.Connections;
import Presentation.Model.UserModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Carlos
 */
@ManagedBean(name="UserController")
@SessionScoped
public class UserControl {
    
    private Connections DB;
    private Connection con;
    private Statement st;
private UserModel User;
    /**
     * Creates a new instance of UserControl
     */
    public UserControl() {
        this.DB = new Connections();
        this.User = new UserModel();
        
    }
    

    
    
    
    public void CreateUser(ActionEvent event)throws SQLException {
 FacesContext context = FacesContext.getCurrentInstance();

        try {
            con = DB.Conect();
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `planoteca`.`user` (`Login`, `Password`, `State`, `role`, `ID_Operator`) VALUES ('" 
                    + User.getLogin() + "','" + User.getPassword() +"','" + User.getState() + "','" + User.getRole() +"','" + User.getCod_Operator() +"' )");
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful","El Usuario Fue Creado" ) );
            
            System.out.println("User Create");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "CreaUsuario Error->" + e.getMessage());
            
           
            st.close();
            con.close();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
    

    /**
     * @return the User
     */
    public UserModel getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(UserModel User) {
        this.User = User;
    }
    
    
    
}
