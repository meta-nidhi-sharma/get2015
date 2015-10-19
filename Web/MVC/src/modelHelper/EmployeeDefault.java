package modelHelper;
/**
 * @author Nidhi Sharma
 * Date: 17 October,2015
 */
public class EmployeeDefault {
	
	 private static EmployeeDefault Instance = new EmployeeDefault();
	 
	 private EmployeeDefault() {
		 
	
		EmployeeCache.add(EmployeeHelper.createEmployee( 1,"Chetna", 20,
				"10/01/2015", "cs@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(2,"Anjita", 21,
				"14/10/2015", "anji@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(3,"Nidhi", 22,
				"01/9/2012", "n@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(4,"Richa", 21,
				"13/05/2015", "r@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(5,"Suman", 23,
				"10/11/2015", "suman@gmail.com"));

	}
	
	 public static EmployeeDefault getInstance( ) {
	      return Instance;
	   }
}
