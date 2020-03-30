package education.oop.basic;

public class DeliveryManager implements Delivery, CargoTracking {

	@Override
	public String track(String queryNo) {
		
		return "‚¨–â‚¢‡‚í‚¹‚Ì‰İ•¨‚Ío‰×‚³‚ê‚Ü‚µ‚½";
	}

	@Override
	public String deliver(String name, String address, String item) {
		
		return "185200";
	}

}
