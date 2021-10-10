package Atividade2;

import java.util.ArrayList;

public class ArrayThread extends Thread {
    
    private ArrayList<Integer> array;
    
    private static boolean achou = false;
    
    private final int valor;  
    private final int inicio;
    private final int fim;

    /**
     * @param array
     * @param valor  - valor a ser buscado (posição do array).
     * @param inicio - posição na qual a Thread começará a fazer a busca do valor.
     * @param fim    - posição na qual a Thread finalizará a busca do valor.
     */
    public ArrayThread(ArrayList<Integer> array, int valor, int inicio, int fim) {
        this.array  = array;
        this.valor  = valor;
        this.inicio = inicio;
        this.fim    = fim;
    }
    
    @Override
    public synchronized void run() {
        if (achou) {
            this.interrupt();
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + this.busca());
        }      
    }
    
    /**
     * Realiza a busca do valor informado no array.
     */
    private int busca() {
        for (int i = inicio; i < fim; i++) {
            if (achou) {
                this.interrupt();
            }
            if (this.array.get(i) == this.valor) {
                achou = true;
                return i;
            }
        }
        return -1;
    }
    
}
