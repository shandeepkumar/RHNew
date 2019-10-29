<%@ page contentType="text/html" import="java.util.*"%>
<html>
    <body>
        <%
                
    ServletContext context = request.getSession().getServletContext();
    RequestDispatcher rd =
    context.getRequestDispatcher("/pageredirectservlet?fldPageType=rhAdmin&fldUserType=01&fldUserAction=ADMIN");
    rd.forward(request, response); 
    %>
    </body>
</html>