package pl.kashp.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kashp.projectmanagement.dao.EmployeeRepository;
import pl.kashp.projectmanagement.entities.Employee;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeRepository emploRepo;

    @Autowired
    public EmployeeController(EmployeeRepository emploRepo) {
        this.emploRepo = emploRepo;
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Employee employee){
        emploRepo.save(employee);
        return "redirect:/employee/new";
    }

    @GetMapping("/list")
    public String displayEmployeeList(Model model){
        List<Employee> employees = emploRepo.findAll();
        model.addAttribute("employees", employees);
        return "/employees/employee-list";
    }
}
