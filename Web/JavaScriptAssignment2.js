var index = 5;
function createRow(){
	
            var table=document.getElementById("table1");
            var row=table.insertRow(table.rows.length);
			
            var cell1=row.insertCell(0);
            var t1=document.createElement("input");
			    t1.type="name";
                t1.id = "txtName"+index;
                cell1.appendChild(t1);
				
            var cell2=row.insertCell(1);
            var t2=document.createElement("input");
			    t2.type="number";
                t2.id = "min"+index;
				t2.min = "1";
				t2.max = "10";
                cell2.appendChild(t2);
				
            var cell3=row.insertCell(2);
            var t3=document.createElement("input");
			    t3.type="number";
                t3.id = "max"+index;
				t3.min = "1";
				t3.max = "10";
                cell3.appendChild(t3);
	index++;
}
function removeRow(){
	if(index > 0)
	{
    document.getElementById("table1").deleteRow(index);
	index--;
	}
	else{
		alert("Table is empty");
	}
}

function createGraph(){
	
	var tb = document.getElementById("newTable");
	if(index > 0)
	{
		for(var i=1; i<=index; i++)
		{
			var row=tb.insertRow(-1);
			var min = document.getElementById("min" + i).value;
			var max = document.getElementById("max" + i).value;
			var cell1=row.insertCell(0);
            var t1=document.createElement("input");
			    t1.type="name";
                t1.value = document.getElementById("name" + i).value;
                cell1.appendChild(t1);
			for(var j=1; j<=10; j++)
			{
				 var cell2=row.insertCell(j);
			
				cell2.style.width = '20px';
				cell2.style.border="none";
				if(j>=min && j<=max)
				{
					cell2.style.backgroundColor="red";
				}
			}
		}
	}
	else
	{
		alert("Cant create graph as table is empty");
	}	
	document.getElementById("button1").disabled = true;
	document.getElementById("button2").disabled = true;
	document.getElementById("button3").disabled = true;
	document.getElementById("try1").disabled = true;
}

function validate()
{
	var flag= false;
	for(var count=1; count<=index; count++){
		var nam = document.getElementById("name" + count).value;
		var minimum = document.getElementById("min" + count).value;
		var maximum = document.getElementById("max" + count).value;
			
		if(minimum && maximum && nam)
		{	
			if(minimum<=maximum && minimum<=10 && minimum>=0 && maximum<=10 && maximum>=0)
			{
				flag=true;
			}
			else
			{
				alert("Enter valid values.");
				flag=false;	
			break;
			}
		}
		else
		{
			flag=false;	
			break;
		}
	}
	if(flag)
	{
		document.getElementById("button1").disabled = false;
	}
	else{
		alert("All fields are mandatory");
	}

}
