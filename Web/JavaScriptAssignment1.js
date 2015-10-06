function activateSubmit() 
{
	if(document.getElementById("condition1").checked == true)
	{	
		document.getElementById("button").disabled = false;	
	}
	else{
		document.getElementById("button").disabled = true;
	}
}
function validate()
 {
	if(document.getElementById("pw").value.length < 8 )
	{
		alert("Password Length should be greater than 8");
	}
	else if(document.getElementById("pw").value != document.getElementById("rpw").value) 
	{
		alert("Password & Confirm Password mismatch!!");
	}
	else if(document.getElementById("state") == "Select State" || document.getElementById("city").value == "Select City" ) 
	{
		alert("State or City are not Selected!!");	
	}
	else 
	{
		alert("User created Successfully");
	}
	return;	
}
function createCity() 
{
	var cityObject = document.getElementById("cities");
	var stateObject = document.getElementById("state");
	alert(stateObject.value);
	switch(stateObject.value) {
		case "Rajasthan" :
			cityObject.innerHTML = "<Option>Jaipur</option><Option>Bikaner</option><Option>Kota</option><Option>Ajmer</option>";
			break;
		case "gujarat" :
			cityObject.innerHTML = "<Option>Ahmedabad</option><Option>Surat</option><Option>Vadodara</option><Option>Rajkot</option>";
			break;
		case "Uttar pradesh" :
			cityObject.innerHTML = "<Option>Agra</option><Option>Kanpur</option><Option>Aligarh</option><Option>Mathura</option>";
			break;
		case "uttarakhand":
			cityObject.innerHTML = "<Option>Dehradun</option><Option>Haridwar</option><Option>Roorkee</option><Option>Rishikesh</option>";
			break;
		case "punjab":
			cityObject.innerHTML = "<Option>Amritsar</option><Option>Jalandhar</option><Option>Patiala</option><Option>chandigarh</option>";
			break;
	}
}


