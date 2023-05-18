package by.yudchits.springboot.spring_course_springboot.controller;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;
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
        return employeeService.getEmployee(id);
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
        if(employee != null){
            employeeService.deleteEmployee(id);
            return "Employee with id="+id+" was deleted";
        } else {
            return "There no employee with id"+id;
        }
    }
}
