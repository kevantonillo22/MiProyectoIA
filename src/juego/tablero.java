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
    
    public int[] getPosicionesJugadores()
    {
        int[] h = new int[10];
        
        for (int i = 0; i < 16; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if(mapa[i][j] != null)
                {
                    if(mapa[i][j].tipo.contains("portero")){h[0] = i;h[1] = j;}
                    else if(mapa[i][j].tipo.contains("defensa1")){h[2] = i;h[3] = j;}
                    else if(mapa[i][j].tipo.contains("defensa2")){h[4] = i;h[5] = j;}
                    else if(mapa[i][j].tipo.contains("delantero1")){h[6] = i;h[7] = j;}
                    else if(mapa[i][j].tipo.contains("delantero2")){h[8] = i;h[9] = j;}
                }
            }
        }
        
        return h;
    }
    
    public int[] getBalonPosicion()
    {
        int[] h = new int[2];
        
        for (int i = 0; i < 16; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if(mapa[i][j] != null)
                {
                    if(mapa[i][j].tipo.contains("pelota")){h[0] = i;h[1] = j;}
                    break;
                }
            }
        }
        
        return h;
    }
}
