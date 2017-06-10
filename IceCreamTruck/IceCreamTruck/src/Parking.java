
public class Parking implements IceCreamTruckState {

	IceCreamTruckImpl iceCreamTruck;
	
	public Parking(IceCreamTruckImpl _iceCreamTruckImpl) {
		iceCreamTruck = _iceCreamTruckImpl;
	}
	
	
	@Override
	public void startShift() {
		if (iceCreamTruck.broken == false) {
			System.out.println("exit Parking state");
			System.out.println("enter Cruise state");
			iceCreamTruck.light.turnOn();
			iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
		}
	}

	@Override
	public void endShift() {
		System.out.println("Total number of pursuit in shift: " + iceCreamTruck.totalPursuit);
		System.out.println("Total number of succsseful pursuit in shift: " + iceCreamTruck.successfulPursuit);
		iceCreamTruck.totalPursuit = 0;
		iceCreamTruck.successfulPursuit = 0;
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carBroken() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void carFixed() {
		iceCreamTruck.broken = false;
		if (iceCreamTruck.pursuit == false) // if we cruised before we got broken
		{
			System.out.println("exit Parking state");
			System.out.println("enter Cruise state");
			iceCreamTruck.light.turnOn();
			iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getCruise());
		} else { // we pursuit before we got broken
			System.out.println("exit Parking state");
			System.out.println("enter Pursuit state");
			iceCreamTruck.light.turnOn();
			iceCreamTruck.speaker.turnOn();
			iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getPursuit());
		}
	}

	@Override
	public void kidsFound() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void driverSeeKidsGroup() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}

	@Override
	public void kidsGroupAlertFromCenter() {
		iceCreamTruck.setIceCreamTruckState(iceCreamTruck.getParking());
	}
	
	public String getMode(){
		return "Parking mode";
	}

}
