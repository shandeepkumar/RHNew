<%@ page contentType="text/html" import="java.util.*"%>
<html>
    <body>
        <%
                
    ServletContext context = request.getSession().getServletContext();
    RequestDispatcher rd =
    context.getRequestDispatcher("/pageredirectservlet?fldPageType=rhCategoryBrowser&fldUserAction=PCB");
    rd.forward(request, response); 
    %>
    </body>
</html>