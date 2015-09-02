package EmployeesCollection;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class NameComparator implements Comparator {

	@Override
	public int compare(Object e1, Object e2) {
		Employee em1 = (Employee) e1;
		Employee em2 = (Employee) e2;
		return (int)(em1.getEmployeeName().compareTo(em2.getEmployeeName()));
	}

}

