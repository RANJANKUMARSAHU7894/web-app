<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<c:choose>
<c:when test="${!empty  empList}">
<table border="1" bgcolor="cyan" align="center" >
<tr style="color:blue"><th>empno</th><th>empname</th><th>job</th><th>sal</th><th>deptno</th><th>option</th></tr>

<c:forEach var="emp" items="${empList}" >

<tr >
<td>${emp.empno}</td>
<td>${emp.empname }</td>
<td>${emp.job }</td>
<td>${emp.sal}</td>
<td>${emp.deptno }</td>
<td>
<a href="edit_employee?no=${emp.empno}"><img src="resources/images/edit.jpeg" width="30" height="30"></a>
&nbsp;
<a href="delete_employee?no=${emp.empno}" onclick="return confirm('are you sure for delete')"><img src="resources/images/delete.jpeg" width="30" height="30"></a>


</td>
</tr>  

</c:forEach>
</table>
</c:when>

<c:otherwise>

<h1 style="color:red;text-align:center">record not found</h1>
</c:otherwise>
</c:choose>

<h1 style="color:blue;text-align:center">${msg}</h1>


<center>
<a href="add_employee">
<img src="resources/images/add.jpeg" style="width:60px;height:60px" >
Add Employee
</a>
</centrer>

<br><br>

<center>
<a href="./">
<img src="resources/images/home.jpeg" style="width:60px;height:60px">
home
</a>
</centrer>
