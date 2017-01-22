<div id="login_window">
<%
HttpSession objSession = request.getSession(true); 
if (objSession.getAttribute("rights") != null)
{
	  //si estas conectat mostra un link
	 %>
	 	<span>Connectat com: <%= objSession.getAttribute( "userName" ) %> </span><br>
	    <a href="<c:url value='/logout' />" >Desconecta</a>
	 <%
	 // si es admin mostra link al panell d'administraciķ
	 if (((String)(objSession.getAttribute("rights"))).contains("admin"))
	 {
		 %>
		 <p><a href="<c:url value='/adminprincipal'/>">Panell d'administraciķ</a></p>
		 <%
	 }
	  
}
else
{
	%><span>No estās connectat</span><br>
	<a href="<c:url value='/login' />" >Login</a> | <a href="<c:url value='/registration' />" >Registra't</a>
	<%
}
%>
</div>

