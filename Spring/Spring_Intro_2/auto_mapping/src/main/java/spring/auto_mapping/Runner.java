package spring.auto_mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.auto_mapping.dtos.EmployeeDto;
import spring.auto_mapping.dtos.ManagerDto;
import spring.auto_mapping.models.Employee;
import spring.auto_mapping.services.AddressService;
import spring.auto_mapping.services.EmployeeService;


@Component
public class Runner implements CommandLineRunner {
    private AddressService addressService;
    private EmployeeService employeeService;

    @Autowired
    public Runner(AddressService addressService,
                  EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Employee manager = this.employeeService.findEmployeeById(0L);
        Employee employee = this.employeeService.findEmployeeById(1L);
        ModelMapper mapper = new ModelMapper();
        //EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        ManagerDto managerDto = mapper.map(manager, ManagerDto.class);


        managerDto.getSubordinates().forEach(s->System.out.println(s.getFirstName()));
        System.out.println(managerDto.getFirstName());
    }
}
