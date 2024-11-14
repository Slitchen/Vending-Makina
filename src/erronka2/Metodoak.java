package erronka2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Metodoak {

	// Constructor para inicializar variables de instancia
	public Metodoak() {
		// Inicializa las variables si es necesario
	}

	public static void produktuakGehitu(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, int produktuKop) {
		// Variables locales dentro del método
		String mota, izena, kodea, sPrezioa, argazkia;
		double prezioa;
		boolean balidatuta;

		if (produktuKop == 30) { // Bloquear la opción de agregar si el array está lleno
			System.out.println("ezin da gehitu produktu gehiago");
			return;
		}

		System.out.println("|Gehitu Menua|");
		do {
			System.out.println("Ipini produktuen mota: ");
			mota = sc.nextLine();
			balidatuta = Balidazioak.balidatuMota(mota);
			balidatuta = Balidazioak.balidatuKant(mota, motak);
		} while (!balidatuta);

		do {
			System.out.println("Ipini produktuen izena: ");
			izena = sc.nextLine();
			balidatuta = Balidazioak.balidatuIzena(izena);
		} while (!balidatuta);

		do {
			System.out.println("Ipini produktuen kodea: ");
			kodea = sc.nextLine();
			balidatuta = Balidazioak.balidatuKodeaDesberdina(kodea, produktuKop, kodeak);
		} while (!balidatuta);

		do {
			do {
				System.out.println("Ipini produktuen prezioa: ");
				sPrezioa = sc.nextLine();
				balidatuta = Balidazioak.balidatuPrezioa(sPrezioa);
			} while (!balidatuta);
			prezioa = Double.parseDouble(sPrezioa);

			if (prezioa < 0) {
				System.out.println("ezin duzu prezio negatiboa sartu");
			}
		} while (prezioa < 0);

		do {
			System.out.println("Ipini produktuen argazki izena: ");
			argazkia = sc.nextLine();
		} while (!balidatuta);

		// Asignación de los valores a los arrays
		motak[produktuKop] = mota;
		izenak[produktuKop] = izena;
		kodeak[produktuKop] = kodea;
		prezioak[produktuKop] = prezioa;
		argazkiIzenak[produktuKop] = argazkia;

		// Incrementar el número de productos
		produktuKop++;

		System.out.println("***********************************");
		System.out.println("Produktuak");
		System.out.println("***********************************");
		produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);
	}

	public static void produktuakEzabatu(Scanner sc, String[] motak, String[] izenak, String[] kodeak,
			Double[] prezioak, String[] argazkiIzenak, int produktuKop) {
		// Variables dentro del método
		String kode1;
		String baiEz;
		boolean encontrado = false, baiEZ = false;

		System.out.println("|Ezabatu Menua|");
		System.out.println("Ipini produktuen kodigoa: ");
		kode1 = sc.nextLine();

		// Buscar el producto para eliminar
		for (int i = 0; i < produktuKop; i++) {
			if (kode1.equals(kodeak[i])) {
				// Producto encontrado
				System.out.println("produktua: ");
				System.out.println(i + 1 + "." + " " + "Mota: " + motak[i] + " " + "Izena: " + izenak[i] + " "
						+ "Kodea: " + kodeak[i] + " " + "Prezioa: " + prezioak[i] + "€" + " " + "Argazki_Izena: "
						+ argazkiIzenak[i]);

				do {
					System.out.println("produktua ezabatu nahi duzu?(Bai/Ez)");
					baiEz = sc.nextLine();
					baiEZ = Balidazioak.balidatutaBaiEz(baiEz);
				} while (!baiEZ);

				baiEZ = Balidazioak.baiEdoEz(baiEz);
				encontrado = true;
				if (baiEZ) {
					// Desplazar los elementos a la izquierda
					for (int j = i; j < produktuKop - 1; j++) {
						motak[j] = motak[j + 1];
						izenak[j] = izenak[j + 1];
						kodeak[j] = kodeak[j + 1];
						prezioak[j] = prezioak[j + 1];
						argazkiIzenak[j] = argazkiIzenak[j + 1];
					}
					motak[produktuKop - 1] = null;
					izenak[produktuKop - 1] = null;
					kodeak[produktuKop - 1] = null;
					prezioak[produktuKop - 1] = 0.0;
					argazkiIzenak[produktuKop - 1] = null;

					System.out.println("Produktu ezabatu da.");
					System.out.println("***********************************");
					System.out.println("Produktuak");
					System.out.println("***********************************");
					produktuGuztiakAtera(motak, izenak, kodeak, prezioak, argazkiIzenak);
					break;
				}
			}
		}

		if (!encontrado) {
			System.out.println("Produktu ez da aurkitu.");
			System.out.println("***********************************");
		}
	}

	public static void produktuaModifikatu(Scanner sc, String[] motak, String[] izenak, String[] kodeak,
			Double[] prezioak, String[] argazkiIzenak, int produktuKop) {
		// Variables dentro del método

		int aukera = 0;
		String saukera = "", kode1 = "", baiEz = "";
		boolean error = true, encontrado = false, baiEZ = false, balidatuta = false;
		String mota = "", izena = "", kodea = "", sPrezioa = "";
		double prezioa = 0;

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
		// Mostrar todos los productos
		for (int i = 0; i < 30; i++) {
			if (motak[i] != null) {
				System.out.println(i + 1 + "." + " Mota: " + motak[i] + " Izena: " + izenak[i] + " Kodea: " + kodeak[i]
						+ " Prezioa: " + prezioak[i] + "€ Argazki: " + argazkiIzenak[i]);
			}
		}
	}

	public static int recorrerArray(String[] izenak, int produktuKop) {
		for (int i = 0; i < izenak.length; i++) {
			if (izenak[i] == null) {
				produktuKop = i;
				break;
			}
		}
		return produktuKop;
	}

	public static void cargarImagen(JLabel label, String imagenPath) {
		try {
			// Cargar la imagen usando la clase Ordainketa en lugar de getClass()
			ImageIcon icon = new ImageIcon(Ordainketa.class.getResource(imagenPath)); // Asumiendo que la imagen está en
																						// recursos
			Image img = icon.getImage(); // Obtener la imagen
			Image scaledImg = img.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Escalar la imagen a 45x45 píxeles

			// Asignar la imagen escalada al JLabel
			label.setIcon(new ImageIcon(scaledImg));
		} catch (Exception e) {
			System.out.println("Error al cargar la imagen: " + imagenPath);
			label.setText("Imagen no encontrada");
		}
	}

	public static void setPrezioBez(String datuak[][], JTextField txtPrezio2, double prezio1, double prezio2,
			double totalConIva) {
		String prezio3 = Double.toString(prezioGuztiaBez(datuak, prezio2, prezio1));
		txtPrezio2.setText(prezio3);
	}

	public static void setPrezio(String datuak[][], JTextField txtPrezio, double prezio1, double prezio2) {
		String prezio3 = Double.toString(prezioGuztia(datuak, prezio1, prezio2));
		txtPrezio.setText(prezio3);
	}

	public static Double prezioGuztia(String[][] datuak, double prezio1, double prezio2) {
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][2] != null) { // Verifica que el valor no sea null
				prezio1 = Double.parseDouble(datuak[i][2]);
				prezio2 += prezio1;
			}
		}
		return prezio2;
	}

	public static Double prezioGuztiaBez(String[][] datuak, double prezio2, double prezio1) {
		double preziokalkulo = 0;
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][2] != null) { // Verifica que el valor no sea null
				prezio1 = Double.parseDouble(datuak[i][2]);
				preziokalkulo += prezio1;
			}
			double bez = preziokalkulo * 0.21;
			prezio2 = preziokalkulo + bez;
		}
		return prezio2;
	}

	public static void gehitu(String[][] datuak, JTable tablaProdukt, JFrame frame, JScrollPane scrollPane) {
		DefaultTableModel model = (DefaultTableModel) tablaProdukt.getModel();
		model.setRowCount(0); // Limpiar la tabla

		// Actualizar la tabla con los datos
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][0] != null) { // Verificar que hay datos antes de añadir
				model.addRow(new Object[] { datuak[i][0], datuak[i][1], datuak[i][2] });
			}
		}

		// Refrescar la UI de la tabla
		scrollPane.setViewportView(tablaProdukt);
		((JPanel) frame.getContentPane()).updateUI();
	}

	public static boolean erosketaEginAhalDa(double prezioa, double ordainketa) {
		boolean falta = true;
		double diruFalta = 0;

		if (prezioa <= ordainketa) {
			falta = false;
			return falta;
		} else {
			diruFalta = prezioa - ordainketa;
			JOptionPane.showMessageDialog(null, diruFalta + "€ falta zaizu");
			return falta;
		}

	}

	public static String itzulerak(double prezioa, double ordainketa) {

		String itzulerak = "";
		double batZent = 0, biZent = 0, bostZent = 0, hamarZent = 0, hogeiZent = 0, berrogeitaHamarZent = 0, batE = 0,
				biE = 0, bostE = 0, hamarE = 0, hogeiE = 0, berrogeitaHamarE = 0, ehunE = 0, berrehunE = 0;
		prezioa = ordainketa - prezioa;
		while (prezioa >= 200) {
			prezioa = prezioa - 200;
			berrehunE++;
		}
		while (prezioa >= 100) {
			prezioa = prezioa - 100;
			ehunE++;
		}
		while (prezioa >= 50) {

			prezioa = prezioa - 50;
			berrogeitaHamarE++;
		}
		while (prezioa >= 20) {
			prezioa = prezioa - 20;
			hogeiE++;
		}
		while (prezioa >= 10) {
			prezioa = prezioa - 10;
			hamarE++;
		}
		while (prezioa >= 5) {
			prezioa = prezioa - 5;
			bostE++;
		}
		while (prezioa >= 2) {
			prezioa = prezioa - 2;
			biE++;
		}
		while (prezioa >= 2) {
			prezioa = prezioa - 2;
			biE++;
		}
		while (prezioa >= 1) {
			prezioa = prezioa - 1;
			batE++;
		}
		while (prezioa >= 0.5) {
			prezioa = prezioa - 0.5;
			berrogeitaHamarZent++;
		}
		while (prezioa >= 0.2) {
			prezioa = prezioa - 0.2;
			hogeiZent++;
		}
		while (prezioa >= 0.1) {
			prezioa = prezioa - 0.1;
			hamarZent++;
		}
		while (prezioa >= 0.05) {
			prezioa = prezioa - 0.05;
			bostZent++;
		}
		while (prezioa >= 0.02) {

			prezioa = prezioa - 0.02;
			biZent++;
		}
		while (prezioa >= 0.01) {
			prezioa = prezioa - 0.01;
			batZent++;
		}
		itzulerak = itzulerakTestua(berrehunE, ehunE, berrogeitaHamarE, hogeiE, hamarE, bostE, biE, batE,
				berrogeitaHamarZent, hogeiZent, hamarZent, bostZent, biZent, batZent);
		return itzulerak;

	}

	public static String itzulerakTestua(double berrehunE, double ehunE, double berrogeitaHamarE, double hogeiE,
			double hamarE, double bostE, double biE, double batE, double berrogeitaHamarZent, double hogeiZent,
			double hamarZent, double bostZent, double biZent, double batZent) {
		String itzulerak = "";
		int kant = 0;
		if (berrehunE > 0) {
			kant = (int) berrehunE;
			itzulerak = itzulerak + " 200€-ko " + kant + " billete ";
		}
		if (ehunE > 0) {
			kant = (int) ehunE;
			itzulerak = itzulerak + " 100€-ko " + kant + " billete ";
		}
		if (berrogeitaHamarE > 0) {
			kant = (int) berrogeitaHamarE;
			itzulerak = itzulerak + " 50€-ko " + kant + " billete ";
		}
		if (hogeiE > 0) {
			kant = (int) hogeiE;
			itzulerak = itzulerak + " 20€-ko " + kant + " billete ";
		}
		if (hamarE > 0) {
			kant = (int) hamarE;
			itzulerak = itzulerak + " 10€-ko " + kant + " billete ";
		}
		if (bostE > 0) {
			kant = (int) bostE;
			itzulerak = itzulerak + " 5€-ko " + kant + " billete ";
		}
		if (biE > 0) {
			kant = (int) biE;
			itzulerak = itzulerak + " 2€-ko " + kant + " txanpon ";
		}
		if (batE > 0) {
			kant = (int) batE;
			itzulerak = itzulerak + " 1€-ko " + kant + " txanpon ";
		}
		if (berrogeitaHamarZent > 0) {
			kant = (int) berrogeitaHamarZent;
			itzulerak = itzulerak + " 50 zentimoko " + kant + " txanpon ";
		}
		if (hogeiZent > 0) {
			kant = (int) hogeiZent;
			itzulerak = itzulerak + " 20 zentimoko " + kant + " txanpon ";
		}
		if (hamarZent > 0) {
			kant = (int) hamarZent;
			itzulerak = itzulerak + " 10 zentimoko " + kant + " txanpon ";
		}
		if (bostZent > 0) {
			kant = (int) bostZent;
			itzulerak = itzulerak + " 5 zentimoko " + kant + " txanpon ";
		}
		if (biZent > 0) {
			kant = (int) biZent;
			itzulerak = itzulerak + " 2 zentimoko " + kant + " txanpon ";
		}
		if (batZent > 0) {
			kant = (int) batZent;
			itzulerak = itzulerak + " 1 zentimoko " + kant + " txanpon ";
		}

		return itzulerak;

	}

	public static String setMota(String mota) {
		return mota;
	}

	public static String setPrezio(String prezio) {
		return prezio;
	}

	public static String setProduktu(String izenak1) {
		return izenak1;
	}

	public static void botoiak(JTextField textselecnum, JTextField txtPrezio, JPanel panelc, JButton btn0, JButton btn1,
			JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6, JButton btn7, JButton btn8,
			JButton btn9, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak, String[] argazkiIzenak,
			String mota2) {

		int labelIndex = 1; // Empezamos desde el producto 1
		for (int i = 0; i < izenak.length; i++) {
			if (motak[i] != null && motak[i].equals(mota2) && prezioak[i] != null) {
				String prezio = Double.toString(prezioak[i]) + "€"; // Convertir el precio a cadena

				// Aquí asignamos el comportamiento de los botones
				switch (labelIndex) {
				case 1:
					btn1 = new JButton("1");
					btn1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("1"); // Mostrar el número del producto
							txtPrezio.setText(prezio);
						}
					});
					btn1.setBounds(32, 227, 63, 38);
					panelc.add(btn1);
					break;
				case 2:
					btn2 = new JButton("2");
					btn2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("2");
							txtPrezio.setText(prezio);
						}
					});
					btn2.setBounds(100, 227, 63, 38);
					panelc.add(btn2);
					break;
				case 3:
					btn3 = new JButton("3");
					btn3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("3");
							txtPrezio.setText(prezio);
						}
					});
					btn3.setBounds(166, 227, 63, 38);
					panelc.add(btn3);
					break;
				case 4:
					btn4 = new JButton("4");
					btn4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("4");
							txtPrezio.setText(prezio);
						}
					});
					btn4.setBounds(32, 184, 63, 38);
					panelc.add(btn4);
					break;
				case 5:
					btn5 = new JButton("5");
					btn5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							;
							textselecnum.setText("5");
							txtPrezio.setText(prezio);
						}

					});
					btn5.setBounds(100, 184, 63, 38);
					panelc.add(btn5);
					break;
				case 6:
					btn6 = new JButton("6");
					btn6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("6");
							txtPrezio.setText(prezio);
						}

					});
					btn6.setBounds(166, 184, 63, 38);
					panelc.add(btn6);
					break;
				case 7:
					btn7 = new JButton("7");
					btn7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("7");
							txtPrezio.setText(prezio);
						}

					});
					btn7.setBounds(32, 143, 63, 38);
					panelc.add(btn7);
					break;
				case 8:
					btn8 = new JButton("8");
					btn8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("8");
							txtPrezio.setText(prezio);
						}

					});
					btn8.setBounds(100, 143, 63, 38);
					panelc.add(btn8);
					break;
				case 9:
					btn9 = new JButton("9");
					btn9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textselecnum.setText("9");
							txtPrezio.setText(prezio);
						}

					});
					btn9.setBounds(166, 143, 63, 38);
					panelc.add(btn9);
					break;
				default:
					txtPrezio.setText("no product");
					break;
				}
				labelIndex++; // Pasar al siguiente JLabel
				setPrezio(prezio);
				if (labelIndex > 9)
					break;
			}
		}
	}

	public static void argazkiak(JLabel lblP1, JLabel lblP2, JLabel lblP3, JLabel lblP4, JLabel lblP5, JLabel lblP6,
			JLabel lblP7, JLabel lblP8, JLabel lblP9, String[] motak, String[] izenak, String[] kodeak,
			Double[] prezioak, String[] argazkiIzenak, String mota2) {
		int labelIndex = 1; // Iniciamos con lblP1

// Iterar sobre todos los productos y buscar los de tipo "edaria"
		for (int i = 0; i < izenak.length; i++) {
// Verificar si el producto es de tipo "edaria" y tiene una imagen
			if (izenak[i] != null && motak[i] != null && motak[i].equals(mota2) && argazkiIzenak[i] != null) {
// Cargar y escalar la imagen
				ImageIcon imageIcon = new ImageIcon(ProduktuMenua.class.getResource(argazkiIzenak[i]));
				Image image = imageIcon.getImage().getScaledInstance(lblP1.getWidth(), lblP1.getHeight(),
						Image.SCALE_SMOOTH);
				imageIcon.setImage(image);

// Asignar la imagen al JLabel correspondiente según el labelIndex
				switch (labelIndex) {
				case 1:
					lblP1.setIcon(imageIcon);
					lblP1.setText(null);
					break;
				case 2:
					lblP2.setIcon(imageIcon);
					lblP2.setText(null);
					break;
				case 3:
					lblP3.setIcon(imageIcon);
					lblP3.setText(null);
					break;
				case 4:
					lblP4.setIcon(imageIcon);
					lblP4.setText(null);
					break;
				case 5:
					lblP5.setIcon(imageIcon);
					lblP5.setText(null);
					break;
				case 6:
					lblP6.setIcon(imageIcon);
					lblP6.setText(null);
					break;
				case 7:
					lblP7.setIcon(imageIcon);
					lblP7.setText(null);
					break;
				case 8:
					lblP8.setIcon(imageIcon);
					lblP8.setText(null);
					break;
				case 9:
					lblP9.setIcon(imageIcon);
					lblP9.setText(null);
					break;
				}

				labelIndex++; // Pasar al siguiente JLabel

// Si hemos asignado imágenes a los cuatro JLabel, salir del bucle
				if (labelIndex > 9)
					break;
			}
		}

	}

	public static void labelak(JPanel panelb, JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4, JLabel lbl5,
			JLabel lbl6, JLabel lbl7, JLabel lbl8, JLabel lbl9, String[] motak, String[] izenak, String[] kodeak,
			Double[] prezioak, String[] argazkiIzenak, String mota2) {
		int labelIndex = 1;

		for (int i = 0; i < izenak.length; i++) {
			if (izenak[i] != null && motak[i] != null && motak[i].equals(mota2)) {
				switch (labelIndex) {
				case 1:
					lbl1 = new JLabel(izenak[i]);
					lbl1.setHorizontalAlignment(SwingConstants.CENTER);
					lbl1.setBounds(56, 441, 112, 14);
					panelb.add(lbl1);
					break;
				case 2:
					lbl2 = new JLabel(izenak[i]);
					lbl2.setHorizontalAlignment(SwingConstants.CENTER);
					lbl2.setBounds(217, 441, 112, 14);
					panelb.add(lbl2);
					;
					break;
				case 3:
					lbl3 = new JLabel(izenak[i]);
					lbl3.setHorizontalAlignment(SwingConstants.CENTER);
					lbl3.setBounds(382, 441, 112, 14);
					panelb.add(lbl3);
					break;
				case 4:
					lbl4 = new JLabel(izenak[i]);
					lbl4.setHorizontalAlignment(SwingConstants.CENTER);
					lbl4.setBounds(56, 286, 112, 14);
					panelb.add(lbl4);
					break;
				case 5:
					lbl5 = new JLabel(izenak[i]);
					lbl5.setHorizontalAlignment(SwingConstants.CENTER);
					lbl5.setBounds(217, 286, 112, 14);
					panelb.add(lbl5);
					break;
				case 6:
					lbl6 = new JLabel(izenak[i]);
					lbl6.setHorizontalAlignment(SwingConstants.CENTER);
					lbl6.setBounds(382, 286, 112, 14);
					panelb.add(lbl6);
					break;
				case 7:
					lbl7 = new JLabel(izenak[i]);
					lbl7.setHorizontalAlignment(SwingConstants.CENTER);
					lbl7.setBounds(57, 136, 112, 14);
					panelb.add(lbl7);
					break;
				case 8:
					lbl8 = new JLabel(izenak[i]);
					lbl8.setHorizontalAlignment(SwingConstants.CENTER);
					lbl8.setBounds(218, 136, 112, 14);
					panelb.add(lbl8);
					break;
				case 9:
					lbl9 = new JLabel(izenak[i]);
					lbl9.setHorizontalAlignment(SwingConstants.CENTER);
					lbl9.setBounds(383, 136, 112, 14);
					panelb.add(lbl9);
					break;
				}

				labelIndex++; // Pasar al siguiente JLabel
				if (labelIndex > 9)
					break;
			}
		}
	}
	
	public static void botoiIntro(JPanel panelc, JButton btnIntro, String[] motak, String[] izenak, String[] kodeak,
			Double[] prezioak, String[] argazkiIzenak, JTextField textselecnum, String mota2, String[][] datuak,
			String izenak1, String argazkiak1) {
		String selekzioa = textselecnum.getText();
		int kont2 = -1; // Este índice representa la primera posición libre en datuak
		Double prezio = null;
		boolean aipatuta = false;

		try {
			int seleccionNum = Integer.parseInt(selekzioa);
			if (seleccionNum >= 1 && seleccionNum <= 9) {
				int kont = 0;

				for (int i = 0; i < izenak.length; i++) {
					if (motak[i] != null && motak[i].equals(mota2)) {
						kont++;

						if (kont == seleccionNum) {
							prezio = prezioak[i];
							izenak1 = izenak[i];
							argazkiak1 = argazkiIzenak[i];

							// Buscamos si el producto ya está en el array datuak
							for (int j = 0; j < datuak.length; j++) {
								if (datuak[j][0] != null && datuak[j][0].equals(izenak1)) {
									// Actualizar la cantidad si el producto ya está en el array
									int oraingoKantitatea = Integer.parseInt(datuak[j][1]);
									datuak[j][1] = Integer.toString(++oraingoKantitatea);

									// Actualizar el precio calculado
									Double prezioKalkulatuta = prezio * oraingoKantitatea;
									datuak[j][2] = prezioKalkulatuta.toString(); // Guardar como Double en formato texto
									aipatuta = true; // Producto ya encontrado, se actualiza
									break;
								} else if (datuak[j][0] == null && kont2 == -1) {
									// Guardamos la primera posición libre en datuak
									kont2 = j;
								}
							}

							// Si el producto no está en el array, añadirlo en la primera posición libre
							if (!aipatuta && kont2 != -1) {

								datuak[kont2][0] = izenak1; // Asigna el nombre del producto
								datuak[kont2][1] = "1"; // Inicializar la cantidad a 1
								datuak[kont2][2] = prezio.toString(); // Guardar el precio inicial como texto
								datuak[kont2][3] = argazkiak1;
							}
							break;
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("El valor introducido no es un número válido");
		}
	}

	public static void hasieratuArray(String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String[][] datuak, boolean arrayHasieratuak) {
		if (!arrayHasieratuak) {
			motak = KudeatuArray.hasieratuMotak(motak);
			izenak = KudeatuArray.hasieratuIzenak(izenak);
			kodeak = KudeatuArray.hasieratuKodeak(kodeak);
			prezioak = KudeatuArray.hasieratuPrezioak(prezioak);
			argazkiIzenak = KudeatuArray.hasieratuArgazkiIzenak(argazkiIzenak);
			arrayHasieratuak = MenuAdmin.arrayHasieratuak(arrayHasieratuak);
			System.out.println("Arrayak Hasieratua");
		}
	}
}