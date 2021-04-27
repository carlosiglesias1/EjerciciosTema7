package recursos.compra;

import java.util.ArrayList;

public class Carrito2 {
    private ArrayList<ArticuloComprado> carritoList;
    private float totalCompra;

    public Carrito2() {
        this.carritoList = new ArrayList<ArticuloComprado>();
        this.totalCompra = 0;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public ArrayList<ArticuloComprado> getCarritoList() {
        return carritoList;
    }

    public boolean addProduct (ArticuloComprado aComprado){
        try {
            this.totalCompra += aComprado.getPrecioTotal();
            this.carritoList.add(aComprado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void emptyChart (){
        this.carritoList.clear();
    }

    public boolean rmProduct (String codeString){
        if (locateItem(codeString)==-1)
            return false;
        try {
            this.totalCompra-=this.carritoList.get(locateItem(codeString)).getPrecioTotal();
            this.carritoList.remove(locateItem(codeString));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private int locateItem (String codeString){
        for (int i = 0; i < this.carritoList.size(); i++) {
            if(this.carritoList.get(i).getCodigo().equals(codeString))
                return i;
        }
        return -1;
    }
}
