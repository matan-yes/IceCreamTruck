
public class Cruise implements IceCreamTruckState {

	IceCreamTruckImpl iceCreamTruck;
	PursuitThread pursuitThread;
	
	public Cruise(IceCreamTruckImpl _iceCreamTruckImpl) {
		iceCreamTruck = _iceCreamTruckImpl;
	}
	
	@Override
	public void startShift() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
	}

	@Override
	public void endShift() {
		System.out.println("exit Cruise state");
		System.out.println("enter Parking state");		
		iceCreamTruck.light.turnOff();
		System.out.println("Total number of pursuit in shift: " + iceCreamTruck.totalPursuit);
		System.out.println("Total number of succsseful pursuit in shift: " + iceCreamTruck.successfulPursuit);
		iceCreamTruck.totalPursuit = 0;
		iceCreamTruck.successfulPursuit = 0;
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carBroken() {
		iceCreamTruck.broken = true;
		iceCreamTruck.light.turnOff();
		System.out.println("exit Cruise state");
		System.out.println("enter Parking state");
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carFixed() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
	}

	@Override
	public void kidsFound() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
	}

	@Override
	public void driverSeeKidsGroup() {
		if (iceCreamTruck._pursuitThread != null)
		{
			iceCreamTruck._pursuitThread.stopThread = true;
		}
		iceCreamTruck._pursuitThread = new PursuitThread(iceCreamTruck);
		(new Thread(iceCreamTruck._pursuitThread)).start();
		iceCreamTruck.speaker.turnOn();
		iceCreamTruck.totalPursuit++;
		iceCreamTruck.pursuit = true;
		System.out.println("exit Cruise state");
		System.out.println("enter Pursuit state");		
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}

	

	@Override
	public void kidsGroupAlertFromCenter() {
		iceCreamTruck.speaker.turnOn();
		iceCreamTruck.totalPursuit++;
		iceCreamTruck.pursuit = true;
		System.out.println("exit Cruise state");
		System.out.println("enter Pursuit state");		
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}
	
	public String getMode(){
		return "Cruise Mode";
	}

}
