
public class IceCreamTruckImpl implements IceCreamTruck {

	public IceCreamTruckState Cruise;
	public IceCreamTruckState Pursuit;
	public IceCreamTruckState Parking;
	
	public IceCreamTruckState iceCreamTruckState; // for current state
	
	public int totalPursuit;
	public int successfulPursuit;
	public boolean broken;
	public boolean pursuit;
	public Light light;
	public Speaker speaker;
	public PursuitThread _pursuitThread;
	
	public IceCreamTruckImpl(){
		
		Cruise = new Cruise(this);
		Pursuit = new Pursuit(this);
		Parking = new Parking(this);
		
		iceCreamTruckState = Parking;
		System.out.println("enter Parking state");
		totalPursuit = 0;
		successfulPursuit = 0;
		broken = false;
		pursuit = false;
		light = new Light();
		speaker = new Speaker();
		
	}
	
	
	@Override
	public void startShift() {
		iceCreamTruckState.startShift();
	}

	@Override
	public String getMode() {
		return iceCreamTruckState.getMode();
	}

	@Override
	public void driverSeeKidsGroup() {
		iceCreamTruckState.driverSeeKidsGroup();
	}

	@Override
	public void kidsGroupAlertFromCenter() {
		iceCreamTruckState.kidsGroupAlertFromCenter();
	}

	@Override
	public void kidsFound() {
		iceCreamTruckState.kidsFound();
	}

	@Override
	public void carBroken() {
		iceCreamTruckState.carBroken();
	}

	@Override
	public void carFixed() {
		iceCreamTruckState.carFixed();
	}

	@Override
	public void endShift() {
		iceCreamTruckState.endShift();
	}

	@Override
	public int getNumberOfChases() {
		return totalPursuit;
	}

	@Override
	public int getNumberOfSuccessfulChases() {
		return successfulPursuit;
	}
	
	public void setIceCreamTruckState(IceCreamTruckState _iceCreamTruckState)
	{
		iceCreamTruckState = _iceCreamTruckState;
	}
	
	public IceCreamTruckState getCruise() { return Cruise; }
	public IceCreamTruckState getParking() { return Parking; }
	public IceCreamTruckState getPursuit() { return Pursuit; }

}
