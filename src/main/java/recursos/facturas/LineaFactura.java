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
}
