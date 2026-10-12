package setB;


import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public Task add(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    @GetMapping
    public List<Task> getAll() {
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return tasks.stream()
            .filter(t -> t.getId() == id)
            .findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id,
                       @RequestBody Task updated) {
        Task task = getById(id);

        if (task != null) {
            task.setTitle(updated.getTitle());
            task.setCategory(updated.getCategory());
            task.setDueDate(updated.getDueDate());
        }

        return task;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        return removed ? "Task deleted" : "Task not found";
    }
}
