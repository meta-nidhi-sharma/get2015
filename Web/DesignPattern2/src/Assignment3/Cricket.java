package Assignment3;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  The 'ConcreteHandler' class
 */
public abstract class Cricket
{
	/*************************
     * Abstract Method
     ************************/
	abstract void initialize();
	/*************************
     * Abstract Method
     ************************/
    abstract void startPlay();
    /*************************
     * Abstract Method
     ************************/
    abstract void endPlay();

    /*******************
     * Play method
     *******************/
    public final void play()
    {
    	//initialize the game
    	initialize();
      
    	//start game
    	startPlay();

    	//end game
    	endPlay();
	}
}