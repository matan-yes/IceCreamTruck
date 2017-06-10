
public interface IceCreamTruck {
	//Strat shift
	public void startShift();
	//Return all states of the system
	public String getMode();
	//driver see a group of children
	public void driverSeeKidsGroup();
	//driver gets an alarm of kids group location
	public void kidsGroupAlertFromCenter();
	//the driver catch the group of kind
	public void kidsFound();
	//the car is broken
	public void carBroken();
	//car is fixed
	public void carFixed();
	//the shift ended
	public void endShift();
	//return the number of chases
	public int getNumberOfChases();
	//return the number of successful chases
	public int getNumberOfSuccessfulChases();
	
	

}
