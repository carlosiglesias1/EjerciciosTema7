package ejercicios;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import recursos.parkings.Parking2;

/**
 * Realizar una clase llamada Parking2 que gestione los coches aparcados en un
 * parking mediante un Array, que almacene las matrículas y la hora de entrada
 * en el parking. El parking es un poco raro, mide solo 3 metros de ancho y
 * caben 20 coches, pero uno detrás de otro por lo que el último en entrar debe
 * ser el primero en salir (esta estructura se llama pila LIFO – Last Input,
 * First Output). Cada minuto en el parking cuesta 2 céntimos (máx 10 euros). La
 * clase debe tener métodos siguientes:  Mostrar el estado del parking, esto es
 * las matrículas/hora de entrada de las plazas ocupadas.  Aparcar: se le
 * pasará el número de matrícula. Devuelve número de plaza o cero si lleno. La
 * plaza del fondo es la número 1 y la que está más cerca de la entrada es la
 * 20.  Desaparcar: (¿hace falta pasarle algún parámetro?). Al desaparcar se
 * calcula el importe a pagar según los segundos de estancia. Devuelve la
 * matrícula del coche y el importe a pagar. Si es parking está vacío devuelve
 * cadena vacía y cero euros.  Mostrar lo recaudado hasta ese momento. Hacer un
 * programa con un menú que permita al usuario usar los métodos creados. No hay
 * que introducir a mano los valores de hora de entrada y salida en el parking,
 * se harán por el reloj del sistema.
 */
public class Ejercicio7 {
    static void promptMenu() {
        System.out.println("\nHola, qué quieres hacer?");
        System.out.println("p: Aparcar vehiculo");
        System.out.println("u: Sacar vehiculo");
        System.out.println("s: Estado del parking");
        System.out.println("e: salir");
    }

    static void showStatus(Parking2 parking) {
        DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        for (int i = 0; i < parking.getStatus().size(); i++) {
            System.out.print("[[" + parking.getStatus().get(i)[0] + "],[" + LocalTime.parse(parking.getStatus().get(i)[1]).format(dFormatter).toString() + "]] ");
        }
    }

    static void aparcar(String matricula, Parking2 parking) {
        if (parking.park(matricula) == 0)
            System.out.println("El parking está lleno");
        else
            System.out.println("Este coche está alojado en la plaza " + parking.getOccupiedPlaces());
        showStatus(parking);
    }

    static void sacarCoche(Parking2 parking) {
        System.out.println("Se ha eliminado la matricula " + parking.unPark() + " ahora queda(n) "
                + parking.getOccupiedPlaces() + " coche(s)");
        showStatus(parking);
    }

    public static void main(String[] args) {
        Parking2 parking = new Parking2();
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
