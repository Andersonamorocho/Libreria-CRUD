package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import models.entity.Cliente;

public class Pruea {
    public static void main(String[] args) throws Exception{
        
        try{
            ConexionJdbc conn = new ConexionJdbc("root","","jdbc:mysql://localhost:3306/electrodomesticos","com.mysql.jdbc.Driver");
            Statement st = conn.getConnection().createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM electrodomestico");
            while(rs.next()){
                 System.out.println(rs.getInt("id")+" - "+
                                    rs.getString("nombre")+" - "+
                                    rs.getInt("cant")+" - "+
                                    rs.getDouble("precio"));
            }
        }catch(Exception e){
            System.out.println("ERROR"+e);
        }
    }
}
