package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio16 {
    static void printArray (ArrayList <Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" "+list.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList <Integer> positivosList = new ArrayList<Integer>();
        ArrayList <Integer> negativosList = new ArrayList<Integer>();
        int numero;
        Scanner teclado = new Scanner (System.in);
        do {
            numero = teclado.nextInt();
            if(numero > 0)
                positivosList.add(numero);
            else if (numero<0)
                negativosList.add(numero);
        } while (numero != 0);
        System.out.println("Array de positivos");
        printArray(positivosList);
        System.out.println("\nArray de negativos");
        printArray(negativosList);
        teclado.close();
    }
}
