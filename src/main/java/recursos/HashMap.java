package recursos;

import java.util.Map;
import java.util.TreeMap;

public class HashMap {
    private Map<String, String> map = new TreeMap<String,String>();
    public HashMap (){
        this.map.put("Marta", "666111222");
        this.map.put("Miguel", "981981981");
        this.map.put("Ana", "900900900");
        this.map.put("Daniel", "+34881000001");
    }

    public Map<String, String> getMap() {
        return map;
    }    
}
