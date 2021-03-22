package ejercicios;

import java.util.Random;
import java.util.Scanner;

import recursos.primitiva.*;

/**
 * Realizar una clase Primitiva que tenga definido un Array privado de 6
 * elementos con el resultado de un sorteo de la primitiva (serán 6 enteros con
 * valores comprendidos entre 1 y 49 y sin repetidos). La clase dispondrá de un
 * constructor en el que se generan y almacenen esos números al azar, también
 * tendrá un método al que se le pase una combinación jugada como parámetro (no
 * necesariamente ordenada) y devuelva el número de aciertos. Realiza tres
 * programas distintos que usen esa clase: Programa que el usuario introduzca
 * los 6 números de su boleto y le diga cuantos acertó. Programa en el que se
 * generen 1000 boletos al azar y nos informe de cuantos boletos hay con 3, 4, 5
 * y 6 aciertos (a lo mejor es necesario crear un nuevo método en la clase
 * Primitiva para generar boletos al azar). Programa con un bucle que genere
 * boletos hasta que acierte los 6 números ¿Cuántos boletos has tenido que
 * crear?
 * 
 */

public class Ejercicio5 {

    static BoletoPrimitiva [] generarBoletos (BoletoPrimitiva boleto, int [] numeros, int entrada){
        BoletoPrimitiva [] boletosPrimitiva = new BoletoPrimitiva [1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < boleto.getLength(); j++) {
               boletosPrimitiva[i]=new BoletoPrimitiva (numeros, entrada); 
            }
        }
        return boletosPrimitiva;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random numero = new Random();
        
        teclado.close();
    }
}
