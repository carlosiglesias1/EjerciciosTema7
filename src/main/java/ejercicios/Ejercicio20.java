package ejercicios;

import java.util.Scanner;

import recursos.facturas.Factura;

/**
 * 7.20. Diseñar una clase Factura que consta de:  Número identificador: lo
 * proporciona el usuario en el alta de la factura.  Fecha de la factura: la
 * toma del sistema en el momento del alta.  Número de cliente: : lo
 * proporciona el usuario en el alta de la factura.  Porcentaje de IVA: 21%
 * para todas las facturas.  Un número indeterminado de lineaFactura que
 * contienen:  Descripción del producto  Precio unitario  Cantidad de
 * unidades  Porcentaje de descuento: 5% para líneas con más de 10 unidades. 
 * Importe total de la línea.  Importe total: inicialmente cero, y se va
 * actualizando siempre que se añadan/eliminen líneas. Implementar la clase con
 * su constructor y métodos para añadir línea de factura, eliminar línea de
 * factura y mostrar la factura por consola. Te hará falta una clase
 * lineaFactura con su constructor. Para añadir línea de factura, habrá que
 * solicitar al usuario los campos necesarios para añadirlo (descripción, precio
 * unitario y cantidad de unidades). Para eliminar una línea, solicitaremos el
 * número de línea. Hacer también un programa con un menú para gestionar una
 * factura (alta, añadir/eliminar líneas, mostrar factura) Nota: pensar en
 * método toString() para líneaFactura.
 */

public class Ejercicio20 {
    static void promptFactura() {
        System.out.println(
                "Pulsa 'a' para añadir líneas a la factura\nPulsa 'b' para borrar una línea\nPulsa 's' para salir");
    }

    static void printLines(Factura factura) {
        for (int i = 0; i < factura.getLineasFactura().size(); i++) {
            System.out.println(i + ": " + factura.getLineasFactura().get(i).toString());
        }
    }

    public static void main(String[] args) {
        Factura factura = new Factura("08647", "06789");
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            promptFactura();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'a':
                System.out.println("Introduce una descripcion del producto: ");
                String description = teclado.nextLine();
                System.out.println("Introduce el precio: ");
                float precio = Float.parseFloat(teclado.nextLine());
                System.out.println("Introduce las unidades: ");
                int unidades = Integer.parseInt(teclado.nextLine());
                if (factura.addLine(description, precio, unidades))
                    printLines(factura);
                else
                    System.out.println("La línea no se ha podido añadir");
                break;
            case 'b':
                System.out.println("Qué posición vas a eliminar?");
                printLines(factura);
                int position = Integer.parseInt(teclado.nextLine());
                if (factura.rmLine(position))
                    printLines(factura);
                else
                    System.out.println("La línea no se ha podido borrar");
                break;
            case 's':
                float total = factura.getImporteFactura() + factura.getImporteFactura() * 0.21f;
                System.out.printf("El precio de esta factura es de %.2f€ + el 21%% de iva (%.2f€) = %.2f€",
                        factura.getImporteFactura(), factura.getImporteFactura() * 0.21f, total);
                break;
            default:
                System.out.println("Algo no ha ido como debía");
                break;
            }
        } while (opcion != 's');
        teclado.close();
    }
}
