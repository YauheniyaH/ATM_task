package es.epam.fsh.service;

import es.epam.fsh.beans.Flower;
import es.epam.fsh.beans.FlowerBouquet;
import es.epam.fsh.service.impl.FlowerBouquetServiceExceptions;

public interface FlowerBouquetService {
    public void addFlowerToBouquet (String name, double price, String color) throws FlowerBouquetServiceExceptions;
    public void addFlowerToBouquet (Flower flower, int quantity);

    public boolean deleteFlowerFromBouquet( Flower flower);

    public double calculatePrice (FlowerBouquet bouquet);
}
