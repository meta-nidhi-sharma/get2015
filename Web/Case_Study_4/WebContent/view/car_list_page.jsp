<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.CarDekho.Model.Vehicle , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>

</head>
<body>
<center>
		<%if(request.getAttribute("message")!=null){out.print(request.getAttribute("message"));}%><br>
		Vehicle List : <br><br>
		
		<% List<Vehicle> VehicleList = (List<Vehicle>) request.getAttribute("vehicleList");
        for(Vehicle v : VehicleList)
	    {    	
        	out.println("Model = "+ v.getVehicleId()+"<br/>");
        	out.println("Model = "+ v.getModel()+"<br/>");
        	out.println("Make = "+ v.getMake()+"<br/>");	
        	out.println("<a href = '/Case_Study_4/DetailController?id=" + v.getVehicleId() +"'>Details</a>");
        	HttpSession s= request.getSession(false);
        	if(s.getAttribute("userName")!=null) {
        	out.println("<a style='visibility: visible;' href = '/Case_Study_4/EditPageController?id=" + v.getVehicleId() +"'>Edit</a> <br/><br/><br/>");
        	
        	} 

	    }
	%>
	</center>	
</body>
</html>