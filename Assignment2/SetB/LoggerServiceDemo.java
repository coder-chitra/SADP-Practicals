
class LoggerService {
    private static final LoggerService instance = new LoggerService();

    private LoggerService() {
        System.out.println("LoggerService initialized");
    }

    public static LoggerService getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class LoggerServiceDemo {
    public static void main(String[] args) {
        LoggerService logger1 = LoggerService.getInstance();
        LoggerService logger2 = LoggerService.getInstance();

        logger1.log("Application started");

        System.out.println(
                "Same instance: " + (logger1 == logger2));
    }
}
