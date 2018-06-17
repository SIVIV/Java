package spring.auto_mapping.dtos;

import java.math.BigDecimal;

public class EmployeeDto extends PersonnelDto{
    private BigDecimal salary;


    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
