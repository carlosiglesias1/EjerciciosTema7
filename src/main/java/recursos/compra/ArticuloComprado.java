package recursos.compra;

public class ArticuloComprado extends Articulo {
    private int unidades;
    private float precioTotal;
    
    public ArticuloComprado (String codigo, String desc, float price, int unidades){
        super(codigo, desc, price);
        this.unidades = unidades;
        this.precioTotal = super.getPrecioUnitario() * this.unidades;
    }

    public int getUnidades() {
        return unidades;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
}
