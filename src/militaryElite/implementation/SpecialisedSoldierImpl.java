package militaryElite.implementation;

import militaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private final String AIRFORCES = "Airforces";
    private final String MARINES = "Marines";
    private String corps;

    public SpecialisedSoldierImpl(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if(AIRFORCES.equals(corps) || MARINES.equals(corps)){
            this.corps = corps;
        }
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Corps: %s", this.getCorps()));
        return sb.toString();
    }
}
