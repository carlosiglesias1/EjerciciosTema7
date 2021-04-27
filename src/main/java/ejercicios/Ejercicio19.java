package ejercicios;

import java.util.Scanner;

import recursos.compra.ArticuloComprado;
import recursos.compra.Carrito2;

/**
 * 7.19. Realizar una clase Carrito22 que mantenga las compras realizadas por un
 * cliente en un ArrayList. Cada posición del ArrayList contendrá el código del
 * producto, la descripción, el precio unitario y la cantidad de unidades
 * compradas y el precio total de ese producto (cantidad x precio unitario). Se
 * permite comprar un número indeterminado de artículos. Además de la lista de
 * productos, la clase tiene el importe total de la compra, que debe estar
 * siempre actualizado. Necesitamos los métodos: a) Mostrar por consola el
 * estado actual del carrito. b) Vaciar carrito. c) Añadir producto. d) Eliminar
 * producto (se le pasa el código de producto) y lo elimina físicamente del
 * ArrayList. Hacer un programa con un menú que permita al usuario operar con el
 * carrito de la compra.
 */

public class Ejercicio19 {
    static void showStatus(Carrito2 compra) {
        for (int i = 0; i < compra.getCarritoList().size(); i++) {
            System.out.print("[" + compra.getCarritoList().get(i).getCodigo() + ", "
                    + compra.getCarritoList().get(i).getDescripcion() + ", "
                    + compra.getCarritoList().get(i).getPrecioTotal() + "] ");
        }
        System.out.println();
    }

    static void comprar(ArticuloComprado aComprado, Carrito2 compra) {
        if (compra.addProduct(aComprado)) {
            System.out.println("Producto añadido");
            showStatus(compra);
        } else
            System.out.println("Ha ocurrido algo inesperado");
    }

    static void eliminar(String codigo, Carrito2 compra) {
        if (!compra.rmProduct(codigo))
            System.out.println("No se ha podido eliminar el producto, inténtalo de nuevo");
        else
            System.out.println("Producto eliminado correctamente");
    }

    static void promptMenu() {
        System.out.println("\nHola, bienvenido a tu lista de la compra");
        System.out.println("Pulsa 'c' para comprar");
        System.out.println("Pulsa 'b' para borrar");
        System.out.println("Pulsa 'v' para ver");
        System.out.println("Pulsa 'e' para salir");
    }

    public static void main(String[] args) {
        Carrito2 Carrito2 = new Carrito2();
        Scanner teclado = new Scanner(System.in);
        String code = "";
        char opcion;
        do {
            promptMenu();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'c':
                System.out.println("Introduce el código del producto");
                code = teclado.nextLine();
                System.out.println("Introduce la descripcion del producto");
                String desc = teclado.nextLine();
                System.out.println("Introduce el precio unitario");
                float precioUnidad = Float.parseFloat(teclado.nextLine());
                System.out.println("Introduce las unidades");
                int unidades = Integer.parseInt(teclado.nextLine());
                comprar(new ArticuloComprado(code, desc, precioUnidad, unidades), Carrito2);
                break;
            case 'b':
                System.out.println("Introduce el código del artículo que quieres borrar");
                code = teclado.nextLine();
                Carrito2.rmProduct(code);
                break;
            case 'v':
                showStatus(Carrito2);
                break;
            case 'e':
                System.out.printf("El precio total de esta compra es de %.2f euros\n", Carrito2.getTotalCompra());
                System.out.println("Adiós, vuelva pronto");
                break;
            default:
                break;
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
