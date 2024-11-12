
package erronka2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class OngiEtorri {
	public JFrame frame;
	private JButton btnAdmin;
	private JButton btnOngiEtorri;
	// Moten arrayak sortuko ditugu main-ean beste klasetan erabiltzeko
	private String[] motak = new String[30];
	private String[] izenak = new String[30];
	private String[] kodeak = new String[30];
	private Double [] prezioak = new Double[30]; 
	private String[] argazkiIzenak = new String[30];
	private String[][] datuak = new String[9][4];
	private int produktuKop = 11;
	private boolean arrayHasieratuak = false; 
	Scanner sc = new Scanner(System.in);

	public static void hasieratuArray(String[] motak, String[] izenak, String[] kodeak,  Double [] prezioak, String[] argazkiIzenak, String[][] datuak, boolean arrayHasieratuak) {
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OngiEtorri window = new OngiEtorri();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OngiEtorri() {
		OngiEtorria();
	}

	
	private void OngiEtorria() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 640);
		frame.setBackground(SystemColor.controlLtHighlight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		hasieratuArray(motak, izenak, kodeak, prezioak, argazkiIzenak, datuak, arrayHasieratuak);
		
		btnOngiEtorri = new JButton("ONGI ETORRI");
		btnOngiEtorri.setFont(new Font("Leelawadee", Font.BOLD, 28));
		btnOngiEtorri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProduktuMenua produktuMenua = new ProduktuMenua(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, datuak);
				produktuMenua.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnOngiEtorri.setBounds(146, 88, 591, 414);
		frame.getContentPane().add(btnOngiEtorri);

		btnAdmin = new JButton("");
		btnAdmin.setBackground(frame.getContentPane().getBackground());
		btnAdmin.setBorderPainted(false);
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setOpaque(false);
		btnAdmin.setFont(new Font("Sitka Small", Font.PLAIN, 5));
		btnAdmin.setBounds(0, 0, 33, 23);
		frame.getContentPane().add(btnAdmin);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminKontsola admin = new AdminKontsola();
				admin.Gakoa(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, produktuKop, arrayHasieratuak, frame);
			}
		});
	}
}