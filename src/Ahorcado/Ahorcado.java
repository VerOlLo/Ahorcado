package Ahorcado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ahorcado {
	  private JTextField jTextField;
	    private JLabel jLabel2;
	    private int intentos = 0;
	    private boolean jugando = false;
	    private boolean ganado = false;
	    private boolean cambios = false;    
	    private char[] pElegida;
	    private char[] palabra;
	    private String fecha;
	    private String palabraJ2;
	    private String nombreJ1;

	    
	    

	    /**
	     * Constructor de clase
	     * @param jTextField Control donde va la palabra
	     
	     * @param jLabel2 Para mostrar la imagen del colgado
	     */
	    public Ahorcado(JTextField jTextField, JLabel jLabel2) {        
	        this.jTextField = jTextField;
	        this.jLabel2 = jLabel2;
	        
	        //obtiene palabra secreta
	        palabraJ2=JOptionPane.showInputDialog(null, "Jugador 2 - Introduzca la palabra:");
	        pElegida = palabraJ2.toUpperCase().toCharArray(); //Convierto la palabra en mayúsculas y array
	        System.out.println(pElegida);
	        nombreJ1=JOptionPane.showInputDialog(null,"Jugador 1 - Introduzca su nombre");
	        System.out.println(Arrays.toString(pElegida)); //no haga trampa
	        String relleno = "";
	        //Corresponde a la longitud de la palabra en " _ "
	        for (int i = 0; i <= pElegida.length - 1; i++) {
	           relleno = relleno + " _ "; 
	           //System.out.println(relleno);
	        }
	        
	        
	        palabra = relleno.toCharArray(); //Convierte a array
	       System.out.println(palabra);
	        
	        //inicia valores en la interfaz
	        jTextField.setText(relleno);
	        jLabel2.setIcon(new ImageIcon(getClass().getResource("/imagenes/ahorcado_6.png")));
	        this.jugando = true;
	        
	    }
	    
	    
	    
	    
	    public void analizar(char l) {
	       if(jugando) {
	            String sLetra= "";
	            //controla cantidad de intentes restantes
	            if (intentos == 6) {
	                JOptionPane.showMessageDialog(null, "Perdiste");
	                Date hoy= new Date();
	                DateFormat fechaH = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	                fecha=fechaH.format(hoy);
	            } else {
	                //evalua caracter por caracter                
	                for (int i = 0; i <= pElegida.length -1; i++) { //Se comprueba en el array de la palabra elegida
	                    //si el caracter se encuentra en la palabra secreta            
	                    if (pElegida[i] == l) {
	                       System.out.println("exito");
	                    	this.palabra[i] = l;//se asigna para que se pueda ver en pantalla
	                        cambios = true;
	                    }
	                   sLetra = sLetra + this.palabra[i];
	                }//fin for
	                
	                //si no se produjo ningun cambio, quiere decir que el jugador se equivoco
	                if (cambios == false) {
	                    intentos += 1; //se incrementa     
	                    //actualiza interfaz
	                   
	                    jLabel2.setIcon(new ImageIcon(getClass().getResource("/imagenes/ahorcado_" + this.intentos + ".jpg")));
	                    if (this.intentos < 6) {
	                        JOptionPane.showMessageDialog(null, "¡Error!, te quedan " + (6 - intentos) + " intentos más");
	                    }
	                } else {
	                    this.cambios = false;
	                }
	                this.jTextField.setText(sLetra);
	                //comprobamos el estado del juego
	                ganar();
	            }
	        }
	    }
	    /**
	     * Si usuario completo "palabra oculta" el juego termina sino continua jugando
	     */
	    private void ganar() {
	        boolean ganador = false;
	        for (int i = 0; i <= this.pElegida.length - 1; i++) {
	            if (this.palabra[i] == this.pElegida[i]) {
	                ganador = true;
	            } else {
	                ganador = false;
	                break;
	            }
	        }
	        if (ganador) {
	            JOptionPane.showMessageDialog(null, "¡Ganaste!");
	            Gpuntuaciones();
	            
	            
	        }
	    }

	    

@Override
		public String toString() {
			return "Ahorcado [fecha=" + fecha + ", Palabra=" + palabraJ2 + ", Nombre del jugador=" + nombreJ1 + "]\n";
			
		}




private void Gpuntuaciones() {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Puntuaciones.txt",true));
		writer.write(toString());
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}