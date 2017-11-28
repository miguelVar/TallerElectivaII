/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.persistence;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class ConnectBD {
    public String DRIVER="com.mysql.jdbc.Driver";
    public String URL="jdbc:mysql://localhost:3306/login";
    public String USER="root";
    public String PASSWORD="root";
    private Connection connection;
    
    
    public boolean connect(){
        boolean state=false;
        
        try {
            Class.forName(DRIVER).newInstance();
            connection=(Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            state=true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return state;
    }
    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

