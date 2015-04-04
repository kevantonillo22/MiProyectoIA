/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.net.*;
import java.io.*;
import juego.XML;

/**
 *
 * @author Kev
 */
public class servidor {
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    PrintStream salida;
    BufferedReader entrada;
    
    public servidor(int puerto)
    {
        this.puerto = puerto;
    }
    
    public boolean iniciar_conexion(){
        boolean r = false;
        try{
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();
            r= true;
            
        }catch(Exception e){
            System.out.println(e);
        }
        return r;
    }
    
    public String recept_message()
    {
        String r = "";
        try
        {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            r = mensaje;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return r;
    }
    
    public void send_message(String message)
    {
        try
        {
            salida = new PrintStream(socket.getOutputStream());
            salida.println(message);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public boolean cerrar_conexion()
    {
        boolean r = false;
        try
        {
            socket.close();
            r = true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return r;
    }
}
