package erronka2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.SwingConstants;

public class Laburpena {
	public JFrame frame;
	private JButton btnAtzera;
	private JPanel panel;
	private JButton btnAurrera;
	private JLabel lblIzenburua;

	public Laburpena(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String mota, String[][] datuak) {
		laburpena(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
		frame.setVisible(true); // hace que el JFrame de esta pagina sea visible
	}

	private void laburpena(Scanner sc, String[] motak, String[] izenak, String[] kodeak, Double[] prezioak,
			String[] argazkiIzenak, String mota, String[][] datuak) {
		double prezio1 = 0;
		double prezio2 = 0;

		frame = new JFrame();
		frame.setBounds(100, 100, 875, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(SystemColor.controlLtHighlight);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 859, 601);
		panel.setBackground(SystemColor.controlLtHighlight);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		/*
		scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 98, 383, 187);
		panel.add(scrollPane);

		tablaProdukt = new JTable();
		scrollPane.setViewportView(tablaProdukt);
		tablaProdukt.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, },
				new String[] { "Izena", "Kantitatea", "Prezioa" }));
		 */
		btnAurrera = new JButton("->");
		btnAurrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordainketa ordainketa = new Ordainketa(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak,
						mota, prezio1, prezio2);
				ordainketa.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAurrera.setBounds(760, 11, 89, 23);
		panel.add(btnAurrera);

		btnAtzera = new JButton("<-");
		btnAtzera.setForeground(new Color(255, 0, 0));
		btnAtzera.setBackground(new Color(255, 69, 0));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Katalogo katalogo = new Katalogo(sc, motak, izenak, kodeak, prezioak, argazkiIzenak, mota, datuak);
				katalogo.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 45, 23);
		panel.add(btnAtzera);
		
		lblIzenburua = new JLabel("Erosketa Orga");
		lblIzenburua.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenburua.setFont(new Font("Colonna MT", Font.PLAIN, 46));
		lblIzenburua.setEnabled(false);
		lblIzenburua.setBounds(256, 11, 350, 91);
		panel.add(lblIzenburua);
		
		/*
// Llenar la tabla con datos
		DefaultTableModel model = (DefaultTableModel) tablaProdukt.getModel();
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][0] != null) { // Verificar que hay datos antes de añadir
				model.setValueAt(datuak[i][0], i, 0);
				model.setValueAt(datuak[i][1], i, 1);
				model.setValueAt(datuak[i][2], i, 2);
			}
		}

		gehitu(datuak, tablaProdukt, frame, scrollPane);
	*/
// Colocar las imágenes seleccionadas en los JLabel correspondientes
// Recorremos el array `datuak` para colocar las imágenes que han sido seleccionadas
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][3] != null) { // Verificamos si hay una imagen seleccionada
				String argazkiak1 = datuak[i][3]; // Recuperamos la imagen seleccionada
				String izenak1 = datuak[i][0];
				String kantitatea = datuak[i][1];
				String prezioa = datuak[i][2];

// Crear un JPanel para cada producto
				JPanel productoPanel = new JPanel();
				productoPanel.setBounds(10, 85 + (i * 56), 350, 45); // Ajustar la posición del panel
				productoPanel.setBackground(SystemColor.controlLtHighlight);
				productoPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Usamos FlowLayout para alinear todo a la
																			// izquierda
				panel.add(productoPanel);

// Crear y añadir la imagen al JPanel
				JLabel lblImg = new JLabel();
				lblImg.setBackground(SystemColor.controlLtHighlight);
				cargarImagen(lblImg, argazkiak1); // Cargar la imagen al JLabel
				productoPanel.add(lblImg);

// Crear y añadir el nombre del producto al JPanel
				JLabel lblNombre = new JLabel(izenak1);
				lblNombre.setBackground(SystemColor.controlLtHighlight);
				productoPanel.add(lblNombre);

// Crear y añadir la cantidad al JPanel
				JLabel lblCantidad = new JLabel("Kantitatea: " + kantitatea);
				lblCantidad.setBackground(SystemColor.controlLtHighlight);
				productoPanel.add(lblCantidad);

// Crear y añadir el precio al JPanel
				JLabel lblPrecio = new JLabel("Prezioa: " + prezioa + " €");
				lblPrecio.setBackground(SystemColor.controlLtHighlight);
				productoPanel.add(lblPrecio);
			}
		}
	}

//Método para cargar la imagen en el JLabel y ajustarla al tamaño del JLabel
	private void cargarImagen(JLabel label, String imagenPath) {
		try {
// Cargar la imagen
			ImageIcon icon = new ImageIcon(getClass().getResource(imagenPath)); // Asumiendo que la imagen está en
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

	public static Double prezioGuztia(String[][] datuak, double prezio1, double prezio2) {
		for (int i = 0; i < datuak.length; i++) {
			if (datuak[i][2] != null) { // Verifica que el valor no sea null
				prezio1 = Double.parseDouble(datuak[i][2]);
				prezio2 += prezio1;
			}
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
}
