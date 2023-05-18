package by.yudchits.springboot.spring_course_springboot.service;

import by.yudchits.springboot.spring_course_springboot.dao.EmployeeDAO;
import by.yudchits.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(long id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }
}
