package Vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class VerCreditos extends JFrame {
	private JLabel name1,name2,name3,copyright,version,DAM;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem regresarMenu;
	
	public VerCreditos() {
		super("Ventana de los créditos");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(589,408);
		setUndecorated(true);//eliminar la barra de JFrame
		getContentPane().setBackground(Color.LIGHT_GRAY);
		//Métodos de los contenidos
		initMenus();	
		verCreadores();
		datosJuego();
		
		setLocationRelativeTo(null);
	}
	
	private void initMenus() {
		barra = new JMenuBar();
		setJMenuBar(barra);
		barra.setBackground(Color.DARK_GRAY);
		
		menu = new JMenu("Opciones");
		menu.setForeground(Color.WHITE);
		barra.add(menu);
		
		regresarMenu = new JMenuItem("Volver al menú");
		regresarMenu.setBackground(Color.DARK_GRAY);
		regresarMenu.setForeground(Color.WHITE);
		//---Para volver al menú----
		regresarMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource() == regresarMenu) {
					dispose();
				}
			}
		});
		
		menu.add(regresarMenu);
	}
	
	/*----------------MÉTODOS PARA LOS CREADORES----------------------*/
	public void verCreadores() {
		Font f1 = new Font("Tahoma",Font.BOLD,25);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);//para ocultar el fondo de este JPanel
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,16,3));
		p1.setLayout(new GridLayout(2,5));
		getContentPane().add(p1);
		DAM = new JLabel("Un juego creado por los alumnos de 1º DAM:");
		DAM.setFont(f1);
		getContentPane().add(DAM);
		p1.add(DAM);
		
		//Nombres de los creadores
		Font f2 = new Font("Verdana",Font.CENTER_BASELINE,17);
		Color fuente = new Color(1,99,233);
		JPanel p2 = new JPanel();
		p2.setOpaque(false);//para ocultar el fondo de este JPanel
		p2.setLayout(new GridLayout(8,9,1,52));
		getContentPane().add(p2);
		name1 = new JLabel("Verónica Olmo López");
		name1.setFont(f2);
		name1.setForeground(fuente);
		getContentPane().add(name1);
		name2 = new JLabel("Alicia Walias Palacios");
		name2.setFont(f2);
		name2.setForeground(fuente);
		getContentPane().add(name2);
		name3 = new JLabel("Julio Muñoz Chozas");
		name3.setFont(f2);
		name3.setForeground(fuente);
		getContentPane().add(name3);
		
		p2.add(name1,BorderLayout.NORTH);
		p2.add(name2,BorderLayout.CENTER);
		p2.add(name3,BorderLayout.SOUTH);
	}

	public void datosJuego() {
		JPanel p3 = new JPanel();
		p3.setOpaque(false);//para ocultar el fondo de este JPanel
		p3.setLayout(new BorderLayout(9,2));
		getContentPane().add(p3);
		//----Creamos componentes-----
		copyright = new JLabel("@Copyright");
		getContentPane().add(copyright);
		version = new JLabel("Version 1.0");
		getContentPane().add(version);
		
		p3.add(copyright,BorderLayout.WEST);
		p3.add(version,BorderLayout.EAST);
	}
}
