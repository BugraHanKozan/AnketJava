<%@page import="java.util.ArrayList"%>
<%@page import="Sorular.Sorular_Sql"%>
<%@page import="Sorular.Sorular_db"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorular</title>
    </head>
    <body>
        <center>
            <h1>Sorular</h1>
        
    <%
        Sorular_db Sorudb = new Sorular_db();
        ArrayList<Sorular_Sql> list = Sorudb.gettum_sorular();
        
        int soruno = 0;
        for (Sorular_Sql Soru : list)
        {
            System.out.println("index1");
            System.out.println(Soru.getId());
            System.out.println(Soru.getSorular());
            soruno++;
            
    %>
        <form action="display.jsp" method="POST">
            <table border="1">
                <tr>
                <td><%= soruno %>.Soru</td>
                <td><%= Soru.getSorular() %></td>
                <td><input type="text" name="soru<%= soruno %>" value="" size="30" /></td>
                </tr>
            <%
                System.out.println("index2");
            }
                System.out.println("index3");
            %>
            
            </table>
            <input type="reset" value="Temizle" name="clear" />
            <input type="submit" value="Gönder" name="submit" />
            <%
                System.out.println("index4");
           
            %>
        </form>
        </center>
    </body>
</html>
