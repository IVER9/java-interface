package education.oop.basic;

public interface OrderAcceptation {

	//���i�Ɖ���󂯕t���āA���������i��������
	public String[] queryItems();
	
	//���i���󂯕t���āA�󒍉ۂ�Ԃ�
	public boolean order(String item);
	
	//�������m�肳���āA�₢���킹�ԍ����������B
	public String confirm(String name, String adress);
}
