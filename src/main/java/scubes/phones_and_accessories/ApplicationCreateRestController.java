package scubes.phones_and_accessories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scubes.phones_and_accessories.asset.common_asset.model.Enum.CivilStatus;
import scubes.phones_and_accessories.asset.common_asset.model.Enum.Gender;
import scubes.phones_and_accessories.asset.common_asset.model.Enum.Title;
import scubes.phones_and_accessories.asset.employee.entity.Employee;
import scubes.phones_and_accessories.asset.employee.entity.enums.Designation;
import scubes.phones_and_accessories.asset.employee.entity.enums.EmployeeStatus;
import scubes.phones_and_accessories.asset.employee.service.EmployeeService;
import scubes.phones_and_accessories.asset.user_management.entity.Role;
import scubes.phones_and_accessories.asset.user_management.entity.User;
import scubes.phones_and_accessories.asset.user_management.service.RoleService;
import scubes.phones_and_accessories.asset.user_management.service.UserService;

import java.time.LocalDate;
import java.util.stream.Collectors;
@RestController
public class ApplicationCreateRestController {
    private final RoleService roleService;
    private final UserService userService;
    private final EmployeeService employeeService;


    @Autowired
    public ApplicationCreateRestController(RoleService roleService, UserService userService,
                                           EmployeeService employeeService) {
        this.roleService = roleService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @GetMapping("/select/user")
    public String saveUser() {
        //roles list start
        String[] roles = {"ADMIN"};
        for (String s : roles) {
            Role role = new Role();
            role.setRoleName(s);
            roleService.persist(role);
        }

//Employee
        Employee employee = new Employee();
        employee.setName("Admin User");
        employee.setCallingName("Admin");
        employee.setName("901142122V");
        employee.setMobileOne("0717130052");
        employee.setMobileTwo("0760870052");
        employee.setTitle((Title) Title.Mr);
        employee.setGender(Gender.MALE);
        employee.setDesignation(Designation.CA);
        employee.setCivilStatus(CivilStatus.UNMARRIED);
        employee.setEmployeeStatus(EmployeeStatus.WORKING);
        employee.setDateOfBirth(LocalDate.now().minusYears(18));
        employee.setDateOfAssignment(LocalDate.now());
        Employee employeeDb = employeeService.persist(employee);


        //admin user one
        User user = new User();
        user.setEmployee(employeeDb);
        user.setUsername("admin");
        user.setPassword("admin");
        String message = "Username:- " + user.getUsername() + "\n Password:- " + user.getPassword();
        user.setEnabled(true);
        user.setRoles(roleService.findAll()
                .stream()
                .filter(role -> role.getRoleName().equals("ADMIN"))
                .collect(Collectors.toList()));
        userService.persist(user);

        return message;
    }


}
