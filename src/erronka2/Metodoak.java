package erronka2;

import java.util.Scanner;

import javax.swing.JFrame;

public class Metodoak {
	public static int aukera = 0;
	public static String saukera = "", kode1 = "", baiEz = "";
	public static boolean error = true, gora = true, encontrado = false, baiEZ = false, balidatuta = false;
	public static String mota = "", izena = "", kodea = "", sPrezioa = "", argazkia = "";
	public static double prezioa = 0;

	public static void produktuakGehitu(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop) {

		if (produktuKop == 30) {// gehitzeko aukera blokeatzeko arraya betezen bada
			System.out.println("ezin da gehitu produktu gehiago");
			return;
		}

		System.out.println("|Gehitu Menua|");
		do {
			System.out.println("Ipini produktuen mota: ");
			mota = sc.nextLine();
			balidatuta = Balidazioak.balidatuMota(mota);
			balidatuta = Balidazioak.balidatuKant(mota, motak);
		} while (balidatuta == false);
		do {
			System.out.println("Ipini produktuen izena: ");
			izena = sc.nextLine();
			balidatuta = Balidazioak.balidatuIzena(izena);
		} while (balidatuta == false);
		do {
			System.out.println("Ipini produktuen kodea: ");
			kodea = sc.nextLine();
			balidatuta = Balidazioak.balidatuKodeaDesberdina(kodea, produktuKop, kodeak);
		} while (balidatuta == false);
		do {
			do {
				System.out.println("Ipini produktuen prezioa: ");
				sPrezioa = sc.nextLine();
				balidatuta = Balidazioak.balidatuPrezioa(sPrezioa);
			} while (balidatuta == false);
			prezioa = Double.parseDouble(sPrezioa);

			if (prezioa < 0) {
				System.out.println("ezin duzu prezio negatiboa sartu");
			}
		} while (prezioa < 0);
		do {
			System.out.println("Ipini produktuen argazki izena: ");
			argazkia = sc.nextLine();
		} while (balidatuta == false);
		motak[produktuKop] = mota;
		izenak[produktuKop] = izena;
		kodeak[produktuKop] = kodea;
		prezioak[produktuKop] = prezioa;
		argazkiIzenak[produktuKop] = argazkia;
		// produktuKop++;// Incrementar el contador de productos
		System.out.println("***********************************");
		System.out.println("Produktuak");
		System.out.println("***********************************");
		produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);

	}


	public static void produktuakEzabatu(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop) {
		// Ezabatu produktuak
		System.out.println("|Ezabatu Menua|");
		System.out.println("Ipini produktuen kodigoa: ");
		String kode1 = sc.nextLine();
		// Buscar el producto para eliminar
		encontrado = false;
		for (int i = 0; i < produktuKop; i++) {
			if (kode1.equals(kodeak[i])) {
				// Eliminar el producto
				System.out.println("produktua: ");
				System.out.println(i + 1 + "." + " " + "Mota: " + motak[i] + " " + "Izena: " + izenak[i] + " "
						+ "Kodea: " + kodeak[i] + " " + "Prezioa: " + prezioak[i] + "€" + " " + "Argazki_Izena: "
						+ argazkiIzenak[i]);
				do {
					System.out.println("produktua ezabatu nahi duzu?(Bai/Ez)");
					baiEz = sc.nextLine();
					baiEZ = Balidazioak.balidatutaBaiEz(baiEz);
				} while (baiEZ == false);
				baiEZ = Balidazioak.baiEdoEz(baiEz);
				encontrado = true;
				if (baiEZ == true) {
					// Desplazar los elementos a la izquierda
					for (int j = i; j < produktuKop + 1; j++) {
						motak[j] = motak[j + 1]; // Mueve el siguiente tipo de producto al lugar actual
						izenak[j] = izenak[j + 1]; // Mueve el siguiente nombre de producto
						kodeak[j] = kodeak[j + 1]; // Mueve el siguiente código de producto
						prezioak[j] = prezioak[j + 1]; // Mueve el siguiente precio
						argazkiIzenak[j] = argazkiIzenak[j + 1]; // Mueve el siguiente nombre de imagen
					}
					motak[produktuKop - 1] = null; // Opcional: limpiar el último elemento
					izenak[produktuKop - 1] = null; // Opcional: limpiar el último elemento
					kodeak[produktuKop - 1] = null; // Opcional: limpiar el último elemento
					prezioak[produktuKop - 1] = 0.0; // Opcional: limpiar el último elemento
					argazkiIzenak[produktuKop - 1] = null; // Opcional: limpiar el último elemento
					// produktuKop--; // Reducir el contador de productos
					System.out.println("Produktu ezabatu da.");
					System.out.println("***********************************");
					System.out.println("Produktuak");
					System.out.println("***********************************");
					produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);
					System.out.println("***********************************");
					break;
				} else {
					break;
				}

			}
		}
		if (!encontrado) {
			System.out.println("Produktu ez da aurkitu.");
			System.out.println("***********************************");
		}
	}

	public static void produktuaModifikatu(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop) {
		System.out.println("Produktuak");
		produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);
		System.out.println("***********************************");
		do {
			System.out.println("produktua aldatzeko aukerarekin jarraitu nahi duzu?(Bai/Ez)");
			baiEz = sc.nextLine();
			baiEZ = Balidazioak.balidatutaBaiEz(baiEz);
		} while (baiEZ == false);
		baiEZ = Balidazioak.baiEdoEz(baiEz);
		if (baiEZ == false) {
			return;
		}
		encontrado = false;
		do {
			do {
				System.out.println("Ipini produktuen kodea: ");
				kode1 = sc.nextLine();
				balidatuta = Balidazioak.balidatuKodea(kode1);
			} while (balidatuta == false);

			for (int i = 0; i < produktuKop; i++) {
				String kodeBila = kodeak[i];
				if (kode1.equals(kodeBila)) {
					encontrado = true;
				}
			}
		} while (encontrado == false);
		// Buscar el producto para eliminar
		for (int i = 0; i < produktuKop; i++) {
			if (kode1.equals(kodeak[i])) {
				// Eliminar el producto

				// Desplazar los elementos a la izquierda
				do {
					do {
						do {
							System.out.println("Zer aldatu nahi duzu?");
							System.out.println("");
							System.out.println("1. mota ");
							System.out.println("2. izena ");
							System.out.println("3. kodea ");
							System.out.println("4. prezioa ");
							System.out.println("5. argazkia ");
							System.out.println("");
							saukera = sc.nextLine();
							Balidazioak.balidazio1(aukera, saukera);
							error = Balidazioak.balidazio1(aukera, saukera);
						} while (error);
						aukera = Integer.parseInt(saukera);
					} while (aukera < 0 || aukera > 5);

					switch (aukera) {
					case 1:
						do {
							System.out.println("Ipini produktuen mota berria: ");
							mota = sc.nextLine();
							balidatuta = Balidazioak.balidatuMota(mota);
						} while (balidatuta == false);
						motak[i] = mota;
						break;
					case 2:
						do {
							System.out.println("Ipini produktuen izen berria: ");
							izena = sc.nextLine();
							balidatuta = Balidazioak.balidatuIzena(izena);
						} while (balidatuta == false);
						izenak[i] = izena;
						break;
					case 3:
						do {
							System.out.println("Ipini produktuen kode berria: ");
							kodea = sc.nextLine();
							balidatuta = Balidazioak.balidatuKodeaDesberdina(kodea, produktuKop, kodeak);
						} while (balidatuta == false);
						kodeak[i] = kodea;
						break;
					case 4:
						do {
							do {
								System.out.println("Ipini produktuaren prezioa berria: ");
								sPrezioa = sc.nextLine();
								balidatuta = Balidazioak.balidatuPrezioa(sPrezioa);
							} while (balidatuta == false);
							prezioa = Double.parseDouble(sPrezioa);
							if (prezioa < 0) {
								System.out.println("ezin duzu prezio negatiboa sartu");
							}
						} while (prezioa < 0);
						prezioak[i] = prezioa;
						break;
					case 5:
						System.out.println("Ipini produktuen argazki izen berria: ");
						argazkiIzenak[i] = sc.nextLine();
						break;
					}
					System.out.println("Produktu aldatu da:");
					System.out.println(i + 1 + "." + " " + "Mota: " + motak[i] + " " + "Izena: " + izenak[i] + " "
							+ "Kodea: " + kodeak[i] + " " + "Prezioa: " + prezioak[i] + "€" + " " + "Argazki_Izena: "
							+ argazkiIzenak[i]);
					do {
						System.out.println("produktua aldatzeko aukerarekin jarraitu nahi duzu?(Bai/Ez)");
						baiEz = sc.nextLine();
						baiEZ = Balidazioak.balidatutaBaiEz(baiEz);
					} while (baiEZ == false);
					baiEZ = Balidazioak.baiEdoEz(baiEz);
				} while (baiEZ == true);
			}
		}
	}

	public static void programarenAmaiera(JFrame frame) {
		System.out.println("Kontsolatik ateratzen....");
		frame.setVisible(true);
		return; // Evita que el flujo continúe ejecutándose
	}

	public static void produktuGuztiakAtera(String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak) {
		System.out.println("***********************************");
		System.out.println("Produktuak guztiak:");
		System.out.println("***********************************");
		for (int i = 0; i < izenak.length; i++) {
			if (izenak[i] != null) {
				System.out.println(i + 1 + "." + " " + "Mota: " + motak[i] + " " + "Izena: " + izenak[i] + " "
						+ "Kodea: " + kodeak[i] + " " + "Prezioa: " + prezioak[i] + "€" + " " + "Argazki_Izena: "
						+ argazkiIzenak[i]);
			}
		}
	}
	
	public static int recorrerArray(String[] izenak, int produktuKop) {
		for (int i = 0; i<izenak.length; i++) {
			if(izenak[i] == null) {
				produktuKop = i;
				break;
			}
		}
		return produktuKop;
	}
}