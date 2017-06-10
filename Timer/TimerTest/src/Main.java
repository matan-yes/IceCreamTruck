import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static boolean pursuite = true;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.out.println("starting");

		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                // your code here
		            	pursuite = false;
		            }
		        }, 
		        5000 
		);
		
		while (pursuite) {
		    System.out.println("pursuiting");
		    Thread.sleep(800);
		}
	    System.out.println(" stop pursuiting");
	}

}
