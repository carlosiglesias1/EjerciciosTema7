package ejercicios;

/**
 * 7.16. Realizar un programa al que se le vayan introduciendo por teclado números enteros.
El programa dispone de dos ArrayList, uno llamado positivos y otro negativos. Se trata
de meter los números introducidos en uno u otro según su signo hasta que finalice el
programa (esto ocurrirá cuando se introduzca cero). Al finalizar, mostrará la media
aritmética de cada ArrayList.

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio16 {
    static void printList (ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> positivoList = new ArrayList<Integer>();
        ArrayList<Integer> negativosList = new ArrayList<Integer>();
        Scanner teclado = new Scanner(System.in);
        int numero;
        do{
            numero = teclado.nextInt();
            if(numero > 0)
                positivoList.add(numero);
            else if (numero < 0)
                negativosList.add(numero);
        }while(numero == 0);
        printList(positivoList);
        printList(negativosList);
        teclado.close();
    }
}
