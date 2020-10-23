package pl.kashp.projectmanagement.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kashp.projectmanagement.entities.Project;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
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
        assertEquals(1, proRepo.findAll().size());
//        AssertJ
//        assertThat(proRepo.findAll().size).isEqualTo(5);
    }
}
