package es.epam.fsh.main;

import es.epam.fsh.beans.Flower;
import es.epam.fsh.beans.FlowerBouquet;
import es.epam.fsh.dao.impl.FlowerDAOException;
import es.epam.fsh.dao.impl.FlowerDAOImpl;
import es.epam.fsh.service.impl.FlowerBouquetServiceExceptions;
import es.epam.fsh.service.impl.FlowerBouquetServiceImpl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws FlowerBouquetServiceExceptions, IOException, FlowerDAOException {
        FlowerBouquetServiceImpl florist = new FlowerBouquetServiceImpl();

        FlowerDAOImpl input = new FlowerDAOImpl();

        Flower whiteRose = new Flower("Rose", 7.5, "white");
        Flower redRose = new Flower ( "Rose", 4, "red");
        Flower orchid = new Flower ("Orchid", 11.2, "multi");
        Flower camomile = new Flower ( "Camomile", 2.9, "white");

        System.out.println(florist.calculatePrice(florist.getBouquet()));

     // need to throw custom exception for negative price. Handled in FlowerBouquetServiceImpl
        florist.addFlowerToBouquet("apple", 2, "blue");;

        florist.addFlowerToBouquet(whiteRose, 2);
        florist.addFlowerToBouquet(camomile, 2);
        florist.deleteFlowerFromBouquet(camomile);

     // Throw custom exception if try to remove more flowers than exist in bouquet
//        if(florist.deleteFlowerFromBouquet(whiteRose,3)==false){
//            throw new FlowerBouquetServiceExceptions("there is no sufficient number of this flowers in bouquet"+whiteRose.toString());
//        }
        florist.deleteFlowerFromBouquet(whiteRose,3);

     //   Throwing custom exception if trying to delete unexciting flower from bouquet
//        if(florist.deleteFlowerFromBouquet(orchid)==false){
//            throw new FlowerBouquetServiceExceptions("this flower does not exist in current bouquet"+orchid.toString());
//        }

        System.out.println(florist.getBouquet().bouquetPrice());
        System.out.println(florist.getBouquet().size());
      try {
          Flower fromConsole = input.inputFlowerData();
          florist.addFlowerToBouquet(fromConsole,1);
          System.out.println(fromConsole);
      }catch(IOException e){
          throw new FlowerDAOException(e);
      } catch (Exception e) {
          throw new FlowerDAOException(e);
      }

        System.out.println(florist.getBouquet().toString());

        FlowerBouquet bouquetFromCSV = input.createBouquetFromCSV("resources/bouquet_01.csv");

        System.out.println(bouquetFromCSV.toString());

    }
}