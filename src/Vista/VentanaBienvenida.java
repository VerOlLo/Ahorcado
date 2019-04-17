package Vista;


import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class VentanaBienvenida extends JFrame {


	
	private JPanel contentPane;

			
	public VentanaBienvenida() {
		setTitle("El Ahorcado");
		Image iconoV = new ImageIcon(getClass().getResource("/imagenes/ahorcadobienvenida.png")).getImage();
        setIconImage(iconoV);
        this.setResizable(false);
        this.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 1200, 800);
		this.setLocationRelativeTo(null);
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/imagenes/titulo.png")));
		lblTitulo.setBounds(20, -200, 1000,800);
		contentPane.add(lblTitulo);
		
		//JCheckBox chckbxSonido = new JCheckBox("Sonido");
		//chckbxSonido.setBackground(SystemColor.activeCaptionBorder);
		//chckbxSonido.setBounds(1050, 700, 72, 25);
		//contentPane.add(chckbxSonido);
		
		
		JButton btnComenzar = new JButton();
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ahorcado1vs2 j2 = new Ahorcado1vs2();
				j2.setVisible(true);
				dispose();
			}
		});
				
		btnComenzar.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/imagenes/button_comenzar1.png")));
		btnComenzar.setBounds(450, 450, 260, 200);
		btnComenzar.setOpaque(false);
		btnComenzar.setContentAreaFilled(false);
		btnComenzar.setBorderPainted(false);
		btnComenzar.setBorder(null);
		contentPane.add(btnComenzar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaBienvenida.class.getResource("/gifs/ahorcadoFondo.gif")));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		contentPane.add(lblNewLabel);
		
				
		setVisible(true);
	}
}
