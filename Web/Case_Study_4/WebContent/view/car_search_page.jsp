<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="images/istyle.css" type="text\css"/>
		<script>
	function getCar()
	{
		
		var budget = document.getElementById("budget");
		var brand = document.getElementById("brand");
		document.getElementById("pricelist").disabled = true;
		document.getElementById("brandlist").disabled = true;
		if(budget.checked == true)
		{
			document.getElementById("pricelist").disabled = false;
		}
		else if(brand.checked == true)
		{
			document.getElementById("brandlist").disabled = false;
		}
	}
	
	</script>
		<title>Car Search</title>
		
		<style>
		
		
			form
			{
				margin:0px auto;
   				padding: 0px;
			}			
			table
			{
				width:500px;
				height:400px;
				margin-left: 160px;
				padding:20px;	
			}		
			select
			{
				width:300px;
				height:30px;
			}
			#logout{
				float: right;
			}
		</style>	
	</head>
	<body>
	<div id="logout">
	<%HttpSession s= request.getSession(false);
    	if(s.getAttribute("userName")!=null) {
    	out.println("<a style='visibility: visible;' href = '/Case_Study_4/LogOutPageController'>Log Out</a> <br/>"); 	
    	}  %>
    	</div>
		<center>
			
			<section>
				<p>Admin Home</p>
				
				<form name="searchform" action="/Case_Study_4/CarSearchController" method="post">
					<table id="table">
						<tr>
							<td><input  id="budget" type="radio" onchange="getCar()" name="filter">By Budget</td>
							<td><input id="brand" type="radio" onchange="getCar()" name="filter">By Brand</td>
						</tr>
						<tr>
							<td colspan="2">
							<select id="pricelist" name="budgetlist1" disabled>
								<option selected disabled>Select(in lacs)</option>
								<option>Below 10 lac</option>
								<option>Above 10 lac</option>
								
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
							<select id="brandlist" name="brandlist1" disabled>
								<option selected disabled>All Vehicle Types</option>		
								<option>Hyundai</option>
								<option>Maruti</option>
								<option>Honda</option>
								
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="5" >
							<input  type="submit" value="Search Car" id="button" style="width: 300px; height: 59px"/>
							</td>
						</tr>
					</table>
				</form>
			</section>
			<footer><label>Copyright &copy 2015.&nbsp All rights reserved.</label></footer>
		</center>
	</body>
	
</html>