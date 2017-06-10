
public class PursuitThread implements Runnable {
	
	IceCreamTruckImpl iceCreamTruck;
    public volatile boolean stopThread = false;
    int counter;
    
	public PursuitThread(IceCreamTruckImpl _iceCreamTruckImpl) {
		iceCreamTruck = _iceCreamTruckImpl;
		counter = 0;
	}
	
	public void run(){
		try {
			while (!stopThread)
			{
				if (counter < 10000)
				{
					Thread.sleep(500);
					counter += 500;
				} else { // we reach the 60 seconds
					if(iceCreamTruck.getMode().equals("Pursuit Mode")){
						System.out.println("exit Pursuit state");
						System.out.println("enter Cruise state");
						iceCreamTruck.speaker.turnOff();
						iceCreamTruck.pursuit = false;
						iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAlive() {
		return (stopThread==false && counter < 60500);
	}
}
