<div id="login_window">
<%
HttpSession objSession = request.getSession(true); 
if (objSession.getAttribute("rights") != null && objSession.getAttribute("rights") != "")
{
	  //si estas conectat mostra un link
	 %>
	 	<span>Connectat com: ${userName} (${rights})</span><br>
	    <a href="<c:url value='/logout' />" >Desconecta</a>
	 <%
	 // si es admin mostra link al panell d'administració
	 if (((String)(objSession.getAttribute("rights"))).contains("Admin"))
	 {
		 %>
		 <br><a href="<c:url value='/inmobles'/>">Panell d'administració</a>
		 <%
	 }
	 else
	 {
		 %>
		 <br><a href="<c:url value='/findIncidenceByUsername/'/>${userName}">Panell de control</a>
		 <%
		 
	 }
	  
}
else
{
	%><span>No estàs connectat</span><br>
	<a href="<c:url value='/login' />" >Login</a> | <a href="<c:url value='/registration' />" >Registra't</a>
	<%
}
%>
</div>

