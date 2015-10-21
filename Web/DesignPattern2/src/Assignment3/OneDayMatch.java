package Assignment3;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  The Test match class implementing cricket match functions
 */
public class OneDayMatch extends Cricket{

	@Override
	void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		 System.out.println("Cricket Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		System.out.println("Cricket Game Finished!");
	}

}
