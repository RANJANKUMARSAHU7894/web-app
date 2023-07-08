<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:blue;text-align:center">show employe by empno</h1>
<form:form action="edit_employee" method="POST" modelAttribute="employee">

	<table bgcolor="cyan" align="center">

<tr>
			<td>Empno:</td>
			<td><form:input path="empno" readonly="true" /></td>

		</tr>

		<tr>
			<td>Empname:</td>
			<td><form:input path="empname" /></td>

		</tr>

		<tr>
			<td>Job:</td>
			<td><form:input path="job" /></td>

		</tr>

		<tr>
			<td>Sal:</td>
			<td><form:input path="sal" /></td>

		</tr>
		<tr>
			<td>Deptno:</td>
			<td><form:input path="deptno" /></td>

		</tr>
		<tr>
			<td><input type="submit" value="Edit here"></td>
			<td><input type="reset" value="cancel"></td>

		</tr>

	</table>



</form:form>