package ejercicios;

import java.util.ArrayList;
import java.util.Random;

/**
 * 7.24. Realizar un programa con una función a la que se le pasan dos ArrayList
 * de enteros como parámetros y nos devuelva true si los dos ArrayList tienen
 * los mismos elementos, aunque sean en otro orden, y devuelva false en caso
 * contrario (suponemos que no tienen valores repetidos).
 */
public class Ejercicio24 {
    static void inicializarListas(ArrayList<Integer> list, Random random, int size) {
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(20));
        }
    }

    static boolean sameElements(ArrayList<Integer> list0, ArrayList<Integer> list1) {
        if (list0.size() != list1.size())
            return false;
        else {
            for (int i = 0; i < list0.size(); i++) {
                if(!list0.contains(list1.get(i)))
                    return false;
            }
            return true;
        }
    }

    static void printLists (ArrayList <Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print("["+list.get(i)+"] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> enterosList0 = new ArrayList<Integer>();
        ArrayList<Integer> enterosList1 = new ArrayList<Integer>();
        Random random = new Random();
        int size = random.nextInt(10) + 1;
        inicializarListas(enterosList0, random, size);
        printLists(enterosList0);
        inicializarListas(enterosList1, random, size);
        printLists(enterosList1);
        if(sameElements(enterosList0, enterosList1))
            System.out.println("Tienen los mismos elementos");
        else
            System.out.println("No tienen los mismos elementos");
    }
}
