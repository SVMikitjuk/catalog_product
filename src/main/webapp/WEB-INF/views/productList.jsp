<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
	        <h1>Group List</h1>
	        <h2><a href="new">New Group</a></h2>
	        
        	<table border="1">
	        	<th>Id</th>
	        	<th>Name</th>

				<c:forEach var="group" items="${groupList}" varStatus="status">
	        	<tr>
					<td>${group.id}</td>
					<td>${group.name}</td>
					<td>
						<a href="edit?id=${group.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${group.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
