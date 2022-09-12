package com.pt.springsecurityjpa.controller;

import com.pt.springsecurityjpa.model.Company;
import com.pt.springsecurityjpa.model.Employee;
import com.pt.springsecurityjpa.model.User;
import com.pt.springsecurityjpa.repository.RoleRepository;
import com.pt.springsecurityjpa.repository.UserRepository;
import com.pt.springsecurityjpa.service.CompanyService;
import com.pt.springsecurityjpa.service.EmployeeService;
import com.pt.springsecurityjpa.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    @Autowired
    private RolesService rolesService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/employee")
    public String employeePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employee";
    }
    @GetMapping("/company")
    public String departmentPage(Model model){
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "company";
    }
    @GetMapping("/admin")
    public String configurationPage(){
        return "admin";
    }
    @GetMapping("/showNewUser")
    public String viewRegistration(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("listOfRoles", rolesService.getAllRoles());
        return "add-user";
    }
    @GetMapping("/showNewEmployee")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companyService.getAllCompanies());
        return "new_employee";
    }
    @GetMapping("/showNewCompany")
    public String viewNewCompanyPage(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "new_company";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company";
    }
    @PostMapping("/saveNewUser")
    public String addUser(@ModelAttribute("User") User user) {
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companyService.getAllCompanies());
        return "update_employee";
    }
    @GetMapping("/showFormForUpdateCompany/{id}")
    public String showFormForUpdateDepartment(@PathVariable long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "update_company";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value = "id") long id) {
        this.companyService.deleteCompanyById(id);
        return "redirect:/company";
    }
}
