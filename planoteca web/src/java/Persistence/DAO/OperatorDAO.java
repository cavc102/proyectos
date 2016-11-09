/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.DAO;

import Logic.Administrator.Connections;
import Logic.Transformations.OperatorTransformations;
import Presentation.Model.OperatorModel;
import Presentation.Control.OperatorControl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class OperatorDAO {

     private Connections DB;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private OperatorModel Oper; 
    private OperatorControl OpCtr;
  
    
    
    
    public OperatorDAO() throws SQLException {
     this.DB = new Connections(); 
     Oper = new OperatorModel ();
     OpCtr = new OperatorControl ();
    }
  
    
    
    
    
    public boolean DBConsultOperator(String op) throws SQLException{
        boolean consul=false;
        try {
            con = DB.Conect();
            st = con.createStatement();
            rs = st.executeQuery(op);
            

            System.out.println(rs.getRow());
            while (rs.next()) {
               
                Oper = new OperatorModel();
                Oper.setNum_Id(rs.getInt("Ident_Num"));
                Oper.setType_Doc(rs.getString("Doc_Type"));
                Oper.setName_operator(rs.getString("Name"));
                Oper.setLastName_Operator(rs.getString("LastName"));
              OpCtr.ListOperator.add(Oper);
              consul=true;
            }
           
            st.close();
            con.close();
          
            
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "  consulta Operario Error1->" + e.getMessage());
            st.close();
            con.close();
            consul=false;
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    return consul;
    }

    
    
}
