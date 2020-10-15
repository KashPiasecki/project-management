package pl.kashp.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kashp.projectmanagement.entities.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

}
