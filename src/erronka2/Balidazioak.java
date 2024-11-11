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
	 * sartutako zenbakia , zenbaki bat den ala ez balidatuko du
	 * 
	 * @param aukera  gordetzeko zenbakia
	 * @param saukera String non aukera sartzen da geroago begirazeko zenbakia bat
	 *                den ala ez
	 * @return zenbakia den a al ez, zenbakia bada error= false, zenbakia ez bada
	 *         error = true
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
	 * sartutako gakoak balidatuko ditu
	 * 
	 * @param erabiltzailea
	 * @param pasahitza
	 * @return balidatuta badago true, ez badago false
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
	 * balidatuko du sartu nahi den produktu berria, bere motan lekua izan dadin
	 * 
	 * @param mota
	 * @param motak
	 * @return
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
				System.out.println(ANSI_RED+"ez dira gehiago sartzen"+ANSI_RESET);
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
				System.out.println(ANSI_RED+"ez dira gehiago sartzen");
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
				System.out.println(ANSI_RED+"ez dira gehiago sartzen"+ANSI_RESET);
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
				System.out.println(ANSI_RED+"ez dira gehiago sartzen"+ANSI_RESET);
				return balidatuta;
			}
		} else {
			balidatuta = false;
			return balidatuta;
		}

	}

	/**
	 * jakiteko bai edo ez aukeren artean zein sartu den
	 * 
	 * @param baiEz
	 * @return bai bada true itzuliko du, bestela false
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
	 * balidatuko du sartutakoa bai edo ez dela, letra xehez edo larriz dagoen
	 * kontuan hartu gabe
	 * 
	 * @param baiEz
	 * @return balidatuta badago true, bestela false
	 */
	public static boolean balidatutaBaiEz(String baiEz) {
		boolean balidatuta = false;
		if (baiEz.equalsIgnoreCase("Bai") || baiEz.equalsIgnoreCase("Ez")) {
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED+"Formatua txarto dago"+ANSI_RESET);
			return balidatuta;
		}
	}

	/**
	 * balidatuko du sartutakoa double dela
	 * 
	 * @param sPrezioa
	 * @return prezioa double bada true itzuliko du, bestela false
	 */
	public static boolean balidatuPrezioa(String sPrezioa) {
		boolean balidatuta = false;

		try {
			Double.parseDouble(sPrezioa);
			balidatuta = true;
			
		} catch (Exception e) {
			System.out.println(ANSI_RED+"txarto dago prezio formatua"+ANSI_RESET);
			
		}
		return balidatuta;
	}

	/**
	 * balidatuko du izena
	 * 
	 * @param izena
	 * @return ondo badago true itzuliko du, bestela false
	 */
	public static boolean balidatuIzena(String izena) {
		boolean balidatuta = false;
		if (izena.matches("[a-zA-Z ]{2,}")) {// errespetatu behar duen formatua, [a-zA-Z ] letra larriak, xeheak eta espazioak hartzen ditu, {2,} gutxienez bi karaktere
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED+"Txarto dago"+ANSI_RESET);
			return balidatuta;
		}
	}

	/**
	 * balidatuko du kodea
	 * 
	 * @param kodea
	 * @return ondo badago true itzuliko du, bestela false
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
	 * balidatuko du ea kodea errepikatuta dagoen eta balidatuKodea deituko du
	 * formatu onan dagoen ala ez balidatzeko
	 * 
	 * @param kodea
	 * @param produktuKop
	 * @param kodeak
	 * @return ondo badago true itzuliko du, bestela false
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
	 * balidatuko du ea emandako 4 moten artean bat hartzen duen
	 * 
	 * @param mota
	 * @return ondo badago true itzuliko du, bestela false
	 */
	public static boolean balidatuMota(String mota) {
		boolean balidatuta = false;
		if (mota.matches("janaria") || mota.matches("edaria") || mota.matches("sexshop")
				|| mota.matches("erretzaile")) {
			balidatuta = true;
			return balidatuta;
		} else {
			System.out.println(ANSI_RED+"Txarto dago"+ANSI_RESET);
			return balidatuta;
		}
	}
	
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