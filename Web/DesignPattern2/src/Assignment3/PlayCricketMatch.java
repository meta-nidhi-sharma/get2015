package Assignment3;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  Main Class
 */
public class PlayCricketMatch {

	public static void main(String args[]){
		Cricket game = new OneDayMatch();
		game.play();
	    System.out.println();
	    game = new T20Match();
	    game.play();
	    System.out.println();
	    game = new TestMatch();
	    game.play();
	}
}
