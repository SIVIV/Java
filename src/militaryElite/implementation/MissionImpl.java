package militaryElite.implementation;

import militaryElite.interfaces.Mission;

public class MissionImpl implements Mission {
    private static final String MISSION_FINISHED_STATUS = "Finished";
    private static final String MISSION_INPROGRESS_STATUS = "inProgress";
    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        if (MISSION_INPROGRESS_STATUS.equals(state) || MISSION_FINISHED_STATUS.equals(state)) {
            this.state = state;
        }
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState(MISSION_FINISHED_STATUS);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
