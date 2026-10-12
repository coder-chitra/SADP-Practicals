
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>();

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/department/{deptName}")
    public List<Employee> getByDepartment(
            @PathVariable String deptName) {
        List<Employee> result = new ArrayList<>();

        for (Employee e : employees) {
            if (e.getDeptName() != null &&
                    e.getDeptName().equalsIgnoreCase(deptName)) {
                result.add(e);
            }
        }

        return result;
    }
}
