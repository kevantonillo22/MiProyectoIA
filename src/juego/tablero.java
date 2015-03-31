/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Kev
 */
public class tablero {
    
    public jugador[][] mapa;
    
    public tablero()
    {
        mapa = new jugador[17][11];
    }
    
    public void setJugador(String tipo, int x, int y)
    {
        jugador j = new jugador(tipo);
        mapa[x][y] = j;
    }
    
    public jugador getJugador(int x, int y)
    {
        return mapa[x][y];
    }
}
