package HW20;

import java.io.Serializable;

public class GenericsTester {
    public static void main(String[] args) {
        GenericClass<String, Integer, String> gen = new GenericClass<String,Integer, String>("123", "23", 241);
        gen.printClassesOfGenerics();

    }
}
class Animal<K>{

}
class GenericClass<T,V,K> extends Animal<K> implements Comparable<T>, Serializable {
    private T species;
    private K key;
    private V value;

    public GenericClass(T species, K key, V value) {
        this.species = species;
        this.key = key;
        this.value = value;
    }

    public T getSpecies() {
        return species;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public void printClassesOfGenerics(){
        System.out.println("species: " + this.species.getClass() + " value: " + this.value.getClass() + " key: "+this.key.getClass());
    }
    @Override
    public int compareTo(T o){
        return 123;
    }
}