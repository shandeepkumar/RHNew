<%@ page contentType="text/html" import="java.util.*"%>
<html>
    <body>
        <%
                
    ServletContext context = request.getSession().getServletContext();
    RequestDispatcher rd =
    context.getRequestDispatcher("/pageredirectservlet?fldPageType=rhApproval&fldUserType=02&fldUserAction=MGR");
    rd.forward(request, response); 
    %>
    </body>
</html>