package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.applet.AudioClip;


public class VentanaBienvenida extends JFrame {

	private JPanel t;
	private JPanel b;
	private JPanel bS;
	private JLabel titulo;
	private JButton bComenzar;
	private JButton bSalida;
	private JRadioButton JRadioButtonMAction;
	private URL f;
	private Image fondo;
	private AudioClip musica;
	private JPanel contentPane;

			
	public VentanaBienvenida() {
		setFont(new Font("Cooper Black", Font.PLAIN, 15));
		setTitle("El ahorcado");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaBienvenida.class.getResource("/imagenes/ahorcadobienvenida.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 982, 550);
		this.setLocationRelativeTo(null);
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Bienvenid@");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sitka Banner", Font.PLAIN, 42));
		lblTitulo.setForeground(new Color(0, 255, 255));
		lblTitulo.setBounds(336, 80, 333, 76);
		contentPane.add(lblTitulo);
		
		JCheckBox chckbxSonido = new JCheckBox("Sonido");
		chckbxSonido.setBackground(SystemColor.activeCaptionBorder);
		chckbxSonido.setBounds(832, 456, 72, 25);
		contentPane.add(chckbxSonido);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AhorcadoInterfaz j2 = new AhorcadoInterfaz();
				j2.setVisible(true);
				dispose();
			}
		});
		btnComenzar.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/imagenes/button_comenzar.png")));
		btnComenzar.setBounds(376, 327, 254, 62);
		contentPane.add(btnComenzar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/gifs/hanging.gif")));
		lblNewLabel.setBounds(0, 0, 982, 550);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/gifs/ahorcado.gif")));
		lblNewLabel_1.setBounds(445, 176, 85, 62);
		contentPane.add(lblNewLabel_1);
		
		setVisible(true);
	}
}
