package erronka2;

import java.util.Scanner;

import javax.swing.JFrame;

public class MenuAdmin {
	// Produktuen datuak gordetzeko arrayak

	public static void menu1(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop, boolean arrayHasieratuak, JFrame frame) {
		int aukera = 0;
		String saukera = "";
		boolean error = true;
		boolean gora = true;

		do {
			do {
				System.out.println("***********************************");
				System.out.println("Menu nagusi");
				System.out.println("***********************************");
				System.out.println("1. Gehitu produktuak: ");
				System.out.println("2. Ezabatu produktuak: ");
				System.out.println("3. Modifikatu produktuak: ");
				System.out.println("4.Atera: ");
				System.out.println("");
				saukera = sc.nextLine();
				Balidazioak.balidazio1(aukera, saukera);
				error = Balidazioak.balidazio1(aukera, saukera);
			} while (error);
			aukera = Integer.parseInt(saukera);
			switch (aukera) {

			case 1: // produktuak gehitzeko menua, datuak eskatuko ditu , eta behin balidatutak
					// gordeko ditu arrayan, arrayaren azken atalean
				boolean baiEZ;
				String baiEz = "";
				do {
					Metodoak.produktuakGehitu(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, produktuKop);
					produktuKop++;
					System.out.println("***********************************");

					do {
						System.out.println("Gehitu nahi duzu produktu gehiago?(Bai/Ez)");
						baiEz = sc.nextLine();
						baiEZ = Balidazioak.balidatutaBaiEz(baiEz);
					} while (baiEZ == false);
					baiEZ = Balidazioak.baiEdoEz(baiEz);
				} while (baiEZ == true);
				break;
			case 2:
				Metodoak.produktuakEzabatu(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, produktuKop);
				produktuKop--;
				break;
			case 3:
				
				Metodoak.produktuaModifikatu(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, produktuKop);
				
				Metodoak.produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);
				break;
			case 4:
				Metodoak.programarenAmaiera(frame);
				arrayHasieratuak(arrayHasieratuak);
				return;
			default:
			}
		} while (gora);// beti buklean egoteko
	}
	public static boolean arrayHasieratuak(boolean arrayHasieratuak) {
		arrayHasieratuak = true;
		return arrayHasieratuak;
	}

}