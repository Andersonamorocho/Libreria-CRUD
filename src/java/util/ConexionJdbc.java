/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJdbc {
    private Connection conn;
    private String user="root";
    private String password="";
    private String url="jdbc:mysql://localhost:3306/libreria";
    private String driverClass="com.mysql.jdbc.Driver";

    public ConexionJdbc(String user,String password,String url,String driverClass) {
        this.user=user;
        this.password=password;
        this.url=url;
        this.driverClass=driverClass;
        conectar();
    }

    public ConexionJdbc() {
        conectar();
    }
    
    private void conectar(){
        try{
            Class.forName(driverClass);
            conn= DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException e){
            System.out.println("ERROR"+e);
        }catch(SQLException e){
            System.out.println("ERROR"+e);}
        
    }
    
    public Connection getConnection(){
           return conn;
    }
}
