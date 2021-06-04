package ejercicios;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 7.29. Realizar una clase llamada Parking3 que gestione los coches aparcados
 * en un parking mediante un ArrayList, que almacene las matrículas y la hora de
 * entrada en el parking. El parking es un poco raro, mide solo 3 metros de
 * ancho y caben 20 coches, pero uno detrás de otro por lo que el último en
 * entrar debe ser el primero en salir (esta estructura se llama pila LIFO –
 * Last Input, First Output). Cada minuto en el parking cuesta 2 céntimos (máx
 * 10 euros). La clase debe tener métodos siguientes:  Mostrar el estado del
 * parking, esto es las matrículas/hora de entrada de las plazas ocupadas. 
 * Aparcar: se le pasará el número de matrícula. Devuelve número de plaza o cero
 * si lleno. La plaza del fondo es la número 1 y la que está más cerca de la
 * entrada es la 20.  Desaparcar: (¿hace falta pasarle algún parámetro?). Al
 * desaparcar se calcula el importe a pagar según los segundos de estancia.
 * Devuelve el importe a pagar. Si es parking está vacío devuelve -1.  Mostrar
 * lo recaudado hasta ese momento. Hacer un programa con un menú que permita al
 * usuario usar los métodos creados. No hay que introducir a mano los valores de
 * hora de entrada y salida en el parking, se harán por el reloj del sistema
 */

public class Ejercicio29 {
    static final int PARKSIZE = 20;

    static void showParking(ArrayList<String[]> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i)[0] + ", " + list.get(i)[1] + "] ");
        }
        System.out.println();
    }

    static int park(ArrayList<String[]> list, String matricula) {
        if (list.size() < PARKSIZE) {
            list.add(new String[2]);
            list.get(list.size() - 1)[0] = matricula;
            list.get(list.size() - 1)[1] = LocalTime.now().toString();
            return list.size();
        } else {
            return 0;
        }
    }

    static String extract(ArrayList<String[]> list) throws Exception {
        LocalTime now = LocalTime.now();
        LocalTime entry = LocalTime.parse(list.get(0)[1]);
        float importe = (now.getHour() * 3600 + now.getMinute() * 60 + now.getSecond() - entry.getHour() * 3600
                - entry.getMinute() * 60 - entry.getSecond()) * 0.02f;
        list.remove(0);
        if (importe > 10f) {
            return "10";
        } else {
            return Float.toString(importe);
        }
    }

    public static void main(String[] args) {
        ArrayList<String[]> parkingList = new ArrayList<String[]>();
        char opcion;
        Scanner teclado = new Scanner(System.in);
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'p':
                    park(parkingList, teclado.nextLine());
                    break;
                case 'v':
                    showParking(parkingList);
                    break;
                case 'e':
                    try {
                        System.out.println("El parking ha costado " + extract(parkingList));   
                    } catch (Exception e) {
                        System.out.println("Algo ha ocurrido: "+e);
                    }
                    break;
                case 's':
                    break;
                default:
                    opcion = 'v';
                    System.out.println("Opción equivocada");
                    break;
            }
        } while (opcion != 's');
        teclado.close();
    }
}
