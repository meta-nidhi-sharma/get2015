package rest;
 
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Model.Employee;
 
@Path("/employeeManagement")
public class EmployeeManagement {

	
	@POST
	@Produces("application/xml")
	@Path("add/{id}/{name}/{designation}")
	public String add(@PathParam("id") int id, @PathParam("name") String name, @PathParam("designation") String designation) {
		int flag = 0;
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setDesignation(designation);
		Service service = new Service();
		flag = service.addNewEmployee(emp);
		System.out.println("Emp :" + emp);
		if(flag != 0)
			return "<Employee created Successfully> Created </Employee created Successfully>";
		else
			return "<Error creating Employee> Not Created </Error creating Employee>";
	
	}
	
	@DELETE
	@Produces("application/xml")
	@Path("delete/{id}")
	public String delete(@PathParam("id") int id) {
		int flag = 0;
		Employee emp = new Employee();
		emp.setId(id);
		System.out.println("hii");
		Service service = new Service();
		flag = service.deleteEmployee(emp);
		System.out.println("Emp :" + flag);
		if(flag != 0)
			return "<Employee deleted Successfully> Deleted </Employee deleted Successfully>";
		else
			return "<Error deleting Employee> Not Deleted </Error deleting Employee>";
		
	}
	
	@GET
	@Produces("application/xml")
	@Path("retrieveById/{id}")
	public String retrieveById(@PathParam("id") int id) {

		Employee emp = new Employee();
		emp.setId(id);
	 
		Service service = new Service();
		
		Employee e = service.retrieveEmployeeById(emp);
		
		System.out.println("<Employee Details>" + " <Name> " + e.getName() + "</Name>" + "<ID>" + e.getId() + ""
				+ "</ID>" + "<Designation>" + e.getDesignation() + "</Designation>" + "</Employee Details>");
		return "<Employee Details>" + " <Name> " + e.getName() + "</Name>" + "<ID>" + e.getId() + ""
				+ "</ID>" + "<Designation>" + e.getDesignation() + "</Designation>" + "</Employee Details>";
		
	}
	
	@GET
	@Produces("application/xml")
	@Path("retrieveByName/{name}")
	public String retrieveByName(@PathParam("name") String name) {

		Employee emp = new Employee();
		emp.setName(name);
		Service service = new Service();
		Employee e = service.retrieveEmployeeByName(emp);
		System.out.println("Employee Details : \n Name : " + e.getName() + " ID " + e.getId() + " Designation " + e.getDesignation());
		return "Employee Details : \n Name : " + e.getName() + " ID " + e.getId() + " Designation " + e.getDesignation();		
	}
	
	@GET
	@Produces("application/xml")
	@Path("/retrieveAll")
	public String retrieveAll() {
		
		String s = "";
		Service service = new Service();
		List<Employee> empList = service.retrieveAllEmployee();
		for(Employee emp : empList){
			System.out.println("Employee Details : \n Name : " + emp.getName() + " ID " + emp.getId() + " Designation " + emp.getDesignation() + "\n");
			s += "Employee Details : \n Name : " + emp.getName() + " ID " + emp.getId() + " Designation " + emp.getDesignation() + "\n";
		}
		System.out.println(s);
		return s;
		
	}
}
