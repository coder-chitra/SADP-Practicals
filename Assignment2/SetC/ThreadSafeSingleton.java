public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton object created");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    void display() {
        System.out.println(
                Thread.currentThread().getName()
                        + " accessing singleton");
    }
}

public class ThreadSafeSingleton {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton obj = Singleton.getInstance();
            obj.display();
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}{

}
