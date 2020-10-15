package pl.kashp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kashp.projectmanagement.dao.EmployeeRepository;
import pl.kashp.projectmanagement.dao.ProjectRepository;
import pl.kashp.projectmanagement.entities.Employee;
import pl.kashp.projectmanagement.entities.Project;

import java.util.List;

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
    public String displayHome(Model model){
        List<Project> projects = proRepo.findAll();
        List<Employee> employees = emplRepo.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "/main/home";
    }



}
