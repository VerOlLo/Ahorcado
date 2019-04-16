package Vista;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaPuntuaciones extends JFrame {

	JFrame bienvenida;
	JPanel pBienvenida;
	JLabel fBienvenida;
	JLabel titulo;
	//JLabel ahorcado;
	JLabel bComenzar;
	
	
	
	public VentanaPuntuaciones() {
		
		super("El Ahorcado");
		setSize(1200, 1000);
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
			
			/*Creamos el menú de la barra*/
			JMenu inicio = new JMenu("Juego");
			inicio.setForeground(Color.WHITE);
			inicio.setBackground(Color.DARK_GRAY);
			barra.add(inicio);//para colocarlo dentro de la barra
			
			/*Creamos las opciones del Juego*/
			JMenuItem nuevo = new JMenuItem("Nuevo Juego");
			nuevo.setBackground(Color.DARK_GRAY);
			nuevo.setForeground(Color.WHITE);
			nuevo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					if(ev.getSource() == nuevo) {
						/*Visualizamos la ventana "Nuevo Juego"*/
						AhorcadoInterfaz p = new AhorcadoInterfaz();
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
					if(salir.getSource() == exit)
						System.exit(0);
				}
			});
			JMenuItem creditos = new JMenuItem("Acerca de...");
			creditos.setBackground(Color.DARK_GRAY);
			creditos.setForeground(Color.WHITE);
			creditos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ev) {
					/*Visualizamos otra ventana al dar "Acerca de"*/
					//VerCreditos opcion = new VerCreditos();
					//Métodos para visualizar los datos del juego
					//opcion.verCreadores();
					//opcion.datosJuego();
					
					//opcion.setVisible(true);
					dispose();
				}
			});
			//Añadimos las opciones
			inicio.add(nuevo);
			inicio.add(exit);
			inicio.add(creditos);
		}
		
		private void initComponents() {
		
		
		pBienvenida = new JPanel();
		pBienvenida.setSize(this.getWidth(),this.getHeight());
		pBienvenida.setLocation(0,0);
		pBienvenida.setLayout(null);
		pBienvenida.setVisible(true);
		
		
		//ahorcado = new JLabel();
		//ahorcado.setSize(bienvenida.getWidth(),bienvenida.getHeight());
		//ahorcado.setIcon(new ImageIcon("imagenes/ahorcadobienvenida.png"));
		//ahorcado.setLocation(0,0);
		//ahorcado.setVisible(true);
		//ahorcado.setLocation(new Point(1,1));
		//pBienvenida.add(ahorcado);
		//bienvenida.add(pBienvenida);
		
		
		
		fBienvenida = new JLabel();
		fBienvenida.setSize(this.getWidth(),this.getHeight());
		fBienvenida.setIcon(new ImageIcon("imagenes/fondo.png"));
		fBienvenida.setLocation(0,0);
		fBienvenida.setVisible(true);
		pBienvenida.add(fBienvenida);
		this.add(pBienvenida);
		
	
		titulo= new JLabel("Puntuaciones");
		titulo.setSize(400, 400);
		titulo.setLocation(540, 0);
		titulo.setVisible(true);
		pBienvenida.add(titulo, 0);
		
			
		this.add(pBienvenida);
		this.setVisible(true);
		

		
		
	}



}
