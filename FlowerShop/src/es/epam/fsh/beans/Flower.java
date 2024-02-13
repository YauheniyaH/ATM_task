package es.epam.fsh.beans;

import java.io.Serializable;
import java.util.Objects;

public class Flower implements Serializable {
    private String name;
    private double price;
    private String color;


    public Flower () {
        this.name=null;
        this.price=0;
        this.color=null;

    }

    public Flower (String name, double price, String color){
        this.name=name;
        this.price= price;
        this.color=color;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower flower)) return false;
        return Double.compare(flower.price, price) == 0 && Objects.equals(name, flower.name) && Objects.equals(color, flower.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, color);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
