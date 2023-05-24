package by.yudchits.springboot.spring_course_springboot.dao;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Employee savedOrUpdateEmp = entityManager.merge(employee);
        //чтобы адекватно отображался id в postman/browser
        employee.setId(savedOrUpdateEmp.getId());
    }

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee ");
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Query query = entityManager.createQuery("delete from Employee where id =: empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
