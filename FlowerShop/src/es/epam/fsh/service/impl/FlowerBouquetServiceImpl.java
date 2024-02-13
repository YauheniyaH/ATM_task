package es.epam.fsh.service.impl;

import es.epam.fsh.beans.Flower;
import es.epam.fsh.beans.FlowerBouquet;
import es.epam.fsh.controller.FlowerBouquetProvider;
import es.epam.fsh.service.FlowerBouquetService;

import java.util.concurrent.TimeoutException;

public class FlowerBouquetServiceImpl implements FlowerBouquetService {

    private FlowerBouquet bouquet;
    private static final FlowerBouquetProvider provider = FlowerBouquetProvider.getInstance();

    public FlowerBouquetServiceImpl(){
        this.bouquet=new FlowerBouquet();
        provider.addNewFlowerBouquet(bouquet);
    }
    @Override
    public void addFlowerToBouquet(String name, double price, String color) throws FlowerBouquetServiceExceptions {
        if (price<0){
            throw new FlowerBouquetServiceExceptions("price can not be negative number");
        } else {
            bouquet.add(name, price, color);
        }
    }

    public void addFlowerToBouquet (Flower flower, int quantity){
        bouquet.add(flower, quantity);
    }

    @Override
    public boolean deleteFlowerFromBouquet(Flower flower) {
        return (this.bouquet.deleteFlower(flower));
    }

    public boolean deleteFlowerFromBouquet(Flower flower, int quantity){
        boolean result = false;
        for (int i =0; i<quantity;i++){
            result=this.bouquet.deleteFlower(flower);
        }
        return result;
    }

    @Override
    public double calculatePrice( FlowerBouquet bouquet) {
        return bouquet.bouquetPrice();
    }

    public FlowerBouquet getBouquet() {

        return this.bouquet;
    }
}
