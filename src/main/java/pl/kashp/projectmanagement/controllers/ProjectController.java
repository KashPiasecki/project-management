package pl.kashp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kashp.projectmanagement.dao.ProjectRepository;
import pl.kashp.projectmanagement.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository proRepo;

    @Autowired
    public ProjectController(ProjectRepository proRepo) {
        this.proRepo = proRepo;
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project){
        proRepo.save(project);
        //use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
