package Users;

import Sorular.Sorular_Sql;
import Sorular.Sorular_db;
import static dbConnection.Connection.con;
import static dbConnection.Connection.preparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.CDL;
import org.json.JSONArray;

public class Users_db extends dbConnection.Connection
{
    public void merhaba(HttpServletRequest request){
        System.out.println("Deneme00");
        
    }
    public boolean users_save(Users_Sql users, HttpServletRequest request) throws SQLException{
    boolean donus=false;
        System.out.println("Deneme0");
        /*for(int a = 1; a < 8; a++){
            System.out.println(request.getParameter("soru" + a));
        }*/
        //connection_open();
        //System.out.println("actım2");
      String sql = "INSERT INTO users (firstname, lastname, age, answers) VALUES (?,?,?,?)";
        
        try {
            String sql_query="select * from forms ";
            preparedStatement = con.prepareStatement(sql_query);
            ResultSet rs = preparedStatement.executeQuery();
    
            JSONArray ja = new JSONArray();
            ArrayList<Sorular_Sql> liste = new ArrayList<>();
            int i = 1, j = 0;
            while (rs.next()) {
        
               Sorular_Sql Soru = new Sorular_Sql();

               Soru.setId(rs.getInt("ID"));
               Soru.setSorular(rs.getString("Soru"));
               
               liste.add(Soru);
            }
            for (Sorular_Sql Soru : liste)
            {
                j++;
                if(j > 3){
                    ja.put(Soru.getSorular());
                }
                i++;
            }
            
            String string = users.getAnswer1() + "," + users.getAnswer2() + "," + users.getAnswer3() + "," + users.getAnswer4();

            JSONArray result = CDL.toJSONArray(ja, string);
            System.out.println(result);
            preparedStatement = con.prepareStatement(sql);
            System.out.println(ja.toString());
            preparedStatement.setString(1, users.getFirstname());
            preparedStatement.setString(2, users.getLastname());
            preparedStatement.setInt(3, users.getAge());
            preparedStatement.setString(4, result.toString());
            preparedStatement.execute();
            System.out.println("Deneme6");
            donus = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Hata1");
            Logger.getLogger(Users_db.class.getName()).log(Level.SEVERE, null, ex);
            donus = false;
        }
    connection_close();
    System.out.println("Kapadim2");
    return donus;
    }
    
    public static void main(String[] args) throws SQLException 
    {
        Sorular_db Sorudb = new Sorular_db();
       ArrayList<Sorular_Sql> list = Sorudb.gettum_sorular();
        for (Sorular_Sql Soru : list) 
        {
            System.out.println(Soru.getId());
            System.out.println(Soru.getSorular());
        }
        
        Users_db dbUsers = new Users_db();
        Users_Sql sqlUsers = new Users_Sql();
        
        //boolean a = dbUsers.users_save(sqlUsers);
        
        //System.out.println(a);
    }
}
