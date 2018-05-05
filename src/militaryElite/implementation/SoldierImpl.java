package militaryElite.implementation;

import militaryElite.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier{
    private String id;
    private String firstName;
    private String lastName;

    public SoldierImpl(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s",this.getFirstName(), this.getLastName(), this.getId());
    }
}
