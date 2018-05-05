package militaryElite.implementation;

import militaryElite.interfaces.Commando;
import militaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(String id, String firstName, String lastName, double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    private void setMissions(List<Mission> missions) {
        if (missions != null) {
            this.missions = new ArrayList<>(missions);
        } else {
            this.missions = new ArrayList<>();
        }
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        this.getMissions().forEach(x -> sb.append("  ").append(x.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
