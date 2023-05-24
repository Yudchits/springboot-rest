package by.yudchits.springboot.spring_course_springboot.controller;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;
import by.yudchits.springboot.spring_course_springboot.exception_handler.NoSuchEmployeeException;
import by.yudchits.springboot.spring_course_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null)
            throw new NoSuchEmployeeException("There are no employee with id="+id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null)
            throw new NoSuchEmployeeException("There are no employee with id"+id);

        employeeService.deleteEmployee(id);

        return "Employee with id="+id+" was deleted";
    }
}
