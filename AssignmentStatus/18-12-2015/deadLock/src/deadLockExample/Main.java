package deadLockExample;

public class Main {

	public static void main(String a[]){
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd2.start();
        mdl.trd1.start();
      
    }
}
