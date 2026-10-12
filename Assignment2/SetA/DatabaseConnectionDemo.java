
public class DatabaseConnection {
    private static volatile DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database connection object created");
    }

    public static DatabaseConnection getConnection() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}

public class DatabaseConnectionDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            DatabaseConnection db =
                DatabaseConnection.getConnection();

            System.out.println(
                Thread.currentThread().getName()
                + " : " + db.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}ss{

}
