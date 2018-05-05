package militaryElite.implementation;

import militaryElite.interfaces.Engineer;
import militaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(String id, String firstName, String lastName, double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    @Override
    public List<Repair> getRepairs() {
        return repairs;
    }


    public void setRepairs(List<Repair> repairs) {
        if(repairs!=null){
            this.repairs = new ArrayList<>(repairs);
        }else {
            this.repairs = new ArrayList<>();
        }

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        this.getRepairs().forEach(x->sb.append("  ").append(x.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
