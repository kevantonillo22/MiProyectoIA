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
    int porX;
    int porY;
    
    int def1X;
    int def1Y;
    int def2X;
    int def2Y;
    
    int del1X;
    int del1Y;
    int del2X;
    int del2Y;
    
    public String generarXML(int porX, int porY, int def1X, int def1Y, int def2X, int def2Y, int del1X, int del1Y, int del2X, int del2Y)
    {
        String r = "<Posiciones>\n" +
"	<Objeto>\n" +
"		<Nombre>Portero</Nombre>\n" +
"		<PosicionX>" + porX + "</PosicionX>\n" +
"		<PosicionY>" + porY + "</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Defensa1</Nombre>\n" +
"		<PosicionX>" + def1X + "</PosicionX>\n" +
"		<PosicionY>" + def1Y + "</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Defensa2</Nombre>\n" +
"		<PosicionX>" + def2X + "</PosicionX>\n" +
"		<PosicionY>" + def2Y + "</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Delantero1</Nombre>\n" +
"		<PosicionX>" + del1X + "</PosicionX>\n" +
"		<PosicionY>" + del1Y + "</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Delantero2</Nombre>\n" +
"		<PosicionX>" + del1X + "</PosicionX>\n" +
"		<PosicionY>" + del1Y + "</PosicionY>\n" +
"	</Objeto>\n" +
"</Posiciones>";
        
        return r;
    }
    public void leerPosiciones(String ttt)
    {
        try {
            String texto = "<Posiciones>\n" +
"	<Objeto>\n" +
"		<Nombre>Portero</Nombre>\n" +
"		<PosicionX>11</PosicionX>\n" +
"		<PosicionY>11</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Defensa1</Nombre>\n" +
"		<PosicionX>2</PosicionX>\n" +
"		<PosicionY>2</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Defensa2</Nombre>\n" +
"		<PosicionX>3</PosicionX>\n" +
"		<PosicionY>3</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Delantero1</Nombre>\n" +
"		<PosicionX>4</PosicionX>\n" +
"		<PosicionY>4</PosicionY>\n" +
"	</Objeto>\n" +
"\n" +
"	<Objeto>\n" +
"		<Nombre>Delantero2</Nombre>\n" +
"		<PosicionX>5</PosicionX>\n" +
"		<PosicionY>5</PosicionY>\n" +
"	</Objeto>\n" +
"</Posiciones>";
            byte[] xml =texto.getBytes();
            
            Document doc =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
                            new ByteArrayInputStream(
                                    xml
                            )
                    );
            NodeList e = doc.getElementsByTagName("Objeto");
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
            }
            
            
            System.out.println(porX);
            System.out.println(porY);
            System.out.println(def1X);
            System.out.println(def1Y);
            System.out.println(def2X);
            System.out.println(def2Y);
            
            System.out.println(del1X);
            System.out.println(del1Y);
            System.out.println(del2X);
            System.out.println(del2Y);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
