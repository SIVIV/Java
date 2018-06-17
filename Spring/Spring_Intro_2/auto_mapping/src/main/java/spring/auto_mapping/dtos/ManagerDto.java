package spring.auto_mapping.dtos;

import java.util.List;

public class ManagerDto extends PersonnelDto{
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return this.subordinates;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }


}
