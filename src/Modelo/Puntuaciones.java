package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Vista.VentanaPuntuaciones;

public class Puntuaciones {

	File ranking;
	FileReader fr;
	BufferedReader br;

	public void leeArchivos() {
    	
     try {
       ranking = new File ("Puntuaciones.txt");
       fr = new FileReader (ranking);
       br = new BufferedReader(fr);

       
       String linea;
       String s="";
       while((linea=br.readLine())!=null)
          s+=linea+"\n";
    	   VentanaPuntuaciones.txtTxt.setText(linea);
    }
    catch(Exception e){
       e.printStackTrace();
    }finally{
       try{
          if( null != fr ){
             fr.close();
          }
       }catch (Exception e2){
          e2.printStackTrace();
       }
    }
	}
}
