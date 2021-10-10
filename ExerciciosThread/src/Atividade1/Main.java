package Atividade1;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> buffer = new ArrayList();
        
        Produtor produtor     = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);     
        
        buffer.forEach(item -> {
            System.out.println(item);
        });

        consumidor.start();
        produtor.start();
    }
}

