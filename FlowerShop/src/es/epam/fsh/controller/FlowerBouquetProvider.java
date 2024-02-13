package es.epam.fsh.controller;

import es.epam.fsh.beans.FlowerBouquet;

import java.util.ArrayList;
import java.util.List;

public class FlowerBouquetProvider {

    private static final FlowerBouquetProvider instance = new FlowerBouquetProvider();

    private List<FlowerBouquet> wh = new ArrayList<FlowerBouquet>();

    private FlowerBouquetProvider(){
        wh.add(new FlowerBouquet());
    }

    public FlowerBouquet getFlowerBouquet(int index){
        if(index>=wh.size()){
            throw new RuntimeException("error");
        }
        return wh.get(index);
    }

    public void addNewFlowerBouquet (FlowerBouquet newBouquet){
        wh.add(newBouquet);
    }

    public static FlowerBouquetProvider getInstance(){
        return instance;
    }

    public int whSize (){
        return this.wh.size();
    }
}
