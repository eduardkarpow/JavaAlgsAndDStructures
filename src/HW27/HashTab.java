package HW27;

import java.util.HashMap;

public class HashTab {
    public static void main(String[] args) {


    }
}
class Hashtab{
    private HashMap<String, Integer> hashTab;
    public void hashTabInit(){
        this.hashTab = new HashMap<>();
    }
    public void hashTabAdd(String key, int value){
        this.hashTab.put(key,value);

    }
    public int hashTabLookup(String key){
        return this.hashTab.get(key);
    }
    public int hashTabDelete(String key){
        return this.hashTab.remove(key);
    }
}
