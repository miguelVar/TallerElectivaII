/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class ManagementUser {
    
    public DaoUser daoUser;

    public ManagementUser() {
        daoUser=new DaoUser();
        
    }
    public String usuarios(String email,String pass){
        return daoUser.queryUser(email,pass);
    }
    public String nombre(){
        return daoUser.prueba();
    }
    
    public ArrayList<Son> hijos(String id){
        return daoUser.querySon(id);
    }
    
    public void insertarUsuario(String id,String nombre,String apellido,String email,String pass){
        daoUser.insertar(id, nombre, apellido, email, pass);
    }
    
    public int validateCorreo(String email){
        return daoUser.correo(email);
    }
    
    public int validateId(String id){
        return daoUser.idUser(id);
    }
    
}
