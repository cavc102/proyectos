/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Control;

import Logic.Administrator.Connections;
import Presentation.Model.IndexModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean(name="IndexController")
@SessionScoped
public class IndexControl {
    
    private IndexModel login;
    private Connections DB;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private String NameUser;
    private String CodOper;
    private String StateUser;
    private String RoleUser;
    private String LoginUser;
    private String PasswordUser;
    

    /**
     * Creates a new instance of IndexControl
     */
    public IndexControl() {
     this.DB = new Connections(); 
     this.login = new IndexModel();
    }

    
   
    public void ConsultLogin(ActionEvent event) throws SQLException{
        FacesContext context = FacesContext.getCurrentInstance();
       
        
        try {
            con = DB.Conect();
            st = con.createStatement();
            rs = st.executeQuery("select a.login, a.password, a.State,a.Role,a.ID_Operator, b.Name, b.LastName FROM planoteca.user a, planoteca.operator b where a.Login = '"
            + login.getLogin()+"' and a.password = '" + login.getPassword()+"' and a.ID_Operator = b.Ident_Num");
            
            
             while (rs.next()) {
               this.setLoginUser(rs.getString("Login"));
                this.setPasswordUser(rs.getString("Password"));
                this.setStateUser(rs.getString("State"));
                this.setRoleUser(rs.getString("Role"));
                this.setCodOper(rs.getString("ID_Operator"));
                this.setNameUser(rs.getString("Name")+" "+rs.getString("LastName"));  
                
             System.out.println(this.getNameUser());
             }
             if(this.getRoleUser()!=null){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful","Bienvenido (a): " +this.getNameUser() ) );
             ExternalContext externalContext =  context.getExternalContext();
    externalContext.redirect("Template.xhtml");
             }else{
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","El Usuario o Password No Son Correctos" ) );
            
             }
            
            st.close();
            con.close();
            
         
            
        }catch (Exception e) {
            System.out.println(this.getClass().getName() + "  consulta de Usuario Login Error1->" + e.getMessage());
            st.close();
            con.close();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(OperatorControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
   
    }

       
    public String getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(String LoginUser) {
        this.LoginUser = LoginUser;
    }

    public String getPasswordUser() {
        return PasswordUser;
    }

    public void setPasswordUser(String PasswordUser) {
        this.PasswordUser = PasswordUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public String getCodOper() {
        return CodOper;
    }

    public void setCodOper(String CodOper) {
        this.CodOper = CodOper;
    }

    public String getStateUser() {
        return StateUser;
    }

    public void setStateUser(String StateUser) {
        this.StateUser = StateUser;
    }

    public String getRoleUser() {
        return RoleUser;
    }

    public void setRoleUser(String RoleUser) {
        this.RoleUser = RoleUser;
    }
    
    
    
    
    public IndexModel getLogin() {
        return login;
    }

    public void setLogin(IndexModel login) {
        this.login = login;
    }
    
}
