package Admin;

import Sorular.Sorular_Sql;
import Sorular.Sorular_db;
import Users.Users_Sql;
import dbConnection.Connection;
import static dbConnection.Connection.con;
import static dbConnection.Connection.preparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.CDL;
import org.json.JSONArray;

public class Admin  extends dbConnection.Connection{
    
    public void Admin_Sil(int id) throws SQLException{
        st.executeUpdate("DELETE FROM users WHERE id=" + id);
        System.out.println(id + " numarali ID silinmistir!");
    }
    
    public void Sorular_Sil(int id) throws SQLException{
        st.executeUpdate("DELETE FROM forms WHERE id=" + id);
        System.out.println(id + " numarali ID silinmistir!");
    }
    
    public void Admin_Edit(int id, String firstname, String lastname, int age, String answers)throws SQLException{
        String sql_query="Update users set ID=?,firstname=?,lastname=?,age=?,answers=? where id="+id;
        preparedStatement = con.prepareStatement(sql_query);
        st = con.prepareStatement(sql_query);
        //st.executeUpdate("update users set firstname='"+firstname+"',lastname='"+lastname+"',age='"+age+"',answers='"+answers+"' where id='"+id+"' ");
        /*st.setInt(1,id);
        st.setString(2, firstname);
        st.setString(3, lastname);
        st.setString(4, age);
        st.setString(5, answers);*/
        System.out.println("----------------------------------------------");
        preparedStatement.setInt(1, id);
        System.out.println(id);
        preparedStatement.setString(2, firstname);
        System.out.println(firstname);
        preparedStatement.setString(3, lastname);
        preparedStatement.setInt(4, age);
        System.out.println(age);
        preparedStatement.setString(5, answers);
        System.out.println(answers);
        System.out.println("----------------------------------------------");
        preparedStatement.execute();
        
        //st.executeUpdate();
    }
    
    public void Sorular_Edit(int id, String Soru)throws SQLException{
        String sql_query="Update forms set ID=?,Soru=? where id="+id;
        preparedStatement = con.prepareStatement(sql_query);
        st = con.prepareStatement(sql_query);
        //st.executeUpdate("update users set firstname='"+firstname+"',lastname='"+lastname+"',age='"+age+"',answers='"+answers+"' where id='"+id+"' ");
        /*st.setInt(1,id);
        st.setString(2, firstname);
        st.setString(3, lastname);
        st.setString(4, age);
        st.setString(5, answers);*/
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, Soru);
        preparedStatement.execute();
        
        //st.executeUpdate();
    }
    
    public ResultSet Admin_Bagla() throws SQLException{
        String sql_query="select * from users ";
        preparedStatement = con.prepareStatement(sql_query);
        ResultSet rs = preparedStatement.executeQuery();
        Statement st = con.createStatement();
        return rs;
    }
    
    public ResultSet Sorular_Bagla() throws SQLException{
        String sql_query="select * from forms ";
        preparedStatement = con.prepareStatement(sql_query);
        ResultSet rs = preparedStatement.executeQuery();
        Statement st = con.createStatement();
        return rs;
    }
    public void Admin_Deneme() throws SQLException{
        System.out.println("---------DENEME----------");
    }
    public static void main(String[] args) throws SQLException {
        Connection v = new Connection();
        v.connection_open();
        
        ResultSet rss;
            Admin admin = new Admin();
            rss = admin.Sorular_Bagla();
            admin.Sorular_Edit(11, "Cevap8:");
        
        v.connection_close();
    }
}
