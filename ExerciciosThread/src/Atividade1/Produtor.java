package Atividade1;

import java.util.ArrayList;
import java.util.Random;

public class Produtor extends Thread {
    
    private static ArrayList<Integer> buffer;
    
    private static final int TAMANHO_BUFFER = 5;
    
    /**
     * @param buffer
     */
    public Produtor(ArrayList<Integer> buffer){
        this.buffer = buffer;
    }
    
    @Override
    public synchronized void run() {
        this.gerar();
        this.mostrar();
    }
    
    /**
     * Realiza a geração dos valores a serem salvos no "buffer"
     */
    private void gerar() {
        Fibonacci fib = new Fibonacci();
        
        for (int i = 0; i < TAMANHO_BUFFER; i++) {
            if (this.buffer.size() <= TAMANHO_BUFFER) {
                this.buffer.add(fib.fibonacci(new Random().nextInt(TAMANHO_BUFFER * 5)));
            }
        }
    }
    
    /**
     * Exibe os valores gerados
     */
    private void mostrar() {
        for (int i = 0; i < this.buffer.size(); i++) {
            System.out.println("Valor " + this.buffer.get(i) + " na posição " + i);
        }
    }
}
