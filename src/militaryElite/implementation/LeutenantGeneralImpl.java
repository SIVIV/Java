package militaryElite.implementation;

import militaryElite.interfaces.LeutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary, List<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }

    private void setPrivates(List<Private> privates) {
        if (privates != null) {
            this.privates = new ArrayList<>(privates);
        } else {
            this.privates = new ArrayList<>();
        }

    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        this.getPrivates().forEach(x -> sb.append("  ").append(x.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
