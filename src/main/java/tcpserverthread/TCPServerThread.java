
package tcpserverthread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Claidson
 */ 
public class TCPServerThread {
    /**
     * 
     * @param port server port
     */
    private static void runServer(int port) {
        System.out.print("\nRodando TCPServerThread na porta "+port+"...");
        try {
            ServerSocket listenSocket = new ServerSocket(port, 5);
            while (true) {                
                System.out.print("\n\tEsperando conexao...");
                Socket clientSocket = listenSocket.accept();
                System.out.print("\n\tConectado a:  "
                        +clientSocket.getInetAddress().toString()+" na porta "
                        +clientSocket.getPort());
                Connection c = new Connection(clientSocket);
                c.start();
            }
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 6666;
       // args[0] = "1";
        /* Gets and check parameter */
        if (true) {
           // port = Integer.parseInt(args[0]);
            if ((port >= 1) && (port <= 65535)) {
                runServer(port);
            } else {
                System.out.print("\nPorta invalida!!!\n\tFaixa: 1 - 65535");
                System.exit(1);
            }
        } else {
            System.out.print("\nParametro errado!!!\n\t Selecione porta do servidor entre (1 - 65535)");
            System.exit(1);
        }
    }
}
