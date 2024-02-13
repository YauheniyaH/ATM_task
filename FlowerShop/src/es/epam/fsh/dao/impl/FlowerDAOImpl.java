package es.epam.fsh.dao.impl;

import es.epam.fsh.beans.Flower;
import es.epam.fsh.beans.FlowerBouquet;
import es.epam.fsh.dao.FlowerDAO;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FlowerDAOImpl implements FlowerDAO {

    private FlowerBouquet bouquet;

    @Override
    public List<Flower> find(String color) {

        return null;
    }

    @Override
    public List<Flower> find(Double price) {
        return null;
    }

    @Override
    public List<Flower> find(double startPrice, double endPrice) {
        return null;
    }

    @Override
    public Flower inputFlowerData() throws IOException {
       // Flower fl;
        Scanner sc;
        sc= new Scanner(System.in);
        System.out.println("Input flower name , please");
        String name = sc.nextLine();
        System.out.println("Input flower price , please");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Input flower color , please");
        String color = sc.nextLine();
        return new Flower(name, price, color);
    }

    @Override
    public FlowerBouquet createBouquetFromCSV(String filename) throws IOException {
        FlowerBouquet result = new FlowerBouquet();
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

        try{
            String line;
            // Run through following lines
            while((line=br.readLine())!=null){
                String[] items = line.split(",");
                try{

                    // If there are too many entries, throw a dummy exception, if
                    // there are too few, the same exception will be thrown later
                    if (items.length>3) throw new ArrayIndexOutOfBoundsException();
                    // Convert data to person record
                    Flower flower = new Flower(items[0],Double.parseDouble(items[1]),items[2]);
                    result.add(flower,1);
                } catch (ArrayIndexOutOfBoundsException|NumberFormatException|NullPointerException e) {
                    // Caught errors indicate a problem with data format -> Print warning and continue
                     System.out.println("Invalid line: "+ line);
                }
            }
        } finally {
            br.close();
        }

        return result;
    }
}
