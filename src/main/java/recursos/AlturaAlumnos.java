package recursos;

import java.util.ArrayList;

public class AlturaAlumnos {
    private ArrayList<Float> list;

    public AlturaAlumnos() {
        this.list = new ArrayList<Float>();
    }

    public boolean addAltura(float i) {
        if (i > 2.5 || i < 0.5)
            return false;
        else {
            try {
                this.list.add(i);
                return true;
            } catch (Exception fail) {
                return false;
            }
        }
    }

    public ArrayList<Float> getList() {
        return list;
    }

    public boolean deleteAltura(int index) {
        try {
            this.list.remove(index);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public int deleteAltura(float objext) {
        int counter = 0;
        while (this.list.remove(objext)) {
            counter++;
        }
        return counter;
    }

    public void orderList() {
        float aux = 0f;
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < this.list.size(); j++) {
                if (this.list.get(i) > this.list.get(j)) {
                    aux = this.list.get(i);
                    this.list.set(i, this.list.get(j));
                    this.list.set(j, aux);
                }
            }
        }
    }

    public void emptyList (){
        this.list.clear();
    }
}
