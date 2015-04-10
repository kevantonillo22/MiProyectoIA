/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectoia_v1.pkg1.mainFrame;

/**
 *
 * @author Kev
 */
public class tiempo implements Runnable{
    
    int minuto = 0;
    int segundo= 0;
    JLabel label = null;
    mainFrame frame;
    
    public tiempo(JLabel label, mainFrame frame)
    {
        this.label = label;
        this.frame = frame;
    }
    
    @Override
    public void run() {
        
        while(true)
        {
            try {
                Thread.sleep(1000);
                segundo++;
                if(segundo==60){    
                    minuto++;
                    segundo = 0;
                }
                
                String min = minuto + "";
                String seg = segundo + "";
                if(minuto<10){min="0" + minuto;}
                if(segundo<10){seg="0" + segundo;}
                
                label.setText(min + ":" + seg);
                label.repaint();
                
                if(segundo == 5)
                {
                    //JOptionPane.showMessageDialog(frame, "Se acabo el tiempo", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
