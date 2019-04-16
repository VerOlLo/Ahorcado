package Vista;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Ahorcado.Ahorcado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;


public class AhorcadoInterfaz extends JFrame {

	private Ahorcado juego;
	private JButton[] letters = new JButton[27];
	private JButton jBComenzar;
	private JLabel ahorcado,tPalabra,titulo;
	private JPanel jPanel3;
	private JTextField jTextFP;
	private String letrap;
	
	//private Image fondo;

	/**
	 * Creates new form AhorcadoInterfaz
	 */
	public AhorcadoInterfaz() {
		initComponents();
		gestionBarra();
		gestionLetras();
		this.setTitle("El Ahorcado"); //Nombre de la ventana
		this.setSize(1000, 1000);
		//JPanel contentPane = new JPanel();
		//contentPane.setBackground(new Color(47, 79, 79));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		this.setLocationRelativeTo(null);//Centra la ventana
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// El programa se cierra del todo, se borra de las tareas del ordenador
		//this.getContentPane().setLayout(new GridBagLayout());
		
		
		 //Listener
       
		ActionListener listener = (ActionEvent e) -> {
            if(juego!=null){
                String p = e.getActionCommand();
                juego.analizar(p.charAt(0));                
            }else{
                JOptionPane.showMessageDialog(null, "Debes iniciar el juego antes");
            }
        };
	}
        
	
	
	
    	private void gestionLetras() {
    		jPanel3.setLayout(new GridLayout(6, 5));
    	
    		//------------Creación de array---------------
    	   		
    		char[] letras = {'A','B','C','D','E','F','G','H',
    				'I','J','K','L','M','N','Ñ','O','P','Q'
    				,'R','S','T','U','V','W','X','Y','Z'};
    		
    		for(int i = 0; i < letras.length; i++) {
    			if(letters[i] == null) {
    				Font fuente = new Font("Verdana",Font.BOLD,20);
    				letters[i] = new JButton(Character.toString((char)letras[i]));
    				getContentPane().add(letters[i]);
    				//--Reducimos el tamaño por defecto de los botones al añadirlos---
    				letters[i].setMinimumSize(new Dimension(40,40));/*tamaño mínimo*/
    				letters[i].setPreferredSize(new Dimension(66,36));/*tamaño preferente*/
    				letters[i].setFont(fuente);
    				
    				/*Metemos botones en el JPanel*/
    				jPanel3.add(letters[i]);
    				
    				//letters[i].addActionListener(listener);
    				letters[i].addActionListener(new ActionListener() {
    					@Override
    					public void actionPerformed(ActionEvent ev) {
    						 if(juego!=null){
    				                String p = ev.getActionCommand();
    				                juego.analizar(p.charAt(0));                
    				            }else{
    				                JOptionPane.showMessageDialog(null, "Debes iniciar el juego antes");
    				            }
    						
    						JButton botonOpri = (JButton)ev.getSource();
    						letrap=botonOpri.getText(); //String de la letra oprimida por cada botón
    						System.out.println(letrap);
    						botonOpri.setEnabled(false);
    							}
				
			
			});
			
    		}
    		}

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
		
		JMenuItem puntuaciones = new JMenuItem("Ganadores");
		puntuaciones.setBackground(Color.DARK_GRAY);
		puntuaciones.setForeground(Color.WHITE);
		puntuaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource() == puntuaciones) {
					
					VentanaPuntuaciones p = new VentanaPuntuaciones();
					p.setVisible(true);
					dispose();
				}				
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
		inicio.add(puntuaciones);
		inicio.add(creditos);
	}
	
	private void initComponents() {
		

		
		jPanel3 = new JPanel();
		ahorcado = new JLabel();
		tPalabra = new JLabel();
		jTextFP = new JTextField();
		jBComenzar = new JButton();
		
		
		
		//JLabel fondo = new JLabel();
		//setContentPane(fondo);
		
		//ImageIcon imagenf = new ImageIcon("imagenes/fondo.png");
		//fondo.setIcon(imagenf);
		//fondo.setSize(imagenf.getIconWidth(),imagenf.getIconHeight());
		
		//JLabel encima = new JLabel();
		//encima.setSize(200,200);
		
		//Título de la ventana
		titulo = new JLabel();
		titulo.setFont(new Font("Cooper Black",Font.BOLD,75));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		setLayout(new GridBagLayout()); //Declaro el Layout que voy a usar
		GridBagConstraints gbcons = new GridBagConstraints(); 
		gbcons.gridx=1; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=0; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.CENTER;
		this.getContentPane().add(titulo,gbcons); //Le asigna los atributos al componente titulo
		titulo.setText("1 vs 2");
		//titulo.setBounds(20,10,300,100); //Ubicación dentro del Frame
		
		//Borde1
		//jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		//gbcons.gridx=0; //Indica la posición del componente en el eje x (horizontal)
		//gbcons.gridy=2; //Indica la posición del componenete en el eje y (vertical)
		//gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		//gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		//gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		//gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		//gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		//gbcons.anchor= GridBagConstraints.CENTER;
		//this.getContentPane().add(jPanel1,gbcons);
		//jPanel1.setLayout(new BorderLayout());

		//Imágenes Ahorcado
		ahorcado.setIcon(new ImageIcon(getClass().getResource("/imagenes/ahorcado_6.png"))); 
		//jLabel1.setSize(50,50);
		ahorcado.setHorizontalAlignment(JLabel.CENTER);
		gbcons.gridx=0; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=1; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.EAST;
		this.getContentPane().add(ahorcado, gbcons);
		
		//Borde 2
		//jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		//gbcons.gridx=3; //Indica la posición del componente en el eje x (horizontal)
		//gbcons.gridy=3; //Indica la posición del componenete en el eje y (vertical)
		//gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		//gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		//gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		//gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		//gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		//gbcons.anchor= GridBagConstraints.CENTER;
		//this.getContentPane().add(jPanel2,gbcons);
		//jPanel2.setLayout(new GridBagLayout());

			
		//Etiqueta título para la palabra
		tPalabra.setText("Adivina la palabra:");
		tPalabra.setHorizontalAlignment(JLabel.CENTER);
		gbcons.gridx=1; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=2; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.CENTER;
		this.getContentPane().add(tPalabra, gbcons);
		
		//Cuadrado de texto que se rellenará con la palabra por letras
		jTextFP.setEditable(false);
		jTextFP.setBackground(new Color(255, 255, 255));
		jTextFP.setFont(new Font("Tahoma", 1, 18)); 
		jTextFP.setHorizontalAlignment(JTextField.CENTER);
		jTextFP.setPreferredSize(new Dimension(300, 28));
		gbcons.gridx=1; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=6; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.CENTER;
		this.getContentPane().add(jTextFP, gbcons);
		
		//Teclado
		jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 157, Short.MAX_VALUE));
		gbcons.gridx=1; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=7; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.NORTHWEST;
		this.getContentPane().add(jPanel3,gbcons);
		
		//Botón jugar
		jBComenzar.setText("Jugar");
		gbcons.gridx=1; //Indica la posición del componente en el eje x (horizontal)
		gbcons.gridy=8; //Indica la posición del componenete en el eje y (vertical)
		gbcons.gridwidth=0; //Indica cuantas columnas va a ocupar
		gbcons.gridheight=1; //Indica cuantas filas va a ocupar
		gbcons.weightx = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje horizontal)
		gbcons.weighty = 1.0; //Indica la relación en la que el componente se adaptará al tamaño (eje vertical)
		gbcons.fill = GridBagConstraints.BOTH;//Los componentes crecen
		gbcons.anchor= GridBagConstraints.CENTER;
		this.getContentPane().add(jBComenzar,gbcons);
		  jBComenzar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jBComenzarActionPerformed(evt);
	            }
	        });
		
				
		this.setVisible(true);
		//pack(); //Para que todo se adapte

	}

	private void jBComenzarActionPerformed(ActionEvent evt) {
		juego = new Ahorcado(jTextFP,ahorcado);
		
	}
}
