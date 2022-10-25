package org.example;

public class Boisson implements Comparable {
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boisson() {
    }

    public Boisson(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    // NB : la classe implemente une interface !
    // Sert pour le tri (voir le stream().sorted(Boisson::compareTo).map(Boisson::getName).toList() de la classe UtilBoisson
    @Override
    public int compareTo(Object o) {
        Boisson o1 = (Boisson) o;
        return this.name.compareTo(o1.name);
    }
}
