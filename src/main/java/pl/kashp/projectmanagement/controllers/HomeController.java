package pl.kashp.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kashp.projectmanagement.dao.EmployeeRepository;
import pl.kashp.projectmanagement.dao.ProjectRepository;
import pl.kashp.projectmanagement.dto.EmployeeProject;
import pl.kashp.projectmanagement.dto.ProjectProgress;
import pl.kashp.projectmanagement.entities.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    ProjectRepository proRepo;
    EmployeeRepository emplRepo;

    @Autowired
    public HomeController(ProjectRepository proRepo, EmployeeRepository emplRepo) {
        this.proRepo = proRepo;
        this.emplRepo = emplRepo;
    }

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = proRepo.findAll();
        List<EmployeeProject> employeesProjectCount = emplRepo.employeeProjects();
        model.addAttribute("projects", projects);
        model.addAttribute("employeesListProjectCount", employeesProjectCount);

        List<ProjectProgress> projectProgress = proRepo.projectProgress();


        //Lets convert projectProgress into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectProgress);
        //["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]
        model.addAttribute("projectStatusCnt", jsonString);


        model.addAttribute("projectProgress", projectProgress);
        return "/main/home";
    }



}
