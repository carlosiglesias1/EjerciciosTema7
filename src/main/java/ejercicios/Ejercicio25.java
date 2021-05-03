package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7.25. Realizar una programa con un ArrayList bidimensional llamado
 * edadesAlumnos en el que cada fila representa cada aula y cada columna los
 * alumnos dentro del aula. El programa solicitará por teclado las edades de los
 * alumnos (si se introduce 0 quiere decir que se acabó con esa clase y se pasa
 * a la siguiente y si se introduce -1 finaliza el programa). Una vez
 * introducidos todos los valores, mostrar todas las edades introducidas (cada
 * aula en una fila).
 */

public class Ejercicio25 {
    
    static void printMulti(ArrayList <ArrayList<Integer>> mList){
        for (int i = 0; i < mList.size(); i++) {
            System.out.println("Clase : "+(i+1));
            for (int j = 0; j < mList.get(i).size(); j++) {
                System.out.print("["+mList.get(i).get(j)+"] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edadesAlumnos = new ArrayList<ArrayList<Integer>>();
        int edad;
        int count = 0;
        Scanner teclado = new Scanner(System.in);
        edadesAlumnos.add(new ArrayList<Integer>());
        do {
            edad = teclado.nextInt();
            if (edad == 0) {
                edadesAlumnos.add(new ArrayList<Integer>());
                count++;
            } else
                edadesAlumnos.get(count).add(edad);
        } while (edad != -1);
        printMulti(edadesAlumnos);
        teclado.close();
    }
}
