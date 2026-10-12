
interface Workable {
    void work();
}

interface Feedable {
    void eat();
}

interface Restable {
    void sleep();
}

interface Payable {
    void getPaid();
}

class HumanWorker implements Workable, Feedable,
        Restable, Payable {
    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }

    public void sleep() {
        System.out.println("Human is sleeping");
    }

    public void getPaid() {
        System.out.println("Human received salary");
    }
}

class RobotWorker implements Workable, Payable {
    public void work() {
        System.out.println("Robot is working");
    }

    public void getPaid() {
        System.out.println("Robot service payment processed");
    }
}

public class ISPDemo {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();
        human.sleep();
        human.getPaid();

        System.out.println();

        RobotWorker robot = new RobotWorker();
        robot.work();
        robot.getPaid();
    }
}
