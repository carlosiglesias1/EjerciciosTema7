package ejercicios;

import java.util.ArrayList;
import java.util.Random;

/**
 * 7.10. Realizar un programa que tenga una función a la que se le pasa un Array
 * con las edades de los alumnos de una clase y nos devuelva la edad media.
 * Añadir una función a la que se le pasa un Array con las edades de los alumnos
 * y nos devuelva un Array solo con los mayores de edad.
 */

public class Ejercicio10 {
    static void rellenarLoco(int[] edad, Random random) {
        for (int i = 0; i < edad.length; i++) {
            edad[i] = random.nextInt(25) + 10;
        }
    }

    static void rellenarNormal(int[] edad, Random random) {
        for (int i = 0; i < edad.length; i++) {
            edad[i] = random.nextInt(2) + 11;
        }
    }

    static void verArray(int[] edad) {
        for (int i = 0; i < edad.length; i++) {
            System.out.print(edad[i] + " ");
        }
        System.out.println();
    }

    static float avgAge(int[] edad) {
        float average = 0;
        for (int i = 0; i < edad.length; i++) {
            average += edad[i];
        }
        return average / edad.length;
    }

    static boolean isThereAnAdult(int[] edades) {
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] > 18)
                return true;
        }
        return false;
    }

    static int [] adultArray (int [] edades){
        ArrayList <Integer> adultList = new ArrayList<Integer>();
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] > 18)
                adultList.add(edades[i]);
        }
        int[] noTeens = new int [adultList.size()];
        for (int i = 0; i < noTeens.length; i++) {
            noTeens[i] = adultList.get(i);
        }
        return noTeens;
    }

    public static void main(String[] args) {
        int[] edades = new int[10];
        Random random = new Random();
        rellenarNormal(edades, random);
        System.out.println();
        verArray(edades);
        System.out.printf("Edad media: %.2f\n", avgAge(edades));
        if (isThereAnAdult(edades))
            System.out.println("Hay un adulto entre estos bebés");
        else
            System.out.println("Todos son bebés");
        // En el rellenar loco tenemos una edad mínima de 10 años y una máxima de 35
        rellenarLoco(edades, random);
        verArray(edades);
        System.out.printf("Edad media: %.2f\n", avgAge(edades));
        if (isThereAnAdult(edades)){
            int [] noTeens = adultArray(edades);
            System.out.println("Hay "+noTeens.length+" adulto(s) entre estos bebés");
            verArray(noTeens);
        }
        else
            System.out.println("Todos son bebés");

    }
}
