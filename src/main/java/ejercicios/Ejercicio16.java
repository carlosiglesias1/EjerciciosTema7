package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7.16. Realizar un programa al que se le vayan introduciendo por teclado
 * números enteros. El programa dispone de dos ArrayList, uno llamado positivos
 * y otro negativos. Se trata de meter los números introducidos en uno u otro
 * según su signo hasta que finalice el programa (esto ocurrirá cuando se
 * introduzca cero). Al finalizar, mostrará la media aritmética de cada
 * ArrayList.
 */

public class Ejercicio16 {
    static float average(ArrayList<Integer> list) {
        float average = 0;
        for (int i = 0; i < list.size(); i++) {
            average += list.get(i);
        }
        return average / list.size();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int aux;
        ArrayList<Integer> positiveList = new ArrayList<Integer>();
        ArrayList<Integer> negativeList = new ArrayList<Integer>();
        do {
            aux = teclado.nextInt();
            if (aux > 0)
                positiveList.add(aux);
            if (aux < 0)
                negativeList.add(aux);
        } while (aux != 0);
        System.out.println("La media de los numeros positivos es: " + average(positiveList));
        System.out.println("La media de los números negativos es: " + average(negativeList));
        teclado.close();
    }
}
