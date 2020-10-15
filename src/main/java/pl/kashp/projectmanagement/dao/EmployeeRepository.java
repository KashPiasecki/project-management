package pl.kashp.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kashp.projectmanagement.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
