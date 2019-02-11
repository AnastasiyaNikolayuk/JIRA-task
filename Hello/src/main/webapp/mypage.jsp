<%@ page import="veeeeryTry.Phonebook" %>
<%@ page import="veeeeryTry.Phone" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.02.2019
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VeeeeryTry</title>
</head>
<body>
<%
    Phonebook phonebook = Phonebook.getInstance();
%>
<table align="center" border="3" cols="2">
    <%
        for (int i = 0; i < phonebook.Phones.size(); i ++) {
    %><tr><td><%=phonebook.getName(i)%></td><td><%=phonebook.getPhone(i)%></td></tr>
    <%
        }
    %>
</table>
<div>
    <form method="post">
        <p><input name="parameter">
        <input type="submit" value="Найти"></p>
    </form>
    Results: <%=request.getAttribute("findingElementName")%>  <%=request.getAttribute("findingElementPhone")%>
</div>
</body>
</html>
