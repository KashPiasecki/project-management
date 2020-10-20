package pl.kashp.projectmanagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.kashp.projectmanagement.dto.EmployeeProject;
import pl.kashp.projectmanagement.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true,
            value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT (pe.employee_id) as projectCount " +
                    "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
                    "GROUP BY e.first_name, e.last_name ORder BY 3 DESC")
    public List<EmployeeProject> employeeProjects();
}
