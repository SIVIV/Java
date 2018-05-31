package Beer;

public class BeerCounter {
    public static int beerInStock;
    public static int beersDrunkCount;

    public static void buyBeer(int bottles){
        BeerCounter.beerInStock += bottles;
    }

    public static void drinkBeer(int bottles){
        BeerCounter.beerInStock -= bottles;
        BeerCounter.beersDrunkCount += bottles;
    }

}
