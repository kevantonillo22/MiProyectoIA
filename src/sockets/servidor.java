/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.net.*;
import java.io.*;

/**
 *
 * @author Kev
 */
public class servidor {
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    BufferedReader entrada;
    
    
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
    
    public void recept_message()
    {
        try
        {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void send_message(String message)
    {
        try
        {
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(message);
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
