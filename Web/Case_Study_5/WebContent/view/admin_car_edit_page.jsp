<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.CarDekho.Model.Vehicle , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Car</title>
<style>
		
			body {
				background-color: LightGray;
			}
			
			section {
				margin: auto;
				width: 500px;
				background-color:white;
			}
			
			header {
				background-color: gray;
				height: 50px;
				width: 500px;
				margin: auto;
				margin-top: 100px;
				border-top-left-radius: 10px;
				border-top-right-radius: 10px;
				border-bottom: maroon 3px solid;
				text-align: center;
			}
		
			p {
				padding-top: 10px;
				color: white;
				font-family: lucida handwritting;
				font-weight: bold;
				font-size: 30px;
			}
			table {
				border-collapse: separate;
				margin: auto;
				padding-top: 20px;
				padding-bottom: 20px;
			}
			
			#button {
				text-align: center;
			}
			
			td {
				padding-top: 10px;
				padding-bottom: 10px;
			}
			button {
			color: white;
			background-color: maroon;
			font-weight: bold;
			width:80px;
			height:40px;
		}
		#logout{
				float: right;
			}
		</style>
</head>
<body>
<p>Edit Page</p>
<div id="logout">
		<%if(request.getAttribute("message")!=null){out.print(request.getAttribute("message"));}%><br>
		Vehicle List : <br><br>		
		<% Vehicle v = (Vehicle) request.getAttribute("carById");	
	%></div>
	
<form action="/Case_Study_5/UpdateCarController" method="post">
<%HttpSession s= request.getSession(false);
    	if(s.getAttribute("userName")!=null) {
    	out.println("<a style='visibility: visible;' href = '/Case_Study_5/LogOutPageController'>Log Out</a> <br/>"); 	
    	}  %>
	<center>
		<div id="message">
			<% 
				String message = (String)request.getAttribute("message"); 
				if(message != null) {
					out.println(message);
				}
			%>
		</div>
		<table>
							<tr>
						<td>Vehicle Id:</td>
						<td><input type="text" name="id" value=<%=v.getVehicleId()%> readonly></td>
					</tr>
					
					<tr>
						<td>Make:</td>
						<td><input type="text" name="make" value=<%=v.getMake()%>></td>
					</tr>
					
					<tr>
						<td>Model:</td>
						<td><input type="text" name="model" value=<%=v.getModel()%>></td>
					</tr>
					<tr>
						<td>EngineInCc:</td>
						<td><input type="text" name="engineInCc" value=<%=v.getEngineInCC()%>></td>
					</tr>
					
					<tr>
						<td>FuelCapacity:</td>
						<td><input type="text" name="fuelCapacity" value=<%=v.getFuelCapacity()%>></td>
					</tr>
					
					<tr>
						<td>Mileage:</td>
						<td><input type="text" name="mileage" value=<%=v.getMilage()%>></td>
					</tr>
					
					<tr>
						<td>Ex-Showroom Price:</td>
						<td><input type="text" name="price" value=<%=v.getPrice()%>></td>
					</tr>
					
					<tr>
						<td>roadTax:</td>
						<td><input type="text" name="roadTax" value=<%=v.getRoadTax()%>></td>
					</tr>
					
					
					<tr>
						<td>Created By:</td>
						<td>
						<input type="text" name="created_by" value=<%=v.getCreatedBy()%>>
						</td>
					</tr>
					
					<tr>
						<td>Created Time:</td>
						<td><input type="text" name="created_time" value=<%=v.getCreatedTime()%>></td>
					</tr>
					
					
					<tr>
						<td colspan="2"><input type="submit" name="submit" />
						<button onClick="location.href='AdminHome.jsp'">BACK</button></td>
					</tr>
				</table>
	</center>
</form>
</body>
</html>