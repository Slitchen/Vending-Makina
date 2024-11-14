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

		Metodoak.setPrezioBez(datuak, txtPrezio, prezio1, prezio2, prezio2);

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

				diruaFalta = Metodoak.erosketaEginAhalDa(prezioa, ordainketa);

				if (diruaFalta == false) {
					itzulerak = Metodoak.itzulerak(prezioa, ordainketa);
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
}