package modelHelper;



public class EmployeeDefault {
	
	 private static EmployeeDefault Instance = new EmployeeDefault();
	 
	 private EmployeeDefault() {
		 
	
		EmployeeCache.add(EmployeeHelper.createEmployee( 1,"Nidhi", 20,
				"10/10/2015", "nidhi94@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(2,"Richa", 21,
				"14/10/2015", "richa@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(3,"Suman", 22,
				"10/9/2015", "suman@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(4,"Neha", 19,
				"13/10/2015", "neha@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(5,"Chetna", 20,
				"10/11/2015", "chetna@gmail.com"));

	}
	
	 public static EmployeeDefault getInstance( ) {
	      return Instance;
	   }
}
