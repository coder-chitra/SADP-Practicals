
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
public class HrController {

    @PostMapping("/select")
    public String selectCandidate(
            @RequestBody Candidate candidate) {

        return "Dear " + candidate.getName()
                + ", You have been selected for an interview."
                + " Message will be sent to: "
                + candidate.getEmail();
    }
}
