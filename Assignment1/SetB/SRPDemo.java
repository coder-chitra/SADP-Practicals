
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    List<Integer> marks;

    Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }
}

class GradeCalculator {
    double average(List<Integer> marks) {
        return marks.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
    }

    String findGrade(double average) {
        if (average >= 75) return "A";
        if (average >= 60) return "B";
        if (average >= 40) return "C";
        return "Fail";
    }
}

class StudentRepository {
    void save(Student student) {
        try (FileWriter writer =
                 new FileWriter("student.txt")) {
            writer.write("Name: " + student.name + "\n");
            writer.write("Marks: " + student.marks + "\n");
        } catch (IOException e) {
            System.out.println("Error saving student");
        }
    }
}

public class SRPDemo {
    public static void main(String[] args) {
        Student s = new Student(
            "Amit", Arrays.asList(80, 70, 90));

        GradeCalculator gc = new GradeCalculator();
        double avg = gc.average(s.marks);

        System.out.println("Name: " + s.name);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + gc.findGrade(avg));

        StudentRepository repo = new StudentRepository();
        repo.save(s);

        System.out.println("Student data saved.");
    }
}
