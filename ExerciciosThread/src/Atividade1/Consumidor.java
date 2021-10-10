package Atividade1;

import java.util.ArrayList;

public class Consumidor extends Thread {
    
    private static ArrayList<Integer> buffer;
    
    /**
     * @param buffer
     */
    public Consumidor(ArrayList<Integer> buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        if (!this.buffer.isEmpty()) {
            System.out.println("Valor sendo retirado: " + this.buffer.get(0));
            this.buffer.remove(0);
        }
    }
    
}
