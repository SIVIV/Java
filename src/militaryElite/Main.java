package militaryElite;

import com.sun.org.apache.regexp.internal.RE;
import militaryElite.implementation.*;
import militaryElite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Soldier> database = new LinkedHashMap<>();

        while (true) {
            String[] input = read.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(input[0])) {
                break;
            }

            String type = input[0];
            String id = input[1];
            String firstName = input[2];
            String lastName = input[3];

            switch (type) {
                case "Private":
                    database.putIfAbsent(id, new PrivateImpl(id, firstName, lastName, Double.parseDouble(input[4])));
                    break;
                case "LeutenantGeneral":
                    List<Private> privateList = new ArrayList<>();
                    Stream.of(input)
                            .skip(5)
                            .collect(Collectors.toList())
                            .forEach(e -> privateList.add(Private.class.cast(database.get(e))));
                    database.putIfAbsent(id,
                            new LeutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(input[4]), privateList));
                    break;
                case "Engineer":
                    SpecialisedSoldier engineer = new EngineerImpl(id, firstName, lastName,
                            Double.parseDouble(input[4]), input[5], setRepairList(input));
                    if(engineer.getCorps()!=null)
                    database.putIfAbsent(id, engineer);
                    break;
                case "Commando":
                    SpecialisedSoldier soldier = new CommandoImpl(id, firstName, lastName,
                            Double.parseDouble(input[4]), input[5], setMissionList(input));
                    if (soldier.getCorps() != null)
                        database.putIfAbsent(id, soldier);
                    break;
                case "Spy":
                    database.putIfAbsent(id, new SpyImpl(id, firstName, lastName, input[4]));
                    break;
            }
        }
        for (Soldier soldier : database.values()) {
            System.out.println(soldier.toString().trim());
        }

    }

    private static List<Repair> setRepairList(String... args) {
        List<Repair> list = new ArrayList<>();
        for (int i = 6; i < args.length; i += 2) {
            list.add(new RepairImpl(args[i], Integer.parseInt(args[i + 1])));
        }
        return list;
    }

    private static List<Mission> setMissionList(String... args) {
        List<Mission> list = new ArrayList<>();
        for (int i = 6; i < args.length; i += 2) {
            Mission m = new MissionImpl(args[i], args[i + 1]);
            if (m.getState() != null)
                list.add(m);
        }
        return list;
    }

}