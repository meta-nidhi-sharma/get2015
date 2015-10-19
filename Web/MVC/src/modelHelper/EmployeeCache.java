package modelHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import model.Employee;
/**
 * @author Nidhi Sharma
 * Date: 17 October,2015
 */
public class EmployeeCache {

	public static Map<Integer, Employee> employeeCache = new ConcurrentHashMap<Integer, Employee>();

	public static void add(Employee e) {
		employeeCache.put(e.getEmployeeId(), e);
	}

	public  static Employee getByEmpId(int EmpId) {

		if (employeeCache.containsKey(EmpId)) {

			return employeeCache.get(EmpId);

		} else {
			return null;
		}

	}

	public  static List<Employee> getAllEmployee() {
         List<Employee> employeeList=new LinkedList<Employee>(employeeCache.values());
         for(Employee e : employeeList) {
 			System.out.println("Classsss = "+e.getName());
 		}
		return (employeeList); 

	}

}
