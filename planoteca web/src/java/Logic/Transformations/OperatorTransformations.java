/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Transformations;
import Persistence.DAO.OperatorDAO;
import Presentation.Control.OperatorControl;
import java.sql.SQLException;
/**
 *
 * @author Administrador
 */

public class OperatorTransformations {
    private OperatorControl Oper;
    private OperatorDAO OperDAO;

    public OperatorTransformations() throws SQLException {
       
        this.OperDAO = new OperatorDAO();
    }
    
    
    private String Sql;
    
    public boolean ConsulOperator(String Name, String LastName) throws SQLException{
        boolean State=false;
    this.setSql("SELECT Ident_Num, Doc_Type, Name, LastName FROM planoteca.operator where Name LIKE '%" + Name
                        + "%' and LastName LIKE '%" + LastName + "%'");
    
    State=OperDAO.DBConsultOperator(this.getSql());
    
    return State;
    }

    /**
     * @return the Sql
     */
    public String getSql() {
        return Sql;
    }

    /**
     * @param Sql the Sql to set
     */
    public void setSql(String Sql) {
        this.Sql = Sql;
    }
 
    
    
    
    
    
    
    
    
    
    
    
}
