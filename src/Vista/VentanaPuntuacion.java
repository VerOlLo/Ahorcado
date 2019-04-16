package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class VentanaPuntuacion extends JFrame{
	
	private JPanel contentPane;
	private JTable table;
	
	public VentanaPuntuacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPuntuaciones.class.getResource("/Ahorcado/imagenes/ahorcadobienvenida.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPuntuaciones = new JLabel("Puntuaciones");
		lblPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 45));
		contentPane.add(lblPuntuaciones, BorderLayout.NORTH);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}
}

