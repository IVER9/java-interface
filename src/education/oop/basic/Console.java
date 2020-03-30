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
	// �������
	public void init() {

		out.println("############################################");
		out.println("�͋[�A�v���P�[�V����");
		out.println("1,������t�V�X�e��");
		out.println("2,�ݕ��ǐՃT�[�r�X");
		out.println("3,�I��");
		out.println("�Ɩ���I�����Ă�������");

		try {
			String reply = in.readLine();
			if ("1".equalsIgnoreCase(reply)) {
				// ������t�V�X�e�����I�����ꂽ�ꍇ�̏������Ăт���
				runOrderAcceptance();
			} else if ("2".equalsIgnoreCase(reply)) {
				// �ݕ��ǐՃT�[�r�X���Ă΂ꂽ�ꍇ�̏������Ăяo��
				runCargoTracking();
				init();
			} else if ("3".equalsIgnoreCase(reply)) {
				// �I�����I�����ꂽ�ꍇ�̏������Ăяo��
				finalize();
			} else {
				// ���j���[���ĕ\��
				init();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ������t�V�X�e�����I�����ꂽ�ꍇ
	protected void runOrderAcceptance() {

		out.println("������t�V�X�e��");
		out.println();

		// ���i�ꗗ��\������
		OrderAcceptance oa = new OrderAcceptance();
		String[] items = oa.queryItems();

		for (int i = 0; i < items.length; i++) {
			out.println((i + 1) + ". " + items[i]);
		}
		out.println((items.length + 1) + ". �I��");
		out.println("�������i��I�����Ă��������@����");

		// ���i���I�����ꂽ�ꍇ�̏���
		try {
			int choice = Integer.parseInt(in.readLine());
			if (choice == items.length + 1) {
				init();
			} else {
				String item = items[choice - 1];
				if (oa.order(item)) {
					out.println(item + "�̍݌ɂ�����܂���");
					out.println("�������m�肳���܂����H{Y/N}�@=>");
					String reply = in.readLine();

					if ("Y".equalsIgnoreCase(reply)) {
						out.println();
						out.println("���O����͂��Ă�������");
						String name = in.readLine();

						out.println();
						out.println("���͂������͂��Ă�������");
						String address = in.readLine();

						// ���i���m�肳�ꂽ�ꍇ�̏���
						String queryNo = oa.confirm(name, address);
						out.println("���i���m�肳���܂���");
						out.println("���₢���킹�ԍ��F" + queryNo);
						out.println("���������Â��܂����H{Y/N}�@=>");
						String rep = in.readLine();

						if ("Y".equalsIgnoreCase(rep)) {
							out.println();
							runOrderAcceptance();
						} else {
							out.println("�����p���肪�Ƃ��������܂����B");
							init();
						}

					} else {
						out.println();
						runOrderAcceptance();
					}
				} else {
					out.println("�݌ɂ�����܂���ł����B�ق��̏��i��I�����Ă�������");
					out.println();
					runOrderAcceptance();
				}
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			out.println("���j���[�ԍ���I�����Ă�������");
			runOrderAcceptance();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// �ݕ��ǐՃT�[�r�X���I�����ꂽ�ꍇ
	protected void runCargoTracking() {

		out.println("�ݕ��ǐՃT�[�r�X");
		out.println();
		out.println("���₢���킹�ԍ�����͂��Ă�������");

		try {
			String queryNo = in.readLine();
			CargoTracking tracker = new DeliveryManager();

			String state = tracker.track(queryNo);

			out.println("���₢���킹�ԍ��F" + queryNo);
			out.println("�z����");
			out.println(state);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// �I�����I�����ꂽ�ꍇ
	protected void finalize() {
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
