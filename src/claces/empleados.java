/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moises
 */
public class empleados {
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    int id;
    String nombre_trabajador;
    String apellido_trabajador;
    String dui_trabajador;
    String cargo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }
    
    public String getApellido_trabajador() {
        return apellido_trabajador;
    }

    public void setApellido_trabajador(String apellido_trabajador) {
        this.apellido_trabajador = apellido_trabajador;
    }

    public String getDui_trabajador() {
        return dui_trabajador;
    }

    public void setDui_trabajador(String dui_trabajador) {
        this.dui_trabajador = dui_trabajador;
    }
    
     public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
        public empleados()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
        public boolean guardarEmpleado()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO trabajador(nombre_trabajador,apellido_trabajador, dui_trabajador, cargo) "
        + "VALUES(?, ?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, nombre_trabajador);
        cmd.setString(2, apellido_trabajador);
        cmd.setString(3, dui_trabajador);
        cmd.setString(4, cargo);
        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
//        cmd.close();
//        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }
        public boolean modificarEmpleado()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta UPDATE
        String sql = "UPDATE trabajador SET id_empresa= ?, nombre_trabajador=?, apellido_trabajador=?, dui_trabajador=? , cargo=? WHERE id_trabajador  = ?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setInt(1, id);
        cmd.setString(1, nombre_trabajador);
        cmd.setString(2, apellido_trabajador);
        cmd.setString(3, dui_trabajador);
        cmd.setString(4, cargo);
        //Si da error devuelve 1, caso contrario 0
        //Tomar en cuenta el "!" de negación
        if(!cmd.execute())
        {
        resp = true;
        }
        cmd.close();
        cn.close();
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
        return resp;
        }
        
            public boolean eliminarEmpleado()
            {
            boolean resp = false;
            try
            {
            //Realizar consulta DELETE
            String sql = "DELETE FROM trabajador WHERE id_trabajador = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //Llenar los parámetros
            cmd.setInt(1, id); 
            
            //Si da error devuelve 1, caso contrario 0
            //Tomar en cuenta el "!" de negación
            if(!cmd.execute())
            {
            resp = true;
            }
            cmd.close();
            cn.close();
            }
            catch (Exception e) {
            System.out.println(e.toString());
            }
            return resp;
            }
        public void llenarTabla(JTable tabla)throws Exception{
        ps=cn.prepareStatement("select * from trabajador");
               // ps.setInt(1, id_sucursal);
        rs=ps.executeQuery();
        rsm=rs.getMetaData();
        ArrayList<Object[]> datos=new ArrayList<>();
        while (rs.next()) {            
            Object[] filas=new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=rs.getObject(i+1);
                
            }
            datos.add(filas);
        }
        dtm=(DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
        }
}
