package recursos.temperaturas;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class TemperaturasVersionNueve {
    private int[] temperaturaMeses = new int[12];
    private Random temperaturaInicial = new Random();

    public void newTemperaturaMeses() {
        for (int i = 0; i < temperaturaMeses.length; i++) {
            switch (i) {
            case 11:
            case 12:
            case 0:
            case 1:
            case 2:
                this.temperaturaMeses[i] = this.temperaturaInicial.nextInt(31) - 10;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.temperaturaMeses[i] = this.temperaturaInicial.nextInt(31) + 10;
                break;
            default:
                this.temperaturaMeses[i] = -11;
            }
        }
    }

    public TemperaturasVersionNueve() {
        newTemperaturaMeses();
    }

    public int[] getTemperaturas() {
        return this.temperaturaMeses;
    }
    
    public float temperaturaMedia() {
        float media = 0;
        for (int i = 0; i < temperaturaMeses.length; i++) {
            media += temperaturaMeses[i];
        }
        media /= 12;
        return media;
    }

    public int getMesMasFrio() {
        int mes = -1;
        int tfria = 100;
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if(temperaturaMeses[i]< tfria){
                tfria = temperaturaMeses[i];
                mes = i;
            }
        }
        return mes;
    }

    public int getMesMasCaliente (){
        int mes = -1;
        int tcaliente = -20;
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if(temperaturaMeses[i]> tcaliente){
                tcaliente = temperaturaMeses[i];
                mes = i;
            }
        }
        return mes;
    }

    public List<Integer> mesesCalurosos() {
        List<Integer> mesesCalurosos = new ArrayList<Integer>();
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if (temperaturaMeses[i] > 30)
                mesesCalurosos.add(i);

        }
        return mesesCalurosos;
    }

    public boolean huboMesCaluroso() {
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if (temperaturaMeses[i] > 30)
                return true;
        }
        return false;
    }

    public boolean moveTempsRight (){
        int [] auxArr = new int [this.temperaturaMeses.length];
        auxArr[0] = this.temperaturaMeses[this.temperaturaMeses.length-1];
        for (int i = auxArr.length-1; i > 0; i--) {
            auxArr[i] = this.temperaturaMeses[i-1];
        }
        this.temperaturaMeses = auxArr;
        if(this.temperaturaMeses == auxArr)
            return true;
        else
            return false;
        
    }

    public boolean moveTempsLeft (){
        int [] auxArr = new int [this.temperaturaMeses.length];
        auxArr[auxArr.length-1] = this.temperaturaMeses[0];
        for (int i = 0; i < auxArr.length-1; i++) {
            auxArr[i] = this.temperaturaMeses[i+1];
        }
        this.temperaturaMeses = auxArr;
        if(this.temperaturaMeses == auxArr)
            return true;
        else
            return false;
    }

    public boolean plusThirty (){
        for (int i = 0; i < this.temperaturaMeses.length; i++) {
            if(this.temperaturaMeses[i] > 30)
                return true;
        }
        return false;
    }
}
