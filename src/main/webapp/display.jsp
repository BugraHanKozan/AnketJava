<%@page import="Users.Users_Sql"%>
<%@page import="Users.Users_db"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        try{
        System.out.println("display1");
        Users_db dbUsers = new Users_db();
        Users_Sql sqlUsers = new Users_Sql();
        //dbUsers.merhaba();
        System.out.println("display2");
        sqlUsers.setFirstname(request.getParameter("soru1"));
        sqlUsers.setLastname(request.getParameter("soru2"));
        sqlUsers.setAge(Integer.parseInt(request.getParameter("soru3")));
        sqlUsers.setAnswer1(request.getParameter("soru4"));
        sqlUsers.setAnswer2(request.getParameter("soru5"));
        sqlUsers.setAnswer3(request.getParameter("soru6"));
        sqlUsers.setAnswer4(request.getParameter("soru7"));
        System.out.println("display3");
        //dbUsers.merhaba(request);
        boolean a = dbUsers.users_save(sqlUsers, request );
        System.out.println("display4");}
        catch (Exception e) {
            //sonuc=false;
            e.printStackTrace();
        }
    %>
    <%if(true)
    {
    %>
    <h1>Kayıt Basarılı</h1>
    <%  }else
    {%>
    <h1>Kayıt Başarısız</h1>
    <%}
    %>
</body>
</html>
