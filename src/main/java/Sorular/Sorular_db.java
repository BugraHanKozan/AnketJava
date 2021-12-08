package Sorular;

import static dbConnection.Connection.con;
import static dbConnection.Connection.preparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Sorular_db extends dbConnection.Connection
{
    public ArrayList<Sorular_Sql> gettum_sorular() throws SQLException{

    connection_open();
        System.out.println("Actim1");
    String sql_query="select * from forms ";
    preparedStatement = con.prepareStatement(sql_query);

    ResultSet rs = preparedStatement.executeQuery();
    
    ArrayList<Sorular_Sql> list = new ArrayList<Sorular_Sql>();
    System.out.println("deneme0");
    Random random = new Random();
    //int[] idizi = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};    
    int iTemelSorular = 3, iDegiskenSorular = 10, iKacSoru = 4, iSayi = 0, iBayrak = 0;
    int[] idizi = new int[(iTemelSorular + iDegiskenSorular + 1)];
    for(int i = 0; i < iKacSoru; i++){
        iSayi = random.nextInt(iDegiskenSorular)+ iTemelSorular + 1;
        iBayrak = 0;
        System.out.println("iSayi ="+ iSayi);
        for(int j = 0; j <= iKacSoru; j++){
            if(iSayi == idizi[j]){
                iBayrak = 0;
                System.out.println("BREAK!");
                break;
            }
            else if (iSayi != idizi[j]){
                iBayrak = 1;
            }
        }
        if(iBayrak == 1){
            idizi[i] = iSayi;
            iBayrak = 0;
        }
        else{
            i--;
        }
        //System.out.println("diziyazilan = " + idizi[i]);
    }
        System.out.println("deneme1");
    while (rs.next()) {
        Sorular_Sql Soru = new Sorular_Sql();
        
        Soru.setId(rs.getInt("ID"));
        Soru.setSorular(rs.getString("Soru"));
        if(Soru.getId() <= iTemelSorular){
            list.add(Soru);
        }
        for(int i = 0; i <= (iTemelSorular + iDegiskenSorular); i++){
           if(Soru.getId() == idizi[i]){
                System.out.println(idizi[i]);
                list.add(Soru);
           }
        }
       
       
    }
    //connection_close();
    //System.out.println("Kapadim1");
    return list;
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
    }
}
