<!DOCTYPE html> 
<html> 
<style>
body{
background-image:url('images/maruti.jpg');	  
}
footer{
margin-top: 20%;
color : pink;
}
nav{
	color : black;
	height : 10px;
	float : right;
}
section{
margin-top : 50px;
}
#btn{
margin-left : 45%;
}
#content {
 color : pink;
}
#buttonSearch{
width : 100px;
height : 50px;
}
#buttonSave{
width : 100px;
height : 50px;
}
</style>

<title>
CarDekho
</title>
<body> 
	
	<header>

		<img src="images/carLogo.png" height="80px" width="200px">
	
	<div id="logout" float="right"><%HttpSession s= request.getSession(false);
    	if(s.getAttribute("userName")!=null) {
    	out.println("<a style='visibility: visible;' href = '/Case_Study_5/LogOutPageController'>Log Out</a> <br/>");
    	}  %></div>
	</header>
		
	<nav>
		<button type = "button" name="bt1" value="Home">
            Home
          </button>
		  <button type = "button" name="bt1" value="About Us">
            About Us
          </button>
		  <button type = "button" name="bt1" value="References">
            References
          </button>
		  <button type = "button" name="bt1" value="Contact Info">
            Contact Info
          </button>
	</nav>
	<section>
	<p id="content">Truth be told, FlexDealer does not build Car Dealer Websites.
		We build Consumer Websites on behalf of Car Dealers around the world. 
		Our aim is to help your customers have an enjoyable online experience.
		Doing so translates into higher quality leads for you and overly satisfied
		customers.And who does not want satisfied, happy automotive shoppers?
		The best part? We often get way better results while decreasing your 
		monthly spend!
		But listen, there is more here than meets the eye! We are excited to walk
		you through just how different working with FlexDealer will be then your
		existing car dealer website provider.
		That is why we would love to invite you to reserve a phone call with one of
		our certified digital advisors.</p>	
		</section>
			<div id="btn">
	<%if(s.getAttribute("userName")!=null) {%>
	<button id="buttonSave" onclick="location.href='/Case_Study_5/view/admin_car_create_page.jsp'" name="saveButton" style="visibility: visible;">Create</button>
	<%} %>
	<button id="buttonSearch" onclick="location.href='/Case_Study_5/view/car_search_page.jsp'" name="searchButton">Search</button>	
	</div>
	<footer>
	<center>
		<hr></hr>
		contact us at <a href="tel: +131765432672">131765432672</a>
		<br><br>
		Posted by: Hege Refsnes
		<br><br>
		Mail us at: <a href="mailto:someone@example.com">
		someone@example.com</a>
		</center>
	</footer>

</body> 
</html>
