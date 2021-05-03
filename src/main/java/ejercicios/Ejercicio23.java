package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7.23. Realizar el programa que simule el comportamiento de una “cola” FIFO
 * con los nombres de pacientes que esperan en la consulta del médico. Tendrá un
 * menú con las siguientes opciones a) Llega un paciente (esto es, Introducir
 * elemento al final de la cola) b) Llamar al paciente para ser atendido (esto
 * es, sacar el primer elemento de la cola) mostrándolo por pantalla y c)
 * Mostrar el estado de la cola y d) salir de programa.
 */

public class Ejercicio23 {
    public static void main(String[] args) {
        ArrayList<String> pacientesList = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'a':
                    pacientesList.add(teclado.nextLine());
                    break;
                case 'b':
                    try {
                        pacientesList.remove(0);
                    } catch (Exception e) {
                        System.out.println("Algo ha salido mal: " + e);
                    }
                    break;
                case 'c':
                    for (int i = 0; i < pacientesList.size(); i++) {
                        System.out.println(pacientesList.get(i));
                    }
                    break;
                case 'e':
                    break;
                default:
                    System.out.println(
                            "Algo ha salido mal.\n'a': Añade un paciente\n'b': borra un paciente de la lista\n'c': muestra la lista de pacientes\n'e': sale del programa");
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
