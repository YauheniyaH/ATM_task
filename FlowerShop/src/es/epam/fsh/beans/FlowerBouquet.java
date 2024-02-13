package es.epam.fsh.beans;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class FlowerBouquet {

    private List<Flower> bouquet;



    public FlowerBouquet(){
        bouquet= new ArrayList<Flower>();
    }

    public Flower getFlower (int i){
        return bouquet.get(i);
    }

    public void add (Flower flower, int quantity){
        for (int i=0;i<quantity;i++){
            bouquet.add(flower);
        }

    }

    public void add (String flowerName, double price, String color ){
        bouquet.add(new Flower(flowerName, price, color));
    }

    public int size(){
        return bouquet.size();
    }

    public double bouquetPrice (){
        double sum=0;
        for(int i=0; i< bouquet.size();i++){
            sum=sum+bouquet.get(i).getPrice();
        }
        return sum;
    }
    public List<Flower> getBouquet (){
        return bouquet;
    }

    public boolean deleteFlower (Flower flower){
        return this.getBouquet().remove(flower);
    }

    @Override
    public String toString() {
        return "FlowerBouquet{" +
                "bouquet=" + bouquet +
                '}';
    }
}
