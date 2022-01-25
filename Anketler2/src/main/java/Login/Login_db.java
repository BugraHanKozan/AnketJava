/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Sorular.Sorular_Sql;
import static dbConnection.Connection.con;
import static dbConnection.Connection.preparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Batuh
 */
public class Login_db extends dbConnection.Connection
{
    public ArrayList<Login_Sql> gettum_login() throws SQLException
    {
        connection_open();
        
        System.out.println("Actım1");
        String sql_query="select * from login ";
        preparedStatement = con.prepareStatement(sql_query);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Login_Sql> list = new ArrayList<Login_Sql>();
        
        while (rs.next()) 
        {
            Login_Sql login = new Login_Sql();
            if(rs.getInt("ID") == 3){
                System.out.println("geldim ki");
                System.out.println(rs.getString("Username").toString());
            }
            if(rs.getString("Username").toString() == "batuhan"){
                System.out.println("geldim ki2");
                System.out.println("Batuhan'ı yazdırdım");
            }
            else
            {
                System.out.println("Gelemedim ki");
            }
            
            login.setId(rs.getInt("ID"));
            login.setUsername(rs.getString("Username"));
            login.setPassword(rs.getString("Password"));
            list.add(login);
        }
       return list;
    }
}
