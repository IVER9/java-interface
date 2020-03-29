package education.oop.basic;

public interface OrderAcceptation {

	//商品照会を受け付けて、取りつかい商品をかえす
	public String[] queryItems();
	
	//商品を受け付けて、受注可否を返す
	public boolean order(String item);
	
	//注文を確定させて、問い合わせ番号をかえす。
	public String confirm(String name, String adress);
}
