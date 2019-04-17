package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPuntuaciones extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JList lista;
	private JLabel titulo;

	public VentanaPuntuaciones() {

		super("El Ahorcado");
		setSize(1200, 1000);
		Image iconoV = new ImageIcon(getClass().getResource("/imagenes/ahorcadobienvenida.png")).getImage();
        setIconImage(iconoV);
		setLayout(null);
		getContentPane().setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		gestionBarra();
		initComponents();
	}

	public void gestionBarra() {
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.setBackground(Color.DARK_GRAY);

		/* Creamos el menú de la barra */
		JMenu inicio = new JMenu("Juego");
		inicio.setForeground(Color.WHITE);
		inicio.setBackground(Color.DARK_GRAY);
		barra.add(inicio);// para colocarlo dentro de la barra

		/* Creamos las opciones del Juego */
		JMenuItem nuevo = new JMenuItem("Nuevo Juego");
		nuevo.setBackground(Color.DARK_GRAY);
		nuevo.setForeground(Color.WHITE);
		nuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if (ev.getSource() == nuevo) {
					/* Visualizamos la ventana "Nuevo Juego" */
					Ahorcado1vs2 p = new Ahorcado1vs2();
					p.setVisible(true);
					dispose();
				}
			}
		});

		JMenuItem exit = new JMenuItem("Salir");
		exit.setBackground(Color.DARK_GRAY);
		exit.setForeground(Color.WHITE);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent salir) {
				if (salir.getSource() == exit)
					System.exit(0);
			}
		});
		JMenuItem creditos = new JMenuItem("Acerca de...");
		creditos.setBackground(Color.DARK_GRAY);
		creditos.setForeground(Color.WHITE);
		creditos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				/* Visualizamos otra ventana al dar "Acerca de" */
				VerCreditos opcion = new VerCreditos();
				// Métodos para visualizar los datos del juego
				opcion.verCreadores();
			    opcion.datosJuego();

			    opcion.setVisible(true);
				dispose();
			}
		});
		// Añadimos las opciones
		inicio.add(nuevo);
		inicio.add(exit);
		inicio.add(creditos);
	}

	private void initComponents() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);

	

		titulo = new JLabel();
		titulo.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/imagenes/ganadores.png")));
		titulo.setSize(400, 400);
		titulo.setLocation(390, 70);
		titulo.setForeground(Color.WHITE);
		titulo.setVisible(true);
		contentPane.add(titulo);

		textArea = new JTextArea(10,2);
		textArea.setText(getName());
		textArea.setText(getTitle());
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(); 
		scroll.setViewportView(textArea);
		textArea.setBounds(313, 358, 500, 200);
		getContentPane().add(textArea);
		contentPane.add(textArea);

		
		this.setVisible(true);

	
		
		File ranking =new File("Puntuaciones.txt");
		
		try {
			BufferedReader lectura = new BufferedReader(new FileReader(ranking));
			String linea=lectura.readLine();
			while(linea !=null) {
				textArea.append(linea+"\n");
				linea=lectura.readLine();
			}
		}catch (Exception ex) {
			Logger.getLogger(VentanaPuntuaciones.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	
		
	
	}
}

