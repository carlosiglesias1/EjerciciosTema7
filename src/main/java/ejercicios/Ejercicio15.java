package ejercicios;

import java.util.Scanner;

import recursos.AlturaAlumnos;

/**
 * 7.15. Realiza un programa que tenga un ArrayList llamado AlturaAlumnos que
 * mantenga una lista con las alturas de los alumnos de un centro. Serán valores
 * positivos entre 0,50 y 2,50 redondeados a dos decimales. El programa tendrá
 * las siguientes funciones (accesibles mediante un menú): a. Añadir altura. b.
 * Mostrar lista actual con el número de posición c. Eliminar por posición. Se
 * le pasa como parámetro una posición y elimina la altura en dicha posición. d.
 * Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las
 * posiciones en las que se encuentre dicha altura. Devuelve la cantidad de
 * eliminaciones. e. Ordenar la lista. f. Vaciar la lista.
 * 
 */

public class Ejercicio15 {
    static void printAlturas(AlturaAlumnos alturaAlumnos) {
        for (int i = 0; i < alturaAlumnos.getList().size(); i++) {
            System.out.println("[" + (i + 1) + " -> " + alturaAlumnos.getList().get(i) + "]");
        }
    }

    static void promptMenu() {
        System.out.println(
                "a: añadir altura\ns: mostrar lista\np: borrar la Posicion indicada\nt: borrar todas las ocurrencias de la alTura introducida"
                        + "\no: ordenar la lista\ne: salir");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        AlturaAlumnos alturaAlumnos = new AlturaAlumnos();
        char opcion;
        do {
            promptMenu();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'a':
                System.out.println("Introduce la altura");
                float añadir = Float.parseFloat(teclado.nextLine());
                if (alturaAlumnos.addAltura(añadir))
                    printAlturas(alturaAlumnos);
                else
                    System.out.println("Algo ha fallado");
                break;
            case 's':
                printAlturas(alturaAlumnos);
                break;
            case 'p':
                System.out.println("Introduce la posición");
                int position = Integer.parseInt(teclado.nextLine());
                if (alturaAlumnos.deleteAltura(position-1))
                    printAlturas(alturaAlumnos);
                else
                    System.out.println("No se ha podido eliminar la altura");
                break;
            case 't':
                System.out.println("Introduce el valor");
                float valor = Float.parseFloat(teclado.nextLine());
                System.out.println("Se han eliminado " + alturaAlumnos.deleteAltura(valor) + " alumnos");
                break;
            case 'o':
                alturaAlumnos.orderList();
                printAlturas(alturaAlumnos);
                break;
            case 'e':
                System.out.println();
                break;
            default:
                System.out.println("Algo ha fallado");
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
