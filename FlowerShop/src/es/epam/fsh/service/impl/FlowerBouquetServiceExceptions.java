package es.epam.fsh.service.impl;

public class FlowerBouquetServiceExceptions extends Exception{
    public FlowerBouquetServiceExceptions(String message){
        super (message);

    }
    public FlowerBouquetServiceExceptions(String message, Throwable cause){
        super (message, cause);

    }

    // the defined class is used to throw exceptions when FlowerBouquetService methods can be used not in proper way
    //Examples
    // 1) need to throw custom exception for negative price. Handled in FlowerBouquetServiceImpl
    // 2)  Throw custom exception if try to remove more flowers than exist in bouquet. Example can be found in Main class
    // 3) Throwing custom exception if trying to delete unexciting flower from bouquet. Example can be found in Main class
}
