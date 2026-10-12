
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final Map<Integer, Student> students = new LinkedHashMap<>();

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.put(student.getRollNo(), student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @GetMapping("/{rollNo}")
    public Student getStudent(@PathVariable int rollNo) {
        return students.get(rollNo);
    }

    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        if (students.remove(rollNo) != null) {
            return "Student deleted successfully";
        }
        return "Student not found";
    }
}
