/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isr;

/**
 *
 * @author HP
 */
public class listaempleados {
    private String nombres;
    private String apellidos;
    private String DUI;
    private String NIT;
    private String telefono;
    private String correo;

    public listaempleados(String nombres, String apellidos, String DUI, String NIT, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.DUI = DUI;
        this.NIT = NIT;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
