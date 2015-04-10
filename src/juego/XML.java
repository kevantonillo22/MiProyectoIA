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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XML {
    public int porX;
    public int porY;
    
    public int def1X;
    public int def1Y;
    public int def2X;
    public int def2Y;
    
    public int del1X;
    public int del1Y;
    public int del2X;
    public int del2Y;
    
    public int ballX;
    public int ballY;
    
    public String generarXML(int porX, int porY, int def1X, int def1Y, int def2X, int def2Y, int del1X, int del1Y, int del2X, int del2Y, int ballX, int ballY)
    {
        String r = "<Posiciones>" +
            "<Objeto>" +
            "<Nombre>Portero</Nombre>" +
            "<PosicionX>" + porX + "</PosicionX>" +
            "<PosicionY>" + porY + "</PosicionY>" +
            "</Objeto>" +
            "" +
            "<Objeto>" +
            "<Nombre>Defensa1</Nombre>" +
            "<PosicionX>" + def1X + "</PosicionX>" +
            "<PosicionY>" + def1Y + "</PosicionY>" +
            "</Objeto>" +
            "" +
            "<Objeto>" +
            "<Nombre>Defensa2</Nombre>" +
            "<PosicionX>" + def2X + "</PosicionX>" +
            "<PosicionY>" + def2Y + "</PosicionY>" +
            "</Objeto>" +
            "" +
            "<Objeto>" +
            "<Nombre>Delantero1</Nombre>" +
            "<PosicionX>" + del1X + "</PosicionX>" +
            "<PosicionY>" + del1Y + "</PosicionY>" +
            "</Objeto>" +
            "" +
            "<Objeto>" +
            "<Nombre>Delantero2</Nombre>" +
            "<PosicionX>" + del2X + "</PosicionX>" +
            "<PosicionY>" + del2Y + "</PosicionY>" +
            "</Objeto>" +
            "<Objeto>" +
            "<Nombre>Balon</Nombre>" +
            "<PosicionX>" + ballX + "</PosicionX>" +
            "<PosicionY>" + ballY + "</PosicionY>" +
            "</Objeto>" +
            "</Posiciones>";
        
        return r;
    }
    public boolean leerXML(String texto)
    {
        boolean cambiarCancha = false;
        try {
            
            byte[] xml =texto.getBytes();
            
            Document doc =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
                            new ByteArrayInputStream(
                                    xml
                            )
                    );
            NodeList e = doc.getElementsByTagName("Objeto");
            //ES UN CAMBIO DE CANCHA
            if(e.getLength() <= 0)
            {
                String cambio = doc.getElementsByTagName("Cambio").item(0).getTextContent();
                if(cambio.contains("Si"))
                {
                    cambiarCancha = true;
                }   
            }
            //DE LO CONTRARIO ES UNO DE POSICIONES NORMALES
            else{
                for (int i = 0; i <= e.getLength() - 1; i++) {
                    Element ele = (Element)e.item(i);
                    String r = ele.getElementsByTagName("Nombre").item(0).getTextContent();
                    if(r.contains("Portero"))
                    {
                        porX = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        porY = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                    else if(r.contains("Defensa1"))
                    {
                        def1X = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        def1Y = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                    else if(r.contains("Defensa2"))
                    {
                        def2X = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        def2Y = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                    else if(r.contains("Delantero1"))
                    {
                        del1X = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        del1Y = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                    else if(r.contains("Delantero2"))
                    {
                        del2X = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        del2Y = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                    else if(r.contains("Balon"))
                    {
                        ballX = Integer.parseInt(ele.getElementsByTagName("PosicionX").item(0).getTextContent());
                        ballY = Integer.parseInt(ele.getElementsByTagName("PosicionY").item(0).getTextContent());
                    }
                }
            }
            
            
 
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cambiarCancha;
    }
    
    
}
