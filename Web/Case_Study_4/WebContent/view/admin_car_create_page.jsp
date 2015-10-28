<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Car</title>
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
<form action="/Case_Study_4/CreateCarController" method="post">
<div id="logout">
<%HttpSession s= request.getSession(false);
    	if(s.getAttribute("userName")!=null) {
    	out.println("<a style='visibility: visible;' href = '/Case_Study_4/LogOutPageController'>Log Out</a> <br/>");
    	
    	}  %></div>
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
						<td><input type="text" placeholder="VehicleId" pattern="[a-zA-Z0-9 ]+" name="id" required></td>
					</tr>
					
					<tr>
						<td>Make:</td>
						<td><input type="text" placeholder="Make" pattern="[a-zA-Z ]+" name="make" required></td>
					</tr>
					
					<tr>
						<td>Model:</td>
						<td><input type="text" placeholder="Model" pattern="[a-zA-Z ]+" name="model" required></td>
					</tr>
					<tr>
						<td>EngineInCc:</td>
						<td><input type="text" placeholder="EngineInCc"  name="engineInCc" required></td>
					</tr>
					
					<tr>
						<td>FuelCapacity:</td>
						<td><input type="text" placeholder="FuelCapacity"  name="fuelCapacity" required></td>
					</tr>
					
					<tr>
						<td>Mileage:</td>
						<td><input type="text" placeholder="Mileage"  name="mileage" required></td>
					</tr>
					
					<tr>
						<td>Price:</td>
						<td><input type="text" placeholder="Price"  name="price" required></td>
					</tr>
					
					<tr>
						<td>roadTax:</td>
						<td><input type="text" placeholder="RoadTax"  name="roadTax" required></td>
					</tr>
					
					<tr>
						<td>Created By:</td>
						<td><input type="text" placeholder="Admin" name="created_by" required></td>
					</tr>
					
					<tr>
						<td>Ac:</td>
						<td><input type="text" placeholder="Ac" pattern="[a-zA-Z ]+" name="ac" required></td>
					</tr>
					
					<tr>
						<td>Power Steering:</td>
						<td><input type="text" placeholder="PowerSteering" pattern="[a-zA-Z ]+" name="powerSteering" required></td>
					</tr>
					
					<tr>
						<td>Accessory Kit:</td>
						<td><input type="text" placeholder="AccessoryKit" pattern="[a-zA-Z ]+" name="accessoryKit" required></td>
					</tr>
					
					
					<tr>
						<td colspan="2" id="button"><button>SAVE</button>
						<button onClick="location.href='admin_page.jsp'">BACK</button></td>
					</tr>
				</table>
	</center>
</form>
</body>
</html>