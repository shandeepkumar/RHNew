<%@ page contentType="text/html" import="java.util.*"%>
<div id="test">Send me a message!</div>
<script>
  function listener(event) {
      //alert('ada');
      if (event.origin !== "http://localhost:7101")
        //  alert('ddd');
      return parent.window.close();
      //document.getElementById("test").innerHTML = "received: " + event.data
  }

  if (window.addEventListener) {
      addEventListener("message", listener, false)
  }
  else {
      attachEvent("onmessage", listener)
  }
</script>
<html>
    <body>
        <%
        
        String fldUserAction = request.getParameter("fldUserAction");
        String fldPolicyId  = request.getParameter("fldPolicyId");
        String enquiryFAQId  = request.getParameter("enquiryFAQId");
        String requestId  = request.getParameter("requestId");
                
    ServletContext context = request.getSession().getServletContext();
    RequestDispatcher rd =
    context.getRequestDispatcher("/pageredirectservlet?fldPageType=email&fldUserAction="+fldUserAction+"&fldPolicyId="+fldPolicyId+"&enquiryFAQId="+enquiryFAQId+"&requestId="+requestId);
    rd.forward(request, response); 
    %>
    </body>
</html>