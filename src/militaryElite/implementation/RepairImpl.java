package militaryElite.implementation;

import militaryElite.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hours;

    public RepairImpl(String partName, int hours) {
        this.setPartName(partName);
        this.setHours(hours);
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    private void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.getPartName(),this.getHours());
    }
}
