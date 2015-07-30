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
public class cargos {
  private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    int id;
    String nombre_cargo;
    String descripcion_cargo;
    Double salario;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }
    
    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
        public cargos()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
        public boolean guardarCargo()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO cargos(nombre_cargo,descripcion_cargo, salario) "
        + "VALUES(?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, nombre_cargo);
        cmd.setString(2, descripcion_cargo);
        cmd.setDouble(3, salario);
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
        public boolean modificarCargo()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta UPDATE
        String sql = "UPDATE cargos SET nombre_cargo=?, descripcion_cargo=?, salario=? WHERE id_cargo  = ?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setString(1, nombre_cargo);
        cmd.setString(2, descripcion_cargo);
        cmd.setDouble(3, salario);
        cmd.setInt(4, id);
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
        
            public boolean eliminarContacto()
            {
            boolean resp = false;
            try
            {
            //Realizar consulta DELETE
            String sql = "DELETE FROM cargos WHERE id_cargo = ?";
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
        ps=cn.prepareStatement("select * from cargos");
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
