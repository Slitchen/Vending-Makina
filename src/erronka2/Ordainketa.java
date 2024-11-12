package erronka2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Ordainketa {

	public JFrame frame;
	private JButton btnAtzera;
	private JPanel panel;
	private JTextField txtPrezio;
	private JLabel lblGuztira;
	private JButton btnOrdaindu;
	private JTextField txtOrdaindu;
	private JButton btnAtera;
	private JLabel lblDirua;
	private JLabel lblEskerrik;
	private JPanel panel2;
	private JLabel lblIzenburua;

	public Ordainketa(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String mota, String[][] datuak, String prezio, double prezio1, double prezio2) {
		ordainketa(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak, prezio, prezio1, prezio2);
		frame.setVisible(true); // Hacer visible el JFrame
	}

	private void ordainketa(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String mota, String[][] datuak, String prezio, double prezio1, double prezio2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(0, 0, 859, 601);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel2 = new JPanel();
		lblEskerrik = new JLabel("Eskerrik Asko!");
		lblEskerrik.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrik.setFont(new Font("Tahoma", Font.PLAIN, 66));
		panel2.add(lblEskerrik);

		lblIzenburua = new JLabel("Ordainketa");
		lblIzenburua.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenburua.setFont(new Font("Colonna MT", Font.PLAIN, 46));
		lblIzenburua.setBounds(256, 11, 350, 91);
		panel.add(lblIzenburua);

		btnAtzera = new JButton("<-");
		btnAtzera.setForeground(new Color(255, 0, 0));
		btnAtzera.setBackground(new Color(255, 69, 0));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laburpena laburpena = new Laburpena(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				laburpena.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 45, 23);
		panel.add(btnAtzera);

		txtPrezio = new JTextField();
		txtPrezio.setBackground(SystemColor.controlLtHighlight);
		txtPrezio.setEditable(false);
		txtPrezio.setBounds(378, 159, 165, 50);
		panel.add(txtPrezio);
		txtPrezio.setColumns(10);

		setPrezio(datuak, txtPrezio, prezio1, prezio2);

		lblGuztira = new JLabel("Prezio guztira");
		lblGuztira.setBounds(296, 177, 72, 14);
		panel.add(lblGuztira);

		txtOrdaindu = new JTextField();
		txtOrdaindu.setBounds(378, 220, 45, 20);
		panel.add(txtOrdaindu);
		txtOrdaindu.setColumns(10);

		btnAtera = new JButton("->");
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnAtzera.setVisible(false);
				txtPrezio.setVisible(false);
				lblGuztira.setVisible(false);
				lblIzenburua.setVisible(false);
				txtOrdaindu.setVisible(false);
				btnOrdaindu.setVisible(false);
				btnAtera.setVisible(false);
				lblDirua.setVisible(false);

				panel2.setBounds(0, 0, 859, 601);
				panel.add(panel2);
				panel2.setLayout(null);
				lblEskerrik.setBounds(0, 0, 859, 601);
				// Actualizar la interfaz para mostrar panel2
				panel.revalidate();
				panel.repaint();
				Timer timer = new Timer(10000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						// Ejecutar después de la espera
						OngiEtorri ongiEtorri = new OngiEtorri();
						ongiEtorri.frame.setVisible(true);
						frame.dispose();
					}
				});
				timer.setRepeats(false); // Asegurarse de que el timer se ejecute solo una vez
				timer.start(); // Iniciar el timer
			}
		});
		btnAtera.setBounds(760, 567, 89, 23);
		panel.add(btnAtera);

		btnOrdaindu = new JButton("Ordaindu");
		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sPrezioa = txtPrezio.getText();
				String sOrdainketa = txtOrdaindu.getText();
				double prezioa = Double.parseDouble(sPrezioa);
				boolean balidatuta = false;
				double ordainketa = 0;
				boolean diruaFalta = false;
				String itzulerak = "";

				balidatuta = Balidazioak.balidatuOrdainketa(sOrdainketa);
				if (balidatuta == true) {
					ordainketa = Double.parseDouble(sOrdainketa);
				}

				diruaFalta = erosketaEginAhalDa(prezioa, ordainketa);

				if (diruaFalta == false) {
					itzulerak = itzulerak(prezioa, ordainketa);
					JOptionPane.showMessageDialog(null, itzulerak);
					txtOrdaindu.setText("");
				}
			}
		});
		btnOrdaindu.setBounds(412, 251, 89, 23);
		panel.add(btnOrdaindu);

		lblDirua = new JLabel("Dirua Ipini");
		lblDirua.setBounds(296, 223, 72, 14);
		panel.add(lblDirua);
	}

	public static void setPrezio(String datuak[][], JTextField txtPrezio, double prezio1, double prezio2) {
		String prezio3 = Double.toString(Laburpena.prezioGuztiaBez(datuak, prezio1, prezio2));
		txtPrezio.setText(prezio3);
	}

	public boolean erosketaEginAhalDa(double prezioa, double ordainketa) {
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
}