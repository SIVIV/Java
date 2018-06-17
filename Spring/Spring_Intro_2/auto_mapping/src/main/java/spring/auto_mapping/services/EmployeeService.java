package spring.auto_mapping.services;


import spring.auto_mapping.models.Employee;

public interface EmployeeService {
    void saveToDb(Employee employee);
    Employee findEmployeeById(Long id);
}
