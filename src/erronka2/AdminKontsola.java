package erronka2;

import java.util.Scanner;

import javax.swing.JFrame;

public class AdminKontsola {

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