package Ahorcado;

import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Modelo {
	private boolean on = false;
	private boolean aciertos = false;
	private String palabraJ2;
	private char[] palabra;
	private int intentos =0;
	private JTextField palabraO;
	private JLabel fallos, ahorcado;
	
	public Modelo(JTextField palabraO, JLabel fallos, JLabel ahorcado) {
		this.palabraO = palabraO;
		this.fallos = fallos;
		this.ahorcado = ahorcado;
		
		//Arrays.toString(palabraJ2);
		String espacios = "";
		for (int i = 0; i<=palabraJ2.length() - 1;i++) {
			espacios = espacios + "_";
		}
		this.palabra = espacios.toCharArray();
		palabraO.setText(espacios);
		ahorcado.setIcon(new ImageIcon(getClass().getResource("imagenes/ahorcado_6.png")));
		this.on = true;
		}
		
		public void analizar (char letra) {
			if (on) {
			String p = "";
				if (intentos == 6) {
					JOptionPane.showMessageDialog(null, "Perdiste. Juego finalizado");
				}else{
					for(int l = 0; l<=palabraJ2.length() -1;l++) {
						if(palabraJ2[l] == letra) {
							this.palabra[l] = letra;
							 aciertos = true;
	                    }
	                   p = p + this.palabra[l];
	                }//fin for
	                
	                //si no se produjo ningun cambio, quiere decir que el jugador se equivoco
	               if (aciertos == false) {
	                    intentos += 1; //se incrementa     
	                    //actualiza interfaz
	                    fallos.setIcon(new ImageIcon(getClass().getResource("/net/jc_mouse/ahorcado/resources/emo" + this.intentos + ".jpg")));
	                   ahorcado.setIcon(new ImageIcon(getClass().getResource("/net/jc_mouse/ahorcado/resources/ahorcado_" + this.intentos + ".jpg")));
	                    if (this.intentos < 6) {
	                       JOptionPane.showMessageDialog(null, "¡Fallo!. Te quedan " + (6 - intentos) + " intentos más");
	                   }
	               } else {
	                    this.aciertos = false;
	                }
	                this.palabraO.setText(p);
	                //comprobamos el estado del juego
	                ganador();
	            }
	        }
	    }

	    /**
	     * Si usuario completo "palabra oculta" el juego termina sino continua jugando
	     */
	    private void ganador() {
	        boolean gana = false;
	        for (int i = 0; i <= this.palabraJ2.length() - 1; i++) {
	            if (this.palabra[i] == this.palabraJ2[i]) {
	                gana = true;
	            } else {
	                gana = false;
	                break;
	            }
	        }
	        if (gana) {
	            JOptionPane.showMessageDialog(null, "Tenemos un ganador");
	            //jLabel2.setIcon(new ImageIcon(getClass().getResource("/net/jc_mouse/ahorcado/resources/win.jpg")));
	        }
	    }

	}
