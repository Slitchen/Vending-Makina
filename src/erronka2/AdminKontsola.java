package erronka2;

import java.util.Scanner;

import javax.swing.JFrame;

public class AdminKontsola {

	/**
	 * Administratzaile kontsolan sartzeko metodoa. Erabiltzailea eta pasahitza baliozkotzen ditu,
	 * eta administratzailearen menu nagusia kargatzen du baliozkotzea arrakastatsua bada.  
	 * @param sc Scanner objektua, erabiltzailea input-a jasotzeko.
	 * @param motak  Moten arraya, string-ak edukitzen dituena.
	 * @param izenak Izenen arraya, string-ak edukitzen dituena.
	 * @param kodeak Kodeen arraya, string-ak edukitzen dituena.
	 * @param prezioak Prezioen arraya, double-ak edukitzen dituena.
	 * @param argazkiIzenak Argazkien izenen arraya, string-ak edukitzen dituena.
	 * @param datuak Datuen array bikoitza, string-ak edukitzen dituena.
	 * @param produktuKop Produktu kopurua gordetzeko int balioa.
	 * @param arrayHasieratuak Arrayak hasieratuta dauden ala ez adierazten duen boolean balioa.
	 * @param frame JFrame objektua, interfaz grafikoa erakusteko.
	 */
	
	public void Gakoa(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop, boolean arrayHasieratuak, JFrame frame) {

		String erabiltzailea = "";
		String pasahitza = "";
		boolean balidatuta = false;
		System.out.println("Ongi etorri admin menura");

		System.out.println("Erabiltzailea: ");
		erabiltzailea = sc.nextLine();
		System.out.println("Pasahitza: ");
		pasahitza = sc.nextLine();
		balidatuta = Balidazioak.balidatuGakoa(erabiltzailea, pasahitza);
		if (balidatuta == false) {
			frame.setVisible(true); // Muestra la ventana gráfica
			return;
		}

		MenuAdmin.menu1(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, produktuKop, arrayHasieratuak, frame);

	}

}