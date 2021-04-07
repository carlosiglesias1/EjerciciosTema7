package ejercicios;

import java.util.Scanner;

import recursos.parkings.Parking;

/**
 * 7.6. Realizar una clase llamada Parking que gestione los coches aparcados en
 * un parking mediante un Array que almacene las matrículas. El parking es un
 * poco raro, mide solo 3 metros de ancho y caben 20 coches, pero uno detrás de
 * otro por lo que el último en entrar debe ser el primero en salir (esta
 * estructura se llama pila LIFO – Last Input, First Output ). La clase debe
 * tener métodos siguientes: a. Mostrar el estado del parking, esto es las
 * matrículas de las plazas ocupadas. b. Aparcar: se le pasará el número de
 * matrícula. Devuelve número de plaza o cero si lleno. La plaza del fondo es la
 * número 1 y la que está más cerca de la entrada es la 20. c. Desaparcar:
 * (¿hace falta pasarle algún parámetro?). Devuelve la matrícula del coche a
 * desaparcar o bien una cadena vacía si el parking está vacío. d. Mostrar la
 * cantidad de plazas libres en ese momento.
 */

public class Ejercicio6 {
    static void promptMenu() {
        System.out.println("\nHola, qué quieres hacer?");
        System.out.println("p: Aparcar vehiculo");
        System.out.println("u: Sacar vehiculo");
        System.out.println("s: Estado del parking");
        System.out.println("e: salir");
    }

    static void showStatus(Parking parking) {
        for (int i = 0; i < parking.getStatus().length; i++) {
            System.out.print("[" + parking.getStatus()[i].toString() + "]");
        }
    }

    static void aparcar(String matricula, Parking parking) {
        if (parking.park(matricula) == 0)
            System.out.println("El parking está lleno");
        else
            System.out.println("Este coche está alojado en la plaza " + parking.getOccupiedPlaces());
        showStatus(parking);
    }

    static void sacarCoche(Parking parking) {
        System.out.println("Se ha eliminado la matricula " + parking.unPark() + " ahora queda(n) "
                + parking.getOccupiedPlaces() + " coche(s)");
        showStatus(parking);
    }

    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            promptMenu();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'p':
                System.out.print("Introduce la matrícula: ");
                aparcar(teclado.nextLine(), parking);
                break;
            case 'u':
                sacarCoche(parking);
                break;
            case 's':
                showStatus(parking);
                break;
            case 'e':
                System.out.println("Has finalizado");
                break;
            default:
                System.out.println("Comando erróneo");
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
