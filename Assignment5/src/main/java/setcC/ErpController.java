package setcC;


import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/erp")
public class ErpController {

    private final Map<Integer, String> inventory = new HashMap<>();
    private final List<String> sales = new ArrayList<>();
    private final List<String> finance = new ArrayList<>();

    private int nextId = 1;

    // Inventory module
    @PostMapping("/inventory")
    public String addProduct(@RequestParam String name,
                             @RequestParam int quantity) {
        int id = nextId++;
        inventory.put(id, name + ", Quantity: " + quantity);
        return "Product added with ID: " + id;
    }

    @GetMapping("/inventory")
    public Map<Integer, String> getInventory() {
        return inventory;
    }

    // Sales module
    @PostMapping("/sales")
    public String addSale(@RequestParam String product,
                          @RequestParam double amount) {
        sales.add(product + ", Amount: Rs. " + amount);
        return "Sale recorded successfully";
    }

    @GetMapping("/sales")
    public List<String> getSales() {
        return sales;
    }

    // Finance module
    @PostMapping("/finance")
    public String addFinance(@RequestParam String description,
                             @RequestParam double amount) {
        finance.add(description + ", Amount: Rs. " + amount);
        return "Financial entry recorded";
    }

    @GetMapping("/finance")
    public List<String> getFinance() {
        return finance;
    }
}

