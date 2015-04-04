/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kev
 */
public class cliente {
    Socket cliente;
    int puerto;
    String ip;
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    public cliente(String ip, int puerto)
    {
        this.puerto = puerto;
        this.ip = ip;
    }
    
    public void conectar(){
        try {
            cliente = new Socket(ip, puerto);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public String recept_message()
    {
        String msg = "";
        try {
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            msg = entrada.readLine();
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    public void send_message(String tec)
    {
        try {
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(tec);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar_conexion()
    {
        try {
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
