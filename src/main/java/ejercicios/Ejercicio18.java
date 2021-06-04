package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7.18. Realizar un programa que tenga una función a la que se le pasa un
 * entero y devuelva un ArrayList con todos sus divisores.
 * 
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> divisoresList = new ArrayList<Integer>();
        int numero;
        numero = teclado.nextInt();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisoresList.add(i);
            }
        }
        for (int i = 0; i < divisoresList.size(); i++) {
            System.out.println(divisoresList.get(i));
        }
        teclado.close();
    }
}
