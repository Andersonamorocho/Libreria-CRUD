/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.entity.Prestamo;
import util.ConexionJdbc;

/**
 *
 * @author bryan
 */
public class PrestamoDao implements IPrestamoDao{
    private Connection conn;

    public Connection getConnection() {
        if(conn==null){
            conn = new ConexionJdbc().getConnection();
        }
        return conn;
    }

    public void setConnetion(Connection conn) {
        this.conn = conn;
    }
    
    public void CloseConnection(){
        try{
            getConnection().close();
            conn=null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Prestamo> Listar(){
        List<Prestamo> lista= new ArrayList<Prestamo>();
        try{
        Statement st = getConnection().createStatement();
        ResultSet rs= st.executeQuery("SELECT * FROM prestamo");
        while(rs.next()){
            Prestamo prestamo = new Prestamo();
            prestamo.setId(rs.getInt("id"));
            prestamo.setIdcliente(rs.getInt("idcliente"));
            prestamo.setNombrecliente(rs.getString("nombrecliente"));
            prestamo.setIdlibro(rs.getInt("idlibro"));
            prestamo.setNombrelibro(rs.getString("nombrelibro"));
        lista.add(prestamo);}
        } catch(Exception e){
                e.printStackTrace();
                }
        return lista; 
}
        public Prestamo getPrestamo(int id) {
        Prestamo prestamo = null;
        try {
            PreparedStatement stm = getConnection().prepareStatement(
                    "SELECT * FROM prestamo where id = ? ");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                prestamo = new Prestamo();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdcliente(rs.getInt("idcliente"));
                prestamo.setNombrecliente(rs.getString("nombrecliente"));
                prestamo.setIdlibro(rs.getInt("idlibro"));
                prestamo.setNombrelibro(rs.getString("nombrelibro"));
            }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prestamo;
    }

    @Override
    public void Guardar(Prestamo prestamo) {
                try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("UPDATE prestamo set idcliente="+prestamo.getIdcliente()+",nombrecliente='"+prestamo.getNombrecliente()+"',idlibro="+prestamo.getIdlibro()+
                        ",nombrelibro='"+prestamo.getNombrelibro()+"' Where id="+prestamo.getId());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void Insertar(Prestamo prestamo) {
        try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("INSERT INTO prestamo (idcliente, nombrecliente, idlibro, nombrelibro) VALUES"
                        + " ("+prestamo.getIdcliente()+",'"+prestamo.getNombrecliente()+"',"+prestamo.getIdlibro()+",'"+
                        prestamo.getNombrelibro()+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
            @Override
    public void Eliminar(int id) {
        
        try {
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("DELETE FROM prestamo WHERE id="+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}