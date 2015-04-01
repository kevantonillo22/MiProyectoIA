/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_v1.pkg1;

import juego.XML;

/**
 *
 * @author Kev
 */
public class ProyectoIA_v11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //prolog.inteligencia i = new prolog.inteligencia();
        //i.iniciar();
         //System.out.println(System.getProperty("java.library.path")) ;
        XML h = new XML();
        h.leerPosiciones("");
        System.out.println(h.generarXML(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        /*mainFrame frame = new mainFrame();
        frame.setSize(800, 650);
       frame.setVisible(true);*/
       
    }
    
}
