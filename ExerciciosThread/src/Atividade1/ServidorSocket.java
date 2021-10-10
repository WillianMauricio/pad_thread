
package Atividade1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorSocket {
    
    public static void main(String[] args) throws IOException {
        Socket             conexao  = null;
        ServerSocket       servidor = null;
        BufferedReader     entrada  = null;
        ArrayList<Integer> buffer   = new ArrayList(5);

        try {
            servidor = new ServerSocket(7015);

            conexao = servidor.accept();
            
            entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        
            do {
                String[] texto = entrada.readLine().split(" ");
                
                if (texto[0].equals("new")) {
                    new Produtor(buffer).start();
                } else if (texto[0].equals("remove")) {
                    new Consumidor(buffer).start();
                } else {
                    break;
                }
            } while (!"sair".equals(entrada.toString()));
        } catch (IOException ex) {
                System.out.println("Algo errado aconteceu");
        } finally {
            conexao.close();

            servidor.close();
        }
    }
 
}
