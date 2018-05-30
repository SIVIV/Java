package URL_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String input = read.readLine();

        URL url = new URL(input);

        String protocol = url.getProtocol();
        String server = url.getHost();
        String resource = url.getPath().replaceFirst("/", "");

        System.out.println
                (String.format("[protocol] = \"%s\"%n" +
                                "[server] = \"%s\"%n" +
                                "[resource] = \"%s\"", protocol, server, resource));
    }

    /*
    input:

    http://www.abv.com/video
     */
}
