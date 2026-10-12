package setB;


import java.util.HashMap;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String, User> users = new HashMap<>();

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody User user) {

        if (users.containsKey(user.getEmail())) {
            return ResponseEntity.badRequest()
                .body("Email already registered");
        }

        users.put(user.getEmail(), user);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody User user) {

        User saved = users.get(user.getEmail());

        if (saved != null &&
            saved.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }

        return ResponseEntity.status(401)
            .body("Invalid email or password");
    }
}
