package education.oop.basic;

public class DeliveryManager implements Delivery, CargoTracking {

	@Override
	public String track(String queryNo) {
		
		return "���₢���킹�̉ݕ��͏o�ׂ���܂���";
	}

	@Override
	public String deliver(String name, String address, String item) {
		
		return "185200";
	}

}
