package PhoneBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> pb = new HashMap<>();

        String input = read.readLine();

        while (!"END".equalsIgnoreCase(input)) {
            String[] data = input.split(" ");
            String command = data[0];
            String name = data[1];

            switch (command) {
                case "A":
                    String phoneNumber = data[2];
                    pb.put(name, phoneNumber);
                    break;
                case "S":
                    if (pb.containsKey(name)) {
                        System.out.println(String.format("%s -> %s", name, pb.get(name)));
                    } else {
                        System.out.println(String.format("Contact %s does not exist", name));
                    }
                    break;
            }
            input = read.readLine();
        }
    }
}
