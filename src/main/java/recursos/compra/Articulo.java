package recursos.compra;

public class Articulo {
    private String codigo;
    private String descripcion;
    private float precioUnitario;

    public Articulo(String codigo, String desc, float price) {
        this.codigo = codigo;
        this.descripcion = desc;
        this.precioUnitario = price;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }
}
