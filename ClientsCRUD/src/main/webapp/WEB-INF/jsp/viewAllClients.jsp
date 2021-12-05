    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	

<h1>Clients' list</h1>
<br/>
<table border="2" width="70%" cellpadding="2">
   <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Surname</th>
      <th colspan="2">Options</th>
   </tr>
   <c:forEach var="cli" items="${list}">
      <tr>
         <td>${cli.id}</td>
         <td>${cli.name}</td>
         <td>${cli.surname}</td>
         <td><a href="viewclient/${cli.id}">View or edit data</a></td>
         <td><a href="deletecli/${cli.id}">Delete client</a></td>
      </tr>
   </c:forEach>
</table>
<br/>
<br/>
<a href="addClient">Add New Client</a>