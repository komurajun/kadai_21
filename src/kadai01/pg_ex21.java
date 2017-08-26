package kadai01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class pg_ex21 {

	public static void main(String[] arg) throws IOException {

		File fileimput = new File("c:\\temp\\README.md");
		File fileoutput = new File("c:\\temp\\ANS.md");
		BufferedReader brimput = new BufferedReader(new FileReader(fileimput));
		BufferedWriter broutput = new BufferedWriter(new FileWriter(fileoutput));
		String str;

		int kihonryokin = 1000;

		int tuwakihon = 20;

		int hirutokuwaribikikeisan = 5;
		int tuwakeisan = 0;

		int kazokuflg = 0;
		int hiruflg = 0;
		int tuwaans = 0;

		String keiyakudenwa = "";
		String shikiri = "====================";

		String denwatoroku[] = new String[2];

		int i = 0;
	    int j = 0;
		int firstflg = 0;

		while ((str = brimput.readLine()) != null) {


			// 契約情報取得
			int keiyakujoho = Integer.parseInt(str.substring(0, 1));

			if (keiyakujoho == 0) {
				i = 0;
				j = 0;
				kazokuflg = 0;
				hiruflg = 0;
				if (firstflg != 0) {
					broutput.write("1" + " " + keiyakudenwa + " ");
					broutput.newLine();
					broutput.write("5" + " " + kihonryokin + " ");
					broutput.newLine();
					broutput.write("7" + " " + tuwaans + " ");
					broutput.newLine();
					broutput.write("9" + " " + shikiri + " ");
					broutput.newLine();

					keiyakudenwa = "";
					kihonryokin = 1000;
					tuwaans = 0;

				}
				firstflg++;
			}
			// 契約者情報
			else if (keiyakujoho == 1) {
				keiyakudenwa = str.substring(2);
			}
			// 加入サービス情報
			else if (keiyakujoho == 2) {
				kazokuflg = 1;
				if (!str.substring(2, 3).equals("E")) {
					if (str.substring(2, 3).equals("C")) {
						kihonryokin = 1100;
					}
					String kanyuservicejoho = str.substring(5);
					denwatoroku[i] = kanyuservicejoho;
					i ++;

				}
			}
			if (str.substring(2, 3).equals("E")) {
				kihonryokin += 200;
				hiruflg = 1;
			}

			// 通話記録
			else if (keiyakujoho == 5) {
				int tuwakaishizikoku = Integer.parseInt(str.substring(13, 15));
				String tuwakaishizikan = str.substring(19, 22);
				String tuwasakidenwabango = str.substring(23);

				tuwakeisan = 20;

				if (hiruflg == 1) {
					if (tuwakaishizikoku >= 8 && tuwakaishizikoku < 18) {
						tuwakeisan = tuwakihon - hirutokuwaribikikeisan;
					}
				}
				if (kazokuflg == 1) {
						if (denwatoroku[j].equals(tuwasakidenwabango)) {
							tuwakeisan = tuwakeisan / 2;
						}
					    j ++;
				}

				tuwaans += tuwakeisan * Integer.parseInt(tuwakaishizikan);
				System.out.println(tuwaans);

			}
		}

		brimput.close();
		broutput.close();

	}
}
