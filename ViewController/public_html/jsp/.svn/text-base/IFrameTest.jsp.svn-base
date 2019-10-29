<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<iframe src="../jsp/RhEmailRedirect.jsp?fldUserId=mkr1&requestId=EA7GC17046&fldUserAction=SDRD" id="iframe" style="height:600px"></iframe>

<form name="form">
  <input type="text" name="msg" value="Your message"/>
  <input type="submit"/>
</form>

<script>

  var win = document.getElementById("iframe").contentWindow;

  document.forms.form.onsubmit = function() {
  alert('dfdf');
    win.postMessage(
      this.elements.msg.value,
      "http://localhost:7101" 
    )
    return false
  }
  
// Popup window code
function newWindow(url) {

	popupWindow = window.open(
		url,
		'popUpWindow','height=300,width=450,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
}

function closeWindow()
{
   if(false == popupWindow.closed)
   {
      popupWindow.close ();
   }
   else
   {
      alert('That window is already closed. Open the window first and try again!');
   }
}
</script>
<button onClick="JavaScript:newWindow('RhEmailRedirect.jsp?fldUserId=mkr1&requestId=EA7GC17046&fldUserAction=SDRD')">Open Popup Window</button>
<button onClick="JavaScript:closeWindow();">Close Popup Window</button>

</script>