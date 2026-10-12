
import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showDetails();
}

class Worker implements Employee {
    private String name;
    private String designation;

    Worker(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void showDetails() {
        System.out.println(name + " - " + designation);
    }
}

class Manager implements Employee {
    private String name;
    private List<Employee> team = new ArrayList<>();

    Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public void showDetails() {
        System.out.println("Manager: " + name);

        for (Employee employee : team) {
            employee.showDetails();
        }
    }
}

public class EmployeeCompositeDemo {
    public static void main(String[] args) {
        Worker e1 = new Worker("Amit", "Developer");
        Worker e2 = new Worker("Neha", "Tester");

        Manager manager = new Manager("Rahul");
        manager.addEmployee(e1);
        manager.addEmployee(e2);

        manager.showDetails();

        System.out.println();

        System.out.println("Individual Employee:");
        e1.showDetails();
    }
}
