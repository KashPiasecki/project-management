package pl.kashp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kashp.projectmanagement.dao.EmployeeRepository;
import pl.kashp.projectmanagement.dao.ProjectRepository;
import pl.kashp.projectmanagement.entities.Employee;
import pl.kashp.projectmanagement.entities.Project;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository proRepo;
    private EmployeeRepository empRepo;

    @Autowired
    public ProjectController(ProjectRepository proRepo, EmployeeRepository epmRepo) {
        this.proRepo = proRepo;
        this.empRepo = epmRepo;
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("allEmployees", employees);
        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project, @RequestParam List<Long> employees){
        proRepo.save(project);
        Iterable<Employee> choosenEmployees = empRepo.findAllById(employees);
        for (Employee emp : choosenEmployees) {
            emp.setProject(project);
            empRepo.save(emp);
        }
        //use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }

    @GetMapping("/list")
    public String displayProjectList(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "/projects/project-list";
    }
}
