package Modelo;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Letras {

	private void gestionLetras() {
		Ahorcadointefaz.jPanel3.setLayout(new GridLayout(6, 5));
	
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
}
