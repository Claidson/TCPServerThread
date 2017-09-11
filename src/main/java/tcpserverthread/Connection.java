    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserverthread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author aluno
 */
public class Connection extends Thread{
   DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    
    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            
        } catch (IOException e) {
            System.out.println("Conectado: "+e.getMessage());
        }
    }
    
    public void run() {
        try {
            while (true) {
                /* Receive message from client */
                String data = in.readUTF();
                System.out.print("\n\t[Recebido - "+clientSocket.getInetAddress().toString()
                        +":"+clientSocket.getPort()+"]: "+data);
                
                /* Send the response to client */
                data = "Recebido pelo servidor";
                out.writeUTF(data);
            
            }
            
            
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        }
    } 
}
