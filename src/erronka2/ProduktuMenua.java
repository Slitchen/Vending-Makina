package erronka2;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class ProduktuMenua {

	public JFrame frame;
	private JPanel panelEdaria;
	private JPanel panelA;
	private JLabel lblIzenburua;
	private JPanel panelB;
	private JButton btnEdaria;
	private JPanel panelJanaria;
	private JButton btnJanaria;
	private JPanel panelSexshop;
	private JButton btnSex;
	private JPanel panelErretzaile;
	private JButton btnErretzaile;
	private JButton btnAtzera;
	private ImageIcon imageIcon1;
	private ImageIcon imageIcon2;
	private ImageIcon imageIcon3;
	private ImageIcon imageIcon4;
	String mota = "";

	public ProduktuMenua(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String [][]datuak) {
		produktuMenua(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, datuak);
	}

	private void produktuMenua(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String [][]datuak) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(SystemColor.controlLtHighlight);
		frame.getContentPane().setLayout(null);

		panelA = new JPanel();
		panelA.setBounds(0, 0, 859, 113);
		panelA.setBackground(SystemColor.controlLtHighlight);
		frame.getContentPane().add(panelA);
		panelA.setLayout(null);

		lblIzenburua = new JLabel("Produktu Menua");
		lblIzenburua.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenburua.setFont(new Font("Colonna MT", Font.PLAIN, 46));
		lblIzenburua.setBounds(256, 11, 350, 91);
		panelA.add(lblIzenburua);

		panelB = new JPanel();
		panelB.setLayout(null);
		panelB.setBackground(SystemColor.controlLtHighlight);
		panelB.setBounds(0, 113, 859, 488);
		frame.getContentPane().add(panelB);

		panelEdaria = new JPanel();
		panelEdaria.setLayout(null);
		panelEdaria.setBackground(SystemColor.controlLtHighlight);
		panelEdaria.setBounds(25, 108, 187, 280);
		panelB.add(panelEdaria);

		btnEdaria = new JButton("");
		btnEdaria.setBackground(SystemColor.controlLtHighlight);
		btnEdaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mota = "edaria";
				setMota(mota);
				Katalogo katalogo = new Katalogo(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				katalogo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnEdaria.setBounds(0, 0, 187, 280);
		panelEdaria.add(btnEdaria);

		panelJanaria = new JPanel();
		panelJanaria.setLayout(null);
		panelJanaria.setBackground(SystemColor.controlLtHighlight);
		panelJanaria.setBounds(232, 108, 187, 280);
		panelB.add(panelJanaria);

		btnJanaria = new JButton("");
		btnJanaria.setBackground(SystemColor.controlLtHighlight);
		btnJanaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mota = "janaria";
				setMota(mota);
				Katalogo katalogo = new Katalogo(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				katalogo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnJanaria.setBounds(0, 0, 187, 280);
		panelJanaria.add(btnJanaria);

		panelSexshop = new JPanel();
		panelSexshop.setLayout(null);
		panelSexshop.setBackground(SystemColor.controlLtHighlight);
		panelSexshop.setBounds(439, 108, 187, 280);
		panelB.add(panelSexshop);

		btnSex = new JButton("");
		btnSex.setBackground(SystemColor.controlLtHighlight);
		btnSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mota = "sexshop";
				setMota(mota);
				Katalogo katalogo = new Katalogo(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				katalogo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnSex.setBounds(0, 0, 187, 280);
		panelSexshop.add(btnSex);

		panelErretzaile = new JPanel();
		panelErretzaile.setLayout(null);
		panelErretzaile.setBackground(SystemColor.controlLtHighlight);
		panelErretzaile.setBounds(644, 108, 187, 280);
		panelB.add(panelErretzaile);

		btnErretzaile = new JButton("");
		btnErretzaile.setBackground(SystemColor.controlLtHighlight);
		btnErretzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mota = "erretzaile";
				setMota(mota);
				Katalogo katalogo = new Katalogo(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				katalogo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnErretzaile.setBounds(0, 0, 187, 280);
		panelErretzaile.add(btnErretzaile);

		btnAtzera = new JButton("<-");
		btnAtzera.setForeground(new Color(255, 0, 0));
		btnAtzera.setBackground(new Color(255, 69, 0));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OngiEtorri ongiEtorri = new OngiEtorri();
				ongiEtorri.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 45, 23);
		panelA.add(btnAtzera);

		imageIcon1 = new ImageIcon(this.getClass().getResource("/torolocoOpalo.jpg"));
		Image image1 = imageIcon1.getImage().getScaledInstance(btnEdaria.getWidth(), btnEdaria.getHeight(),
				Image.SCALE_SMOOTH);
		imageIcon1.setImage(image1);
		btnEdaria.setIcon(imageIcon1);

		imageIcon2 = new ImageIcon(this.getClass().getResource("/chocoBoombl.jpg"));
		Image image2 = imageIcon2.getImage().getScaledInstance(btnJanaria.getWidth(), btnJanaria.getHeight(),
				Image.SCALE_SMOOTH);
		imageIcon2.setImage(image2);
		btnJanaria.setIcon(imageIcon2);

		imageIcon3 = new ImageIcon(this.getClass().getResource("/fumarMata.jpg"));
		Image image3 = imageIcon3.getImage().getScaledInstance(btnErretzaile.getWidth(), btnErretzaile.getHeight(),
				Image.SCALE_SMOOTH);
		imageIcon3.setImage(image3);
		btnErretzaile.setIcon(imageIcon3);

		imageIcon4 = new ImageIcon(this.getClass().getResource("/condonesDurex1.jpg"));
		Image image4 = imageIcon4.getImage().getScaledInstance(btnSex.getWidth(), btnSex.getHeight(),
				Image.SCALE_SMOOTH);
		imageIcon4.setImage(image4);
		btnSex.setIcon(imageIcon4);

	}

	public static String setMota(String mota) {
		return mota;
	}

}
