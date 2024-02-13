package es.epam.fsh.dao;

import es.epam.fsh.beans.Flower;
import es.epam.fsh.beans.FlowerBouquet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FlowerDAO {

    public List<Flower> find( String color);
    public List<Flower> find( Double price);
   List<Flower> find(double startPrice, double endPrice);

    public Flower inputFlowerData() throws IOException;

    public FlowerBouquet createBouquetFromCSV (String filename) throws IOException;
}
