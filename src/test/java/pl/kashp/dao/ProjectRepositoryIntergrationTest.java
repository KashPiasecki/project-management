package pl.kashp.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kashp.projectmanagement.ProjectManagementApplication;
import pl.kashp.projectmanagement.dao.ProjectRepository;
import pl.kashp.projectmanagement.entities.Project;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"classpath:schema.sql", "classpath:data.sql"}),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntergrationTest {


    @Autowired
    ProjectRepository proRepo;


    @Test
    public void ifNewProjectSavedThenSuccess(){
        //Given
        Project newProject = new Project("New Test Project", "COMPLETED", "Test description");
        //when
        proRepo.save(newProject);
        //then
        assertEquals(5, proRepo.findAll().size());
//        AssertJ
//        assertThat(proRepo.findAll().size).isEqualTo(5);
    }
}
