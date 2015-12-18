package deadLockSolution;


public class MainForDeadLockSolution {

	public static void main(String a[]){
		DeadLockSolution mdl = new DeadLockSolution();
        mdl.trd2.start();
        mdl.trd1.start();
      
    }
}
