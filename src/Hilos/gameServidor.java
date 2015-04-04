/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import juego.XML;
import juego.tablero;
import proyectoia_v1.pkg1.mainFrame;

/**
 *
 * @author Kev
 */
public class gameServidor implements Runnable{

    mainFrame frame;
    tablero map;
    sockets.servidor server;
    boolean freno = false;
    
    public gameServidor(mainFrame frame, tablero map, sockets.servidor server)
    {
        this.frame = frame;
        this.map = map;
        this.server = server;
    }
    
    @Override
    public void run() {
        while(freno == false){
            try {
                Thread.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(gameServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            //REALIZACION DE ACCIONES PARA MI TURNO (LOGICA PROLOG)
            
            
            //setear las posiciones de los jugadores
            int posicionesJugadores[]  = map.getPosicionesJugadores();
            int posicionBalon[] = map.getBalonPosicion();
            XML info = new XML();
            String msn = info.generarXML(posicionesJugadores[0], posicionesJugadores[1], posicionesJugadores[2],
                    posicionesJugadores[3], posicionesJugadores[4], posicionesJugadores[5],
                    posicionesJugadores[6], posicionesJugadores[7], posicionesJugadores[8], posicionesJugadores[9], posicionBalon[0], posicionBalon[1]);
            server.send_message(msn);
            System.out.println("Se envio mensaje de turno");
            
            
            //se espera mensaje de enemigo para posicionar en tablero
            System.out.println("esperando mensaje");
            String posicionesEnemigo = server.recept_message();
            System.out.println("mensaje recibido");
            
            //se resetean las posiciones de los enemigo actualmente
            map.quitarEnemigo();
            map.quitarBalon();
            
            int x;
            int y;
            XML xml = new XML();
            boolean cambiarCancha = xml.leerXML(posicionesEnemigo);
            
            if(!cambiarCancha)
            {
                x=xml.porX;y=xml.porY;
                map.setJugador("enemigo", x, y);

                x=xml.def1X;y=xml.def1Y;
                map.setJugador("enemigo", x, y);

                x=xml.def2X;y=xml.def2Y;
                map.setJugador("enemigo", x, y);

                x=xml.del1X;y=xml.del1Y;
                map.setJugador("enemigo", x, y);

                x=xml.del2X;y=xml.del2Y;
                map.setJugador("enemigo", x, y);

                x=xml.ballX;y=xml.ballY;
                map.setJugador("balon", x, y);

                frame.actualizarMapa();
            }
            else
            {
                //CAMBIAR DE CANCHA
            }
        }
    }
    
    
    
}
