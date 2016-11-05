/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Control;

import Logic.Administrator.Connections;

import Presentation.Model.OperatorModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "OperatorController")
@RequestScoped
public class OperatorControl {

    private Connections DB;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private ArrayList<OperatorModel> ListOperator;
    private String Name;
    private String Lastname;
    private String Sql;

    private OperatorModel Oper;


    /**
     * Creates a new instance of OperatorControl
     */
    public OperatorControl() throws SQLException {
        this.DB = new Connections();
        this.ConsultOper();
    }

  
    
    public void FilterConsultOper(ActionEvent event) throws SQLException {
        
this.setSql("SELECT Ident_Num, Doc_Type, Name, LastName FROM planoteca.operator where Name LIKE '%" + this.getName()
                        + "%' and LastName LIKE '%" + this.getLastname() + "%'");
         ConsultOper();
    }

    public void ConsultOper() throws SQLException {
        this.ListOperator = new ArrayList();
        if(this.getSql()==null){
        this.setSql("SELECT Ident_Num, Doc_Type, Name, LastName FROM planoteca.operator");
        
        }
        
        try {
            con = DB.Conect();
            st = con.createStatement();
            rs = st.executeQuery(this.getSql());

            while (rs.next()) {
               
                Oper = new OperatorModel();
                Oper.setNum_Id(rs.getInt("Ident_Num"));
                Oper.setType_Doc(rs.getString("Doc_Type"));
                Oper.setName_operator(rs.getString("Name"));
                Oper.setLastName_Operator(rs.getString("LastName"));
                this.ListOperator.add(Oper);
            }
           
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "  consulta Operario Error1->" + e.getMessage());
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
    
    
   public void CreateOperator(ActionEvent event)throws SQLException {
 FacesContext context = FacesContext.getCurrentInstance();

        try {
            con = DB.Conect();
            st = con.createStatement();
            st.executeUpdate("INSERT INTO `planoteca`.`operator` (`Ident_Num`, `Doc_Type`, `Name`, `LastName`) VALUES ('" 
                    + Oper.getNum_Id() + "','" + Oper.getType_Doc() +"','" + Oper.getName_operator() + "','" + Oper.getLastName_Operator() +"' )");
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful","El Operario Fue Creado" ) );
            
            System.out.println("User Operator");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "CreaOperario Error->" + e.getMessage());
            
           
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
    
    
    
    

    public ArrayList<OperatorModel> getListOperator() {
        return ListOperator;
    }

    public void setListOperator(ArrayList<OperatorModel> ListOperator) {
        this.ListOperator = ListOperator;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getSql() {
        return Sql;
    }

    public void setSql(String Sql) {
        this.Sql = Sql;
    }

    public OperatorModel getOper() {
        return Oper;
    }

    public void setOper(OperatorModel Oper) {
        this.Oper = Oper;
    }

    
}
