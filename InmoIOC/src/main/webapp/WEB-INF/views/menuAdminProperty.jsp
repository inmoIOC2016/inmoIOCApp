<div>
	<img src="<c:url value="/resources/img/logoalternativo.png" />">	
	<span class="spanTitle"></span>
</div>
<ul>  
  <li><a class="liSelected" href="#">Alta d'Immobles</a></li>
  <li><a href="<c:url value='/vendes' />">Vendes/Compres/Lloguers/Traspassos</a></li>
  <li><a href="<c:url value='/pagaments' />">Pagaments</a></li>
  <li><a href="<c:url value='/incidencies' />">Incidències</a></li>
  <li><a href="<c:url value='/estadistica' />">Estadístiques</a></li>
  <li><a href="<c:url value='/categories' />">Categories</a></li>
  <li><a href="<c:url value='/usuaris' />">Usuaris</a></li>
  <li>
  	<a onclick="return disconnect();" href="<c:url value='/logout' />">Desconectar usuari: <span id="userNameItem"></span></a>
  </li> 
</ul>