package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.entity.Cliente;
import util.ConexionJdbc;

public class ClienteDao implements IClienteDao{
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
    public List<Cliente> Listar(){
        List<Cliente> lista= new ArrayList<Cliente>();
        try{
        Statement st = getConnection().createStatement();
        ResultSet rs= st.executeQuery("SELECT * FROM clientes");
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setEmail(rs.getString("email"));
            cliente.setPassword(rs.getString("password"));
        lista.add(cliente);}
        } catch(Exception e){
                e.printStackTrace();
                }
        return lista; 
}
        public Cliente getCliente(int id) {
        Cliente cliente = null;
        try {
            PreparedStatement stm = getConnection().prepareStatement(
                    "SELECT * FROM CLIENTES where id = ? ");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setPassword(rs.getString("password"));
            }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void Guardar(Cliente cliente) {
        try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("UPDATE clientes set nombre='"+cliente.getNombre()+"',email='"+cliente.getEmail()+
                        "',password='"+cliente.getPassword()+"'Where id="+cliente.getId());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void Insertar(Cliente cliente) {
        
        try{
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("INSERT INTO clientes (nombre, email, password) VALUES ('"+cliente.getNombre()+"','"+cliente.getEmail()+
                        "','"+cliente.getPassword()+"')");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
        @Override
    public void Eliminar(int id) {
        
        try {
            Statement stm = getConnection().createStatement();
                stm.executeUpdate("DELETE FROM clientes WHERE id="+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
