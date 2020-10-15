package pl.kashp.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kashp.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
