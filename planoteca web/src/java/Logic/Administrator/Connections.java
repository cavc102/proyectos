package Logic.Administrator;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Connections {
    
    private Connection connection = null;
    
    public Connection Conect(){
        
     try{
     
     Class.forName("com.mysql.jdbc.Driver");
     
     connection =  DriverManager.getConnection(Settings.SERVER, Settings.LOGIN, Settings.PASSWORD);
     
     System.out.println(" la conexion al servidor "+Settings.SERVER+"  a sido exitosa");
     
     }catch(ClassNotFoundException | SQLException ex ){
     System.out.println(this.getClass().getName() + "->genera_conexion(), Error1->" + ex.getMessage());
            connection = null;
     
     }catch (Exception e) {
            System.out.println(this.getClass().getName() + "->genera_conexion(), Error1->" + e.getMessage());
            connection = null;
        }
         
     return connection;    
         
         
    }
    
    
    
}
