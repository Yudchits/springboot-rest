package by.yudchits.springboot.spring_course_springboot.dao;

import by.yudchits.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee getEmployee(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee where id =: empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
