package education.oop.basic;

public class OrderAcceptance implements OrderAcceptation {
	
	private String item;
	@Override
	public String[] queryItems() {
		// TODO 自動生成されたメソッド・スタブ
		return new String[] {
				"テレビ", "ノートパソコン", "タブレット", "DVDプレーヤー"
		};
	}

	@Override
	public boolean order(String item) {
		// TODO 自動生成されたメソッド・スタブ
		StockManagement sm = new StockManager();
		this.item = item;
		return sm.queryStock(item) > 0;
	}

	@Override
	public String confirm(String name, String address) {
		
		StockManagement sm = new StockManager();
		return sm.skip(name, address, item);
	}

}
