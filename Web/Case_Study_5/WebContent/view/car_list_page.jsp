<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.CarDekho.Model.Vehicle , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<script>

</script>
</head>
<body>
<center>
<table>


		<%if(request.getAttribute("message")!=null){out.print(request.getAttribute("message"));}%><br>
		
		<% List<Vehicle> VehicleList = (List<Vehicle>) request.getAttribute("vehicleList");
        for(Vehicle v : VehicleList)
	    {   
        	out.print("<tr><td width='150px'><img src='/Case_Study_5/images/car.jpg' align='left'></td>"
        	+ "<td width='150px'><h3>" + v.getModel() + "</h3></td>" 
        	+ "<td width='150px'>Make = "+ v.getMake()+"<br/>"	
        	+ "Price = "+ v.getPrice()+"<br/>"
        	+ "<td width='150px'><a href = '/Case_Study_5/DetailController?id=" + v.getVehicleId() +"'>Details</a></td>");
        	HttpSession s= request.getSession(false);
        	if(s.getAttribute("userName")!=null) {
        	out.print("<td width='150px'><a style='visibility: visible;' href = '/Case_Study_5/EditPageController?id=" + v.getVehicleId() +"'>Edit</a></td></tr>");	
        	} 
	    }
	%>
	</table>
	</center>	
</body>
</html>