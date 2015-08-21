package MenuBasedTrainReservationSystem;
/**
 * @author Nidhi
 * Description: This class is main class calling different functions to perform train reservation 
 *                related operations
 **/   
public class MainClass
{
	public static int i=1;
	public static void main(String[] args)
	{
		Menu obj=new Menu();		//Creating Object
		obj.setMenu();
		while(i==1)
		{
			obj.displayMenu();
			MenuItem m =new MenuItem();
			m.menuChosen(obj.chooseOption());
		}
	}
}
