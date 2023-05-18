package by.yudchits.springboot.spring_course_springboot.dao;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void saveOrUpdateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    void deleteEmployee(long id);
}
