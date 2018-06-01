import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Streams_n_stuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer[]> db = new HashMap<>();
        String input;

        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String facultyNumber = data[0];
            Integer[] grades = Arrays.stream(data)
                    .skip(1L)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            db.putIfAbsent(facultyNumber, grades);
        }

        db.entrySet()
                .stream()
                .filter(kvp -> kvp.getKey().endsWith("14") || kvp.getKey().endsWith("15"))
                .map(Map.Entry::getValue)
                .map(arr -> Arrays.stream(arr).map(String::valueOf).toArray(String[]::new))
                .forEach(strArr -> System.out.println(String.join(" ", strArr)));
    }
}

/*
input:
554214 6 6 6 5
653215 3 4 5 6
156212 4 2 3 4
324413 5 6 5 5
134014 5 3 4 2
END
 */
