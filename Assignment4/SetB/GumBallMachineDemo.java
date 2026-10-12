
class GumballMachine {
    private int gumballs;
    private boolean hasQuarter;

    GumballMachine(int count) {
        gumballs = count;
        hasQuarter = false;
    }

    void insertQuarter() {
        if (hasQuarter) {
            System.out.println("Quarter already inserted");
        } else {
            hasQuarter = true;
            System.out.println("Quarter inserted");
        }
    }

    void removeQuarter() {
        if (hasQuarter) {
            hasQuarter = false;
            System.out.println("Quarter returned");
        } else {
            System.out.println("No quarter to return");
        }
    }

    void turnCrank() {
        if (!hasQuarter) {
            System.out.println("Insert a quarter first");
        } else if (gumballs == 0) {
            hasQuarter = false;
            System.out.println("Machine is empty");
        } else {
            hasQuarter = false;
            gumballs--;
            System.out.println("Gumball dispensed");
        }
    }

    void display() {
        System.out.println("Gumballs remaining: " + gumballs);
        System.out.println("Quarter inserted: " + hasQuarter);
    }

    // Memento: saves the machine's state
    static class Memento {
        private final int gumballs;
        private final boolean hasQuarter;

        private Memento(int gumballs, boolean hasQuarter) {
            this.gumballs = gumballs;
            this.hasQuarter = hasQuarter;
        }
    }

    Memento saveState() {
        return new Memento(gumballs, hasQuarter);
    }

    void restoreState(Memento memento) {
        gumballs = memento.gumballs;
        hasQuarter = memento.hasQuarter;
        System.out.println("Previous state restored");
    }
}

public class GumballMachineDemo {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(5);

        machine.display();

        GumballMachine.Memento savedState = machine.saveState();

        machine.insertQuarter();
        machine.turnCrank();
        machine.display();

        machine.restoreState(savedState);
        machine.display();
    }
}
