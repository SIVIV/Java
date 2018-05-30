package Simple_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<upcase>(.*?)<\\/upcase>");

        String input = read.readLine();
        String output = input;

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String targetedMatch = matcher.group(1);
            String fullMatch = matcher.group(0);

            output = output.replaceFirst(fullMatch, targetedMatch.toUpperCase());
        }
        System.out.println(output);
    }

    /*
    input:

    Welcome to the <upcase>Software University</upcase>. Learn <upcase>computer programming</upcase> and start a <upcase>job</upcase> in a software company.

    */
}
