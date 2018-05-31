package Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"END".equalsIgnoreCase(input = read.readLine())) {
            int[] bottles = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            BeerCounter.buyBeer(bottles[0]);
            BeerCounter.drinkBeer(bottles[1]);
        }

        System.out.println(String.format("%d %d", BeerCounter.beerInStock, BeerCounter.beersDrunkCount));

        /*
        input:
        50 49
        9 10

        output:
        0 59
         */
    }
}
