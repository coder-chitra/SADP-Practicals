
abstract class Approver {
    protected Approver next;

    void setNext(Approver next) {
        this.next = next;
    }

    abstract void approve(double amount);
}

class Manager extends Approver {
    void approve(double amount) {
        if (amount <= 1000) {
            System.out.println("Manager approved loan: $" + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

class SeniorManager extends Approver {
    void approve(double amount) {
        if (amount <= 10000) {
            System.out.println(
                    "Senior Manager approved loan: $" + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

class Director extends Approver {
    void approve(double amount) {
        if (amount <= 100000) {
            System.out.println("Director approved loan: $" + amount);
        } else {
            System.out.println("Loan requires higher authority");
        }
    }
}

public class LoanApprovalDemo {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver senior = new SeniorManager();
        Approver director = new Director();

        manager.setNext(senior);
        senior.setNext(director);

        manager.approve(1000);
        manager.approve(10000);
        manager.approve(100000);
        manager.approve(150000);
    }
}
