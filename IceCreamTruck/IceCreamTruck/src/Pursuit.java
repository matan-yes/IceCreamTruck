
public class Pursuit implements IceCreamTruckState {

	IceCreamTruckImpl iceCreamTruck;
	
	public Pursuit(IceCreamTruckImpl _iceCreamTruckImpl) {
		iceCreamTruck = _iceCreamTruckImpl;
	}
	
	@Override
	public void startShift() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}

	@Override
	public void endShift() {
		iceCreamTruck.speaker.turnOff();
		iceCreamTruck.light.turnOff();
		iceCreamTruck.pursuit = false;
		System.out.println("exit Pursuit state");
		System.out.println("enter Parking state");
		System.out.println("Total number of pursuit in shift: " + iceCreamTruck.totalPursuit);
		System.out.println("Total number of succsseful pursuit in shift: " + iceCreamTruck.successfulPursuit);
		iceCreamTruck.totalPursuit = 0;
		iceCreamTruck.successfulPursuit = 0;
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carBroken() {
		iceCreamTruck.speaker.turnOff();
		iceCreamTruck.light.turnOff();
		iceCreamTruck.broken = true;
		System.out.println("exit Pursuit state");
		System.out.println("enter Parking state");
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carFixed() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}

	@Override
	public void kidsFound() {
		iceCreamTruck._pursuitThread.stopThread = true;
		iceCreamTruck.successfulPursuit++;
		iceCreamTruck.speaker.turnOff();
		System.out.println("exit Pursuit state");
		System.out.println("enter Cruise state");
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
	}

	@Override
	public void driverSeeKidsGroup() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}

	@Override
	public void kidsGroupAlertFromCenter() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
	}
	
	public String getMode(){
		return "Pursuit Mode";
	}
}
