
package Atividade1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
       
    public static void main(String[] args) throws IOException {
        
        Scanner entrada = new Scanner(System.in);
        
        Socket      cliente = null;
        PrintStream saida   = null;
        String      texto   = "";
        
        try {
            cliente = new Socket("192.168.0.111", 7015);
            
            saida = new PrintStream(cliente.getOutputStream());
            do {
                texto = entrada.nextLine();
                
                saida.println(texto);
            } while (!"sair".equals(texto));
        } catch(IOException e) {
            System.out.println("Algo errado aconteceu");
        } finally {
            cliente.close();
        }
    }
}
