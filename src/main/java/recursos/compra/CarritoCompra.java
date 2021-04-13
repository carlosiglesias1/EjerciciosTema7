package recursos.compra;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private ArticuloComprado[] carrito;
    private float totalCompra;
    private int head;

    public CarritoCompra() {
        this.carrito = new ArticuloComprado[100];
        this.totalCompra = 0f;
        this.head = 0;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public List<ArticuloComprado> getCarrito() {
        ArrayList<ArticuloComprado> list = new ArrayList<ArticuloComprado>();
        for (int i = 0; i < this.head; i++) {
            list.add(this.carrito[i]);
        }
        return list;
    }

    public boolean addProduct(ArticuloComprado aComprado) {
        if (this.head < 100) {
            this.carrito[this.head] = aComprado;
            this.totalCompra += aComprado.getPrecioTotal();
            this.head++;
            return true;
        } else {
            return false;
        }
    }

    private int searchComprado(String codigo) {
        for (int i = 0; i < this.head; i++) {
            if (this.carrito[i].getCodigo().equals(codigo))
                return i;
        }
        return -1;
    }

    public boolean rmProduct(String codigo) {
        int searchResult = searchComprado(codigo);
        if (this.head == 0 || searchResult == -1) {
            return false;
        } else {
            for (int i = searchResult; i < this.head; i++) {
                this.carrito[i] = this.carrito[i+1];
            }
            return true;
        }
    }
}
