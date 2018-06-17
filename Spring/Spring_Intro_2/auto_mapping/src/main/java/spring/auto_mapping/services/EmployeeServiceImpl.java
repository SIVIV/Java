package spring.auto_mapping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.auto_mapping.models.Employee;
import spring.auto_mapping.repositories.EmployeeRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveToDb(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findEmployeeById(id);
    }
}
