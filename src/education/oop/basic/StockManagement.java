package education.oop.basic;

public interface StockManagement {

	//問い合わせを受けて在庫をかえす
	public int queryStock(String item);
	//出荷指示を受けて番号をかえす。
	public String skip(String name, String address, String item);
}
