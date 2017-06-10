
public class Test {
	private IceCreamTruck iceCreamTruck;
	
	public void test1() throws InterruptedException{
		iceCreamTruck  = new IceCreamTruckImpl();
		iceCreamTruck.startShift();
		iceCreamTruck.driverSeeKidsGroup();
		Thread.sleep(2000);
		iceCreamTruck.kidsFound();
		//iceCreamTruck.carBroken();
		//Thread.sleep(50);
		//iceCreamTruck.carFixed();
		iceCreamTruck.driverSeeKidsGroup();
		iceCreamTruck.endShift();
		System.out.println(iceCreamTruck.getMode());
	}

}
