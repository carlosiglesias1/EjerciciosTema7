package recursos.facturas;

/**
 * Contienen:  Descripción del producto  Precio unitario  Cantidad de
 * unidades  Porcentaje de descuento: 5% para líneas con más de 10 unidades. 
 * Importe total de la línea.  Importe total: inicialmente cero, y se va
 * actualizando siempre que se añadan/eliminen líneas
 */

public class LineaFactura {
    private String description;
    private float precioUnitario;
    private int unidades;
    private float precioTotal;

    public LineaFactura(String description, float precio, int cantidad) {
        this.description = description;
        this.precioUnitario = precio;
        this.unidades = cantidad;
        this.precioTotal = precio * cantidad;
    }

    // getters
    public float getPrecioTotal() {
        return precioTotal;
    }

    public String getDescription() {
        return description;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public int getUnidades() {
        return unidades;
    }

    // funciones de clase
    public String toString() {
        return "[" + this.description + ", " + this.precioUnitario + " * " + this.unidades + " = " + this.precioTotal
                + "]";
    }
}
