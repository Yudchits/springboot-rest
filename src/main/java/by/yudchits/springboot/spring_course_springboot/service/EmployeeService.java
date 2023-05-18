package by.yudchits.springboot.spring_course_springboot.service;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveOrUpdateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    void deleteEmployee(long id);
}
