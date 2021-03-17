package ejercicios;

import java.util.Random;

/**
 * 7.3. Realizar un programa que defina un Array con 10 elementos e introduzca
 * valores a azar entre 1 y 20. Al finalizar informar si tiene repetidos o no.
 */

public class Ejercicio3 {
    static Random numero = new Random();

    static void rellenarElementos (int [] elementos){
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = numero.nextInt(21)+1;
        }
    }

    static void mostrarElementos (int [] elementos){
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("["+elementos[i]+"]");
        }
    }

    static boolean tieneRepetidos (int [] elementos){
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos.length; j++) {
                if(elementos[i] == elementos[j] && i != j)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] elementos = new int [10];
        rellenarElementos(elementos);
        mostrarElementos(elementos);
        System.out.println();
        if (tieneRepetidos(elementos))
            System.out.println("El array tiene elementos repetidos");
        else
            System.out.println("El array no tiene elementos repetidos");
    }
}
