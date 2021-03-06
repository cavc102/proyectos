/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Control;

import Logic.Administrator.Connections;
import Presentation.Model.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    private String FilterUser;
    private Connections DB;
    private Connection con;
    private Statement st;
    private ResultSet rs;
private UserModel UserModel;

private String Sql;
private ArrayList<UserModel> ListUser;
    /**
     * Creates a new instance of UserControl
     */
    public UserControl() throws SQLException {
        this.DB = new Connections();
        this.UserModel = new UserModel();
    
        
    }
    
public void FilterUser(ActionEvent event)throws SQLException {
this.setSql("select a.login, a.password, a.State,a.Role,a.ID_Operator, b.Name, b.LastName FROM planoteca.user a, planoteca.operator b where Login like '%"
        +this.getFilterUser()+"%' and  a.id_operator = b.`Ident_Num`");
ConsultOper();
}
    
public void ConsultOper() throws SQLException {
        this.setListUser((ArrayList<UserModel>) new ArrayList());
        if(this.getSql()==null){
        this.setSql("select a.login, a.password, a.State,a.Role, b.Name, b.LastName"+
                "   from planoteca.user a, planoteca.operator b where a.id_operator = b.`Ident_Num`");
        
        }
        
        try {
            con = DB.Conect();
            st = con.createStatement();
            rs = st.executeQuery(this.getSql());
            
            while (rs.next()) {
               
                UserModel = new UserModel();
                
     
                UserModel.setLogin(rs.getString("Login"));
                UserModel.setPassword(rs.getString("Password"));
                UserModel.setState(rs.getString("State"));
                UserModel.setRole(rs.getString("Role"));
                UserModel.setCod_Operator(rs.getInt("ID_Operator"));
                UserModel.setNameOperator(rs.getString("Name")+" "+rs.getString("LastName"));
                
                
                this.getListUser().add(UserModel);
                System.out.println("se realizo consulta");
            }
           
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "  consulta Usuario Error1->" + e.getMessage());
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
    
    public void CreateUser(ActionEvent event)throws SQLException {
 FacesContext context = FacesContext.getCurrentInstance();

        try {
            con = DB.Conect();
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `planoteca`.`user` (`Login`, `Password`, `State`, `role`, `ID_Operator`) VALUES ('" 
                    + UserModel.getLogin() + "','" + UserModel.getPassword() +"','" + UserModel.getState() + "','" + UserModel.getRole() +"','" + UserModel.getCod_Operator() +"' )");
            
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
    
    public String Update(ActionEvent event){
    
    return ("UpdateUser.xhtml");
    }

    public String getSql() {
        return Sql;
    }

    public void setSql(String Sql) {
        this.Sql = Sql;
    }

    public ArrayList<UserModel> getListUser() {
        return ListUser;
    }

    public void setListUser(ArrayList<UserModel> ListUser) {
        this.ListUser = ListUser;
    }
    

    /**
     * @return the User
     */
    public UserModel getUserModel() {
        return UserModel;
    }

    /**
     * @param UserModel the User to set
     */
    public void setUserModel(UserModel UserModel) {
        this.UserModel = UserModel;
    }

    public String getFilterUser() {
        return FilterUser;
    }

    public void setFilterUser(String FilterUser) {
        this.FilterUser = FilterUser;
    }
    
    
    
}
