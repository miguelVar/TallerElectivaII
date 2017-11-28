/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.logic;

/**
 *
 * @author miguel
 */
public class Son {
    
    private String nombre;
    private String apellido;
    private String fecha_Nac;
    private String id_user;

    public Son(String nombre, String apellido, String fecha_Nac, String id_user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_Nac = fecha_Nac;
        this.id_user = id_user;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(String fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Son{" + "nombre=" + nombre + ", apellido=" + apellido + ", fecha_Nac=" + fecha_Nac + ", id_user=" + id_user + '}';
    }

    
    
    
    
    
    
    
}
