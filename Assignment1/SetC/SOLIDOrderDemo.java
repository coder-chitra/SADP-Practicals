package SetC;

class Order {
    String type;
    double amount;

    Order(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

// SRP: Validates orders
class OrderValidator {
    boolean validate(Order order) {
        return order != null && order.amount > 0;
    }
}

// OCP: Different pricing strategies
interface PriceCalculator {
    double calculate(Order order);
}

class DigitalOrderCalculator implements PriceCalculator {
    public double calculate(Order order) {
        return order.amount * 1.18;
    }
}

class PhysicalOrderCalculator implements PriceCalculator {
    public double calculate(Order order) {
        return order.amount * 1.18 + 100;
    }
}

// ISP: Small interfaces for separate operations
interface OrderRepository {
    void save(Order order);
}

interface EmailNotifier {
    void sendEmail(Order order);
}

interface AppLogger {
    void log(String message);
}

class DatabaseRepository implements OrderRepository {
    public void save(Order order) {
        System.out.println("Order saved to database");
    }
}

class CustomerEmail implements EmailNotifier {
    public void sendEmail(Order order) {
        System.out.println("Confirmation email sent");
    }
}

class ConsoleLogger implements AppLogger {
    public void log(String message) {
        System.out.println(message);
    }
}

// DIP: Depends on interfaces, not concrete classes
class OrderProcessor {
    private final OrderValidator validator;
    private final PriceCalculator calculator;
    private final OrderRepository repository;
    private final EmailNotifier notifier;
    private final AppLogger logger;

    OrderProcessor(OrderValidator validator,
            PriceCalculator calculator,
            OrderRepository repository,
            EmailNotifier notifier,
            AppLogger logger) {
        this.validator = validator;
        this.calculator = calculator;
        this.repository = repository;
        this.notifier = notifier;
        this.logger = logger;
    }

    void process(Order order) {
        if (!validator.validate(order)) {
            logger.log("Invalid order");
            return;
        }

        double total = calculator.calculate(order);
        repository.save(order);
        notifier.sendEmail(order);

        logger.log("Order processed successfully");
        System.out.println("Total price: " + total);
    }
}

public class SOLIDOrderDemo {
    public static void main(String[] args) {
        Order order = new Order("digital", 1000);

        PriceCalculator calculator;

        if (order.type.equalsIgnoreCase("digital")) {
            calculator = new DigitalOrderCalculator();
        } else {
            calculator = new PhysicalOrderCalculator();
        }

        OrderProcessor processor = new OrderProcessor(
                new OrderValidator(),
                calculator,
                new DatabaseRepository(),
                new CustomerEmail(),
                new ConsoleLogger());

        processor.process(order);
    }
}
