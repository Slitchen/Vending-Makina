package erronka2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Balidazioak {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_CYAN = "\u001B[1;32m";
	public static final String ANSI_RESET = "\u001B[0m";
	Scanner sc = new Scanner(System.in);

	/**
	 * Emandako string bat osorik zenbaki oso batera bihurtzen den ala ez balioztatzen du.
	 * Balioztatzean errorea gertatzen bada, true itzultzen du; bestela, false itzultzen du.
	 *  
	 * @param aukera Zenbaki osoa den aukera.
	 * @param saukera Emandako string parametroa.
	 * @return Errorea gertatzen den edo ez adierazten duen boolean balioa. True errorea gertatzen bada, false ez bada.
	 */
	
	public static boolean balidazio1(int aukera, String saukera) {
		boolean error = true;

		try {
			aukera = Integer.parseInt(saukera);
			error = false;
		} catch (Exception e) {
		}

		return error;
	}

	/**
	 * Erabiltzailearen izena eta pasahitza balioztatzen ditu.
	 * Erabiltzaile izena eta pasahitza "admin" badira, true itzultzen du; bestela, false itzultzen du.
	 *  
	 * @param erabiltzailea 
	 * @param pasahitza
	 * @return Balioztatu diren edo ez adierazten duen boolean balioa. True izena eta pasahitza "admin" badira, false bestela.
	 */
	
	public static boolean balidatuGakoa(String erabiltzailea, String pasahitza) {
		boolean balidatuta = false;

		if (erabiltzailea.equals("admin") && pasahitza.equals("admin")) {
			balidatuta = true;
			return balidatuta;
		} else {
			return balidatuta;
		}

	}

	/**
	 * Produktu motaren kantitatea balioztatzen duen metodoa. Emandako motaren produktu kantitatea
	 * maximo baten azpitik dagoen ala ez egiaztatzen du. 
	 * 
	 * @param mota Motaren izena, adibidez, "janaria", "edaria", "erretzaile", edo "sexshop".
	 * @param motak Produktu motak gordetzen dituen array bat.
	 * @return Balidatuta dagoen edo ez adierazten duen boolean balioa. True emandako motaren kantitatea maximoa gainditzen ez badu, bestela false.
	 */
	
	public static boolean balidatuKant(String mota, String[] motak) {
		boolean balidatuta = true;
		int kant = 0;
		int kantMax = 9;
		if (mota.equals("janaria")) {
			for (int i = 0; i < motak.length; i++) {// produktuak pantailaruko ditu
				if (motak[i] == "janaria") {
					kant++;
				}
			}
			if (kant < kantMax) {
				return balidatuta;
			} else {
				balidatuta = false;
				System.out.println(ANSI_RED + "ez dira gehiago sartzen" + ANSI_RESET);
				return balidatuta;
			}

		} else if (mota.equals("edaria")) {
			for (int i = 0; i < motak.length; i++) {// produktuak pantailaruko ditu
				if (motak[i] == "edaria") {
					kant++;
				}
			}
			if (kant < kantMax) {
				return balidatuta;
			} else {
				balidatuta = false;
				System.out.println(ANSI_RED + "ez dira gehiago sartzen");
				return balidatuta;
			}
		} else if (mota.equals("erretzaile")) {
			for (int i = 0; i < motak.length; i++) {// produktuak pantailaruko ditu
				if (motak[i] == "erretzaile") {
					kant++;
				}
			}
			if (kant < kantMax) {
				return balidatuta;
			} else {
				balidatuta = false;
				System.out.println(ANSI_RED + "ez dira gehiago sartzen" + ANSI_RESET);
				return balidatuta;
			}
		} else if (mota.equals("sexshop")) {
			for (int i = 0; i < motak.length; i++) {// produktuak pantailaruko ditu
				if (motak[i] == "sexshop") {
					kant++;
				}
			}
			if (kant < kantMax) {
				return balidatuta;
			} else {
				balidatuta = false;
				System.out.println(ANSI_RED + "ez dira gehiago sartzen" + ANSI_RESET);
				return balidatuta;
			}
		} else {
			balidatuta = false;
			return balidatuta;
		}

	}

	/**
	 * Jakiteko emandako aukeren artean(bai edo ez)  zein sartu den
	 * 
	 * @param baiEz Emandako string parametroa, balioztatu behar dena.
	 * @return Balioztatu diren edo ez adierazten duen boolean balioa. True string-ak "bai" balio duenenean, bestela false.
	 */
	
	public static boolean baiEdoEz(String baiEz) {
		boolean bai = false;
		if (baiEz.equalsIgnoreCase("bai")) {
			bai = true;
			return bai;
		} else {
			return bai;
		}
	}
	
	/**
	 * Emandako string baten balioa balioztatzen du eta "Bai" edo "Ez" bada, true itzultzen du; bestela false.
	 * Emandako string-a "Bai" edo "Ez" den ala ez adierazten du, hizkuntza handi eta txikiak kontuan hartuta.
	 * 
	 * @param baiEz Emandako string parametroa, balioztatu behar dena.
	 * @return Balioztatu diren edo ez adierazten duen boolean balioa. True string-ak "Bai" edo "Ez" balio duenenean, bestela false.
	 */
	
	public static boolean balidatutaBaiEz(String baiEz) {
		boolean balidatuta = false;
		if (baiEz.equalsIgnoreCase("Bai") || baiEz.equalsIgnoreCase("Ez")) {
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED + "Formatua txarto dago" + ANSI_RESET);
			return balidatuta;
		}
	}

	/**
	 * Balidatuko du sartutakostring  double-ra psasa ahal deen edo ez
	 * 
	 * @param sPrezioa Prezioaren balioa duen string parametroa.
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True string-ak double formatura bihurtu bada, bestela false.
	 */
	
	public static boolean balidatuPrezioa(String sPrezioa) {
		boolean balidatuta = false;

		try {
			Double.parseDouble(sPrezioa);
			balidatuta = true;

		} catch (Exception e) {
			System.out.println(ANSI_RED + "txarto dago prezio formatua" + ANSI_RESET);

		}
		return balidatuta;
	}

	/**
	 * Emandako string-a izen baliodun bat den ala ez balioztatzen du.
	 * String-a gutxienez bi karaktere izan behar ditu eta bakarrik letrak (maiuskulak eta minuskulak) eta espazioak izan ditzake. 
	 * 
	 * @param izena
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True string-ak formatu zuzena badu, bestela false.
	 */
	
	public static boolean balidatuIzena(String izena) {
		boolean balidatuta = false;
		if (izena.matches("[a-zA-Z ]{2,}")) {// errespetatu behar duen formatua, [a-zA-Z ] letra larriak, xeheak eta
												// espazioak hartzen ditu, {2,} gutxienez bi karaktere
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED + "Txarto dago" + ANSI_RESET);
			return balidatuta;
		}
	}

	/**
	 * Emandako string-a kode baliodun bat den ala ez balioztatzen du.
	 * Kodeak "A" letra batekin hasi behar du eta ondoren hiru zenbaki izan behar ditu.
	 * 
	 * @param kodea
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True string-ak formatu zuzena badu, bestela false.
	 */
	public static boolean balidatuKodea(String kodea) {
		boolean balidatuta = false;
		if (kodea.matches("[A][0-9]{3}")) {// errespetatu behar duen formatua
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println("Txarto dago");
			return balidatuta;
		}
	}

	/**
	 * Emandako string-a kode baliodun bat den ala ez balioztatzen du.
	 * Kodea balioduna dela eta kodeak arrayan dagoenik ez dela ziurtatzen du.
	 * 
	 * @param kodea Balioztatu behar den kodea.
	 * @param produktuKop Produktu kopurua, kodeak arrayan dauden kodeen kopurua adierazten duena.
	 * @param kodeak Produktu kodeak gordetzen dituen arraya.
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True kodea balioduna bada eta arrayan errepikatzen ez bada, bestela false.
	 */
	
	public static boolean balidatuKodeaDesberdina(String kodea, int produktuKop, String[] kodeak) {
		boolean balidatuta = false;
		balidatuta = balidatuKodea(kodea); // Asegura que el código es válido

		if (balidatuta) {
			for (int i = 0; i < produktuKop; i++) {
				String kodeaI = kodeak[i]; // Asigna el código actual del array

				// Verifica si kodeaI es null antes de comparar
				if (kodeaI != null && kodeaI.equals(kodea)) {
					System.out.println("Kodea ezin da errepikatu");
					balidatuta = false;
					break; // Sale del bucle si encuentra un duplicado
				}
			}
		}
		return balidatuta;
	}

	/**
	 * Emandako string-a produktu mota baliodun bat den ala ez balioztatzen du.
	 * Produktu motaren balioa "janaria", "edaria", "sexshop" edo "erretzaile" bada, true itzultzen du, bestela false.
	 * 
	 * @param mota Mota balioa duen string parametroa.
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True string-ak formatu zuzena badu, bestela false.
	 */
	public static boolean balidatuMota(String mota) {
		boolean balidatuta = false;
		if (mota.matches("janaria") || mota.matches("edaria") || mota.matches("sexshop")
				|| mota.matches("erretzaile")) {
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED + "Txarto dago" + ANSI_RESET);
			return balidatuta;
		}
	}
	
	/**
	 * Emandako string-a ordainketa baliodun bat den ala ez balioztatzen du.
	 * String-a double formatura bihur daitekeen ala ez egiaztatzen du.
	 * 
	 * @param sOrdainketa Ordainketa balioa duen string parametroa.
	 * @return Balioztatu den edo ez adierazten duen boolean balioa. True string-ak double formatura bihurtu bada, bestela false.
	 */

	public static boolean balidatuOrdainketa(String sOrdainketa) {
		boolean balidatuta = false;

		try {
			Double.parseDouble(sOrdainketa);
			balidatuta = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ezin duzu ordaindu letrekin :(");

		}
		return balidatuta;
	}

}