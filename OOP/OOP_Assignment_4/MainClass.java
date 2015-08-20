package MenuBasedTrainReservationSystem;

public class MainClass {

	public static void main(String[] args)
	{
		Menu obj=new Menu();
		obj.setMenu();
		obj.displayMenu();
		MenuItem m =new MenuItem();
		m.menuChosen(obj.chooseOption());
	}
}
