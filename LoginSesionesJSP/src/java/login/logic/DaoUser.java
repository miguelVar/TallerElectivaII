/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.logic;

import static com.sun.codemodel.JOp.lt;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.persistence.ConnectBD;

/**
 *
 * @author miguel
 */
public class DaoUser {

    private ConnectBD connectBD;

    public DaoUser() {

        connectBD = new ConnectBD();
    }

    public String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());
        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        //algoritmo y arreglo md5
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        //clave encriptada
        return h.toString();
    }

    public String queryUser(String email, String pass) {
        String nombre = "";

        try {
            String pass2 = md5(pass);
            connectBD.connect();
            Statement comando = connectBD.getConnection().createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM user where email='" + email + "' and password='" + pass2 + "'");
            if (rs.next() == true) {
                nombre = rs.getString(1);
            } else {
                nombre = "No hay resgistros";
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombre;
    }

    public ArrayList<Son> querySon(String idFather) {
        ArrayList<Son> sons = new ArrayList<>();
        sons.clear();

        try {
            connectBD.connect();
            Statement comando = connectBD.getConnection().createStatement();
            // ResultSet rs=comando.executeQuery("SELECT * FROM son where id_user='"+idFather+"'");
            ResultSet rs = comando.executeQuery("SELECT * FROM son");
            while (rs.next()) {
                sons.add(new Son(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sons;
    }

    public void insertar(String id, String nombre, String apellido, String email, String pass) {
        try {
            String psw = md5(pass);
            connectBD.connect();
            Statement comando = connectBD.getConnection().createStatement();
            PreparedStatement ps = connectBD.getConnection().prepareStatement("insert into user values(?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, email);
            ps.setString(5, psw);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String prueba() {
        return "Miguel";
    }

    public int correo(String email) {
        int num=0;
        try {
            connectBD.connect();
            Statement comando = connectBD.getConnection().createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM user WHERE email='" + email + "'");

            if (rs.next() == true) {
                num= 7;
            } else {
                num= 0;
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }


}
