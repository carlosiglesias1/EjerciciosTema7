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
            if(temperaturaMeses[i]< tfria)
                mes = i;
        }
        return mes;
    }

    public int getMesMasCaliente (){
        int mes = -1;
        int tcaliente = -20;
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if(temperaturaMeses[i]> tcaliente)
                mes = i;
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
}
