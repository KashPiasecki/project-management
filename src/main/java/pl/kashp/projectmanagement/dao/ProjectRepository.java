package pl.kashp.projectmanagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kashp.projectmanagement.dto.ProjectProgress;
import pl.kashp.projectmanagement.entities.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();


    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value " +
            "FROM project GROUP BY stage")
    public List<ProjectProgress> projectProgress();
}
