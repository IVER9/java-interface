package education.oop.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console {

	private PrintStream out = System.out;

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		
		Console console = new Console();
		console.init();
	}
	// 初期画面
	public void init() {

		out.println("############################################");
		out.println("模擬アプリケーション");
		out.println("1,注文受付システム");
		out.println("2,貨物追跡サービス");
		out.println("3,終了");
		out.println("業務を選択してください");

		try {
			String reply = in.readLine();
			if ("1".equalsIgnoreCase(reply)) {
				// 注文受付システムが選択された場合の処理を呼びだす
				runOrderAcceptance();
			} else if ("2".equalsIgnoreCase(reply)) {
				// 貨物追跡サービスが呼ばれた場合の処理を呼び出す
				runCargoTracking();
				init();
			} else if ("3".equalsIgnoreCase(reply)) {
				// 終了が選択された場合の処理を呼び出す
				finalize();
			} else {
				// メニューを再表示
				init();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 注文受付システムが選択された場合
	protected void runOrderAcceptance() {

		out.println("注文受付システム");
		out.println();

		// 商品一覧を表示する
		OrderAcceptance oa = new OrderAcceptance();
		String[] items = oa.queryItems();

		for (int i = 0; i < items.length; i++) {
			out.println((i + 1) + ". " + items[i]);
		}
		out.println((items.length + 1) + ". 終了");
		out.println("注文商品を選択してください　＝＞");

		// 商品が選択された場合の処理
		try {
			int choice = Integer.parseInt(in.readLine());
			if (choice == items.length + 1) {
				init();
			} else {
				String item = items[choice - 1];
				if (oa.order(item)) {
					out.println(item + "の在庫がありました");
					out.println("注文を確定させますか？{Y/N}　=>");
					String reply = in.readLine();

					if ("Y".equalsIgnoreCase(reply)) {
						out.println();
						out.println("名前を入力してください");
						String name = in.readLine();

						out.println();
						out.println("お届け先を入力してください");
						String address = in.readLine();

						// 商品を確定された場合の処理
						String queryNo = oa.confirm(name, address);
						out.println("商品を確定させました");
						out.println("お問い合わせ番号：" + queryNo);
						out.println("買い物をつづけますか？{Y/N}　=>");
						String rep = in.readLine();

						if ("Y".equalsIgnoreCase(rep)) {
							out.println();
							runOrderAcceptance();
						} else {
							out.println("ご利用ありがとうございました。");
							init();
						}

					} else {
						out.println();
						runOrderAcceptance();
					}
				} else {
					out.println("在庫がありませんでした。ほかの商品を選択してください");
					out.println();
					runOrderAcceptance();
				}
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			out.println("メニュー番号を選択してください");
			runOrderAcceptance();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 貨物追跡サービスが選択された場合
	protected void runCargoTracking() {

		out.println("貨物追跡サービス");
		out.println();
		out.println("お問い合わせ番号を入力してください");

		try {
			String queryNo = in.readLine();
			CargoTracking tracker = new DeliveryManager();

			String state = tracker.track(queryNo);

			out.println("お問い合わせ番号：" + queryNo);
			out.println("配送状況");
			out.println(state);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 終了が選択された場合
	protected void finalize() {
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
