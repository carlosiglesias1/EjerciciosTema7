package recursos.facturas;

import java.time.LocalDate;
import java.util.ArrayList;

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

public class Factura {
    private String numberDoc;
    private LocalDate date;
    private String numberCli;
    private final float IVA = 0.21f;
    private ArrayList<LineaFactura> lineasFactura;
    private float importeFactura;

    // constructor
    public Factura(String number, String numberCli) {
        this.numberDoc = number;
        this.date = LocalDate.now();
        this.numberCli = numberCli;
        this.lineasFactura = new ArrayList<LineaFactura>();
        this.importeFactura = 0f;
    }

    // getters
    public float getImporteFactura() {
        return importeFactura;
    }

    public ArrayList<LineaFactura> getLineasFactura() {
        return lineasFactura;
    }

    public String getNumberCli() {
        return numberCli;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    // métodos de interacción de la clase
    public boolean addLine(String description, float precio, int cantidad) {
        try {
            LineaFactura newLine = new LineaFactura(description, precio, cantidad);
            if (this.lineasFactura.add(newLine)) {
                importeFactura += this.lineasFactura.get(this.lineasFactura.size() - 1).getPrecioTotal();
                return true;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean rmLine(int position) {
        try {
            this.importeFactura -= this.lineasFactura.get(position).getPrecioTotal();
            return this.lineasFactura.remove(this.lineasFactura.get(position));
        } catch (Exception e) {
            return false;
        }
    }

}
