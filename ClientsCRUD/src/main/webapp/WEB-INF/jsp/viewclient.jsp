<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>View or edit client data</h1>
<br/>

<form:form method="POST" action="/SpringMVC/editsave">
   <table >
      <tr>
         <td></td>
         <td>
            <form:hidden path="id" />
         </td>
      </tr>
      <tr>
         <td>Name: </td>
         <td>
            <form:input path="name"  />
         </td>
      </tr>
      <tr>
         <td>Surname: </td>
         <td>
            <form:input path="surname" />
         </td>
      </tr>
      <tr>
         <td>Email: </td>
         <td>
            <form:input path="email" />
         </td>
      </tr>
      <tr>
         <td>Address: </td>
         <td>
            <form:input path="address" />
         </td>
      </tr>
      <tr>
         <td>Telephone </td>
         <td>
            <form:input path="telephone" />
         </td>
      </tr>
      <tr>
         <td>More information: </td>
         <td>
            <form:input path="information" />
         </td>
      </tr>
      <tr>
         <td> </td>
         <td><input type="submit" value="Save data" /></td>
      </tr>
   </table>
</form:form>