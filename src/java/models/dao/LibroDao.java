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
import models.entity.Libro;
import util.ConexionJdbc;

/**
 *
 * @author bryan
 */
public class LibroDao implements ILibroDao {

    private Connection conn;

    public Connection getConnection() {
        if (conn == null) {
            conn = new ConexionJdbc().getConnection();
        }
        return conn;
    }

    public void setConnetion(Connection conn) {
        this.conn = conn;
    }

    public void CloseConnection() {
        try {
            getConnection().close();
            conn = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Libro> Listar() {
        List<Libro> lista = new ArrayList<Libro>();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM libro");
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                lista.add(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Libro getLibro(int id) {
        Libro libro = null;
        try {
            PreparedStatement stm = getConnection().prepareStatement(
                    "SELECT * FROM libro where id = ? ");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
            }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libro;
    }

        @Override
    public void Guardar(Libro libro) {
        try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("UPDATE libro set nombre='"+libro.getNombre()+"',autor='"+libro.getAutor()+
                        "',genero='"+libro.getGenero()+"' Where id="+libro.getId());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void Insertar(Libro libro) {
        
        try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("INSERT INTO libro (nombre, autor, genero) VALUES ('"+libro.getNombre()+"','"+libro.getAutor()+
                        "','"+libro.getGenero()+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
            @Override
    public void Eliminar(int id) {   
        try {
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("DELETE FROM libro WHERE id="+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

