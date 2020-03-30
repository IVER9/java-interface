package education.oop.basic;

public class OrderAcceptance implements OrderAcceptation {
	
	private String item;
	@Override
	public String[] queryItems() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return new String[] {
				"�e���r", "�m�[�g�p�\�R��", "�^�u���b�g", "DVD�v���[���["
		};
	}

	@Override
	public boolean order(String item) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
