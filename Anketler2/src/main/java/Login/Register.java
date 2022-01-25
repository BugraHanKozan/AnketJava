/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Users.Users_db;
import static dbConnection.Connection.con;
import static dbConnection.Connection.preparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;

/**
 *
 * @author Batuh
 */
public class Register extends dbConnection.Connection
{
    public boolean register_save(String username, String password) throws SQLException
    {
        boolean donus = false;
        System.out.println("Geldim977");
        connection_open();
        System.out.println("actım2");
        
        String sql = "INSERT INTO login (username,password) VALUES (?,?)";
       
        preparedStatement = con.prepareStatement(sql);
             
        System.out.println("Deneme1");
        preparedStatement.setString(1,(username));
        preparedStatement.setString(2,(password));
        System.out.println("Deneme2");

        preparedStatement.execute();
        System.out.println("Geldim988");
//        connection_close();
        donus = true;
        return donus;
    }
}
