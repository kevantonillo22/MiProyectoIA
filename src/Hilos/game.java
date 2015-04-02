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
public class game implements Runnable{

    mainFrame frame;
    tablero map;
    sockets.servidor server;
    
    public game(mainFrame frame, tablero map, sockets.servidor server)
    {
        this.frame = frame;
        this.map = map;
        this.server = server;
    }
    
    @Override
    public void run() {
        int x = 0;
        int y = 5;
        map.setJugador("portero", x, y);
        frame.setPosicionMapa("portero", x, y);

        x=4;y=2;
        map.setJugador("defensa1", x, y);
        frame.setPosicionMapa("defensa1", x, y);
        x=4;y=8;
        map.setJugador("defensa2", x, y);
        frame.setPosicionMapa("defensa2", x, y);

        x=12;y=3;
        map.setJugador("delantero1", x, y);
        frame.setPosicionMapa("delantero1", x, y);
        x=12;y=7;
        map.setJugador("delantero1", x, y);
        frame.setPosicionMapa("delantero1", x, y);

        x=8;y=5;
        map.setJugador("pelota", x, y);
        frame.setPosicionMapa("pelota", x, y);
        
        //envio de posiciones iniciales
        int posicionesJugadores[]  = map.getPosicionesJugadores();
        int posicionBalon[] = map.getBalonPosicion();
        XML info = new XML();
        String msn = info.generarXML(posicionesJugadores[0], posicionesJugadores[1], posicionesJugadores[2],
                posicionesJugadores[3], posicionesJugadores[4], posicionesJugadores[5],
                posicionesJugadores[6], posicionesJugadores[7], posicionesJugadores[8], posicionesJugadores[9], posicionBalon[0], posicionBalon[1]);
        server.send_message(msn);
        
        //recibir información para colocar jugadores oponentes
        server.recept_message();
        while(true){
            System.out.println(msn);
            
        }
    }
    
    
    
}
