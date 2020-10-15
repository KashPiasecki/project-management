package pl.kashp.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kashp.projectmanagement.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
}
