package dbConnection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection 
{
    public static java.sql.Connection con;
    public static Statement st;
    public static PreparedStatement preparedStatement;
    public static ResultSet rs;
    
    public void connection_open() {
//conneciton_close();
        //Data getirmek için
        try {
            if (con == null) {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veritabaniform?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "");
                
                st = con.createStatement();
                
                System.out.println("Baglanti Saglandi");
            } else {
                   System.out.println("Baglanti Zaten Acik");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Open Connection Error" + e.toString());
        }      
    }
     
     public void connection_close() throws SQLException 
        {
        try {
            if (con != null) {
                con.close();
//                st.close();
//                rs.close();
//            preparedStatement.close();
                System.out.println("Baglanti Kapandi");
            }
        } catch (Exception e2) {
            System.out.println("Baglanti Zaten Kapali");
            }
        }
    public static void main(String[] args) throws SQLException {
        Connection v = new Connection();
        v.connection_open();
        v.connection_close();
    }
}
