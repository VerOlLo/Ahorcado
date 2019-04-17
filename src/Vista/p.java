package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class p extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					p frame = new p();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public p() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPuntuaciones = new JLabel("Puntuaciones");
		lblPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPuntuaciones, BorderLayout.NORTH);
		
		txtTxt = new JTextField();
		txtTxt.setHorizontalAlignment(SwingConstants.CENTER);
		txtTxt.setText("txt");
		contentPane.add(txtTxt, BorderLayout.CENTER);
		txtTxt.setColumns(10);
	}

}
