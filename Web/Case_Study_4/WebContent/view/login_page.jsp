<!DOCTYPE html> 
<html> 
<head>
	<title>
		Login Page
	</title>
	<script type="text/javascript" src="JavaScript.js"></script>
</head>
	<body> 
	<center>
		<form action="/Case_Study_4/LoginPageController" method="post" class="sub">
			<fieldset>
				<legend align="center"><h3>LOGIN</h3></legend>
			
				<%if(request.getAttribute("message")!=null){out.print(request.getAttribute("message"));}%><br>
				<p>
				<label>User-Name * </label> <input id="userName" name="userName"
					type="text" placeholder="User Name" /> <span id="uName"></span>
			</p>
			<p>
				<label>Password*  </label> <input id="password" name="password"
					type="password" placeholder="Enter password here" /> <span
					id="passwordValue"></span>
			</p>
		<div>
			<input type="submit" id="button" class="button" value="Submit">
		</div>
			</fieldset>
				
			</form>
</center>
	</body> 
	

</html>
