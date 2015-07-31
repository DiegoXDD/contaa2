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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isaac
 */
public class descuentos {
     private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    Connection cn;
    int id;
    double afp;
    double isr;
    double total;
    double salario_final;
    int cargo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getIsr() {
        return isr;
    }

    public void setIsr(double isr) {
        this.isr = isr;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSalario_final() {
        return salario_final;
    }

    public void setSalario_final(double salario_final) {
        this.salario_final = salario_final;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    public descuentos()
    {
    //Establecemos la conexión
    Conexion con = new Conexion();
    cn = con.conect();
    }
    public boolean guardarDescuentos()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta INSERT
        String sql = "INSERT INTO descuentos(afp, isr, total, salario_final, id_cargo) "
        + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setDouble(1, afp);
        cmd.setDouble(2, isr);
        cmd.setDouble(3, total);
        cmd.setDouble(4, salario_final);
        cmd.setInt(5, cargo);
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
        public boolean modificarDescuento()
        {
        boolean resp = false;
        try
        {
        //Realizar consulta UPDATE
        String sql = "UPDATE descuentos SET  afp=?, isr=?, total=?, salario_final=?, id_cargo=? WHERE id_cargo= ?";
        PreparedStatement cmd = cn.prepareStatement(sql);
        //Llenar los parámetros
        cmd.setDouble(1, afp);
        cmd.setDouble(2, isr);
        cmd.setDouble(3, total);
        cmd.setDouble(4, salario_final);
        cmd.setInt(5, cargo);
        cmd.setInt(6, cargo);
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
        
         public boolean eliminarDescuento()
            {
            boolean resp = false;
            try
            {
            //Realizar consulta DELETE
            String sql = "DELETE FROM descuentos WHERE id_cargo = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //Llenar los parámetros
            cmd.setInt(1, cargo); 
            
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
}
