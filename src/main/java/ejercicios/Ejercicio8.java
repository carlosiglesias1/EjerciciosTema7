package ejercicios;

import java.util.Scanner;

import recursos.compra.*;

/**
 * 7.8. Realizar una clase carritoCompra que mantenga las compras realizadas por
 * un cliente en un Array. Cada posición del Array contendrá el código del
 * producto, la descripción, el precio unitario y la cantidad de unidades
 * compradas y el precio total de ese producto (cantidad x precio unitario). Se
 * permite comprar como máximo de 100 artículos diferentes. Además de la lista
 * de productos, la clase tiene el importe total de la compra, que debe estar
 * siempre actualizado. Necesitamos los métodos: a. Mostrar por consola el
 * estado actual del carrito. b. Añadir producto. c. Eliminar producto (se le
 * pasa el código de producto) y se le marcará de alguna forma que ese producto
 * está anulado (eliminarlo físicamente sería lioso, habría que desplazar todos
 * los productos a la derecha en el Array para cubrir el hueco dejado por el
 * elemento borrado. Hacer un programa con un menú que permita al usuario operar
 * con el carrito de la compra. Nota: Pensar en crear un método .toString() para
 * facilitar el mostrar por pantalla cada producto comprado.
 */

public class Ejercicio8 {

    static void showStatus(CarritoCompra compra) {
        for (int i = 0; i < compra.getCarrito().size(); i++) {
            System.out.print(
                    "[" + compra.getCarrito().get(i).getCodigo() + ", " + compra.getCarrito().get(i).getDescripcion()
                            + ", " + compra.getCarrito().get(i).getPrecioTotal() + "] ");
        }
        System.out.println();
    }

    static void comprar(ArticuloComprado aComprado, CarritoCompra compra) {
        if (compra.addProduct(aComprado)) {
            System.out.println("Producto añadido");
            showStatus(compra);
        } else
            System.out.println("Ha ocurrido algo inesperado");
    }

    static void eliminar(String codigo, CarritoCompra compra) {
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
        CarritoCompra carritoCompra = new CarritoCompra();
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
                comprar(new ArticuloComprado(code, desc, precioUnidad, unidades), carritoCompra);
                break;
            case 'b':
                System.out.println("Introduce el código del artículo que quieres borrar");
                code = teclado.nextLine();
                carritoCompra.rmProduct(code);
                break;
            case 'v':
                showStatus(carritoCompra);
                break;
            case 'e':
                System.out.printf("El precio total de esta compra es de %.2f euros\n", carritoCompra.getTotalCompra());
                System.out.println("Adiós, vuelva pronto");
                break;
            default:
                break;
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
