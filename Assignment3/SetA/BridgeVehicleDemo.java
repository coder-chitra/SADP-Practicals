
interface Workshop {
    void work();
}

class Produce implements Workshop {
    public void work() {
        System.out.println("Manufacturing vehicle");
    }
}

class Assemble implements Workshop {
    public void work() {
        System.out.println("Assembling vehicle");
    }
}

abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    Vehicle(Workshop w1, Workshop w2) {
        workshop1 = w1;
        workshop2 = w2;
    }

    abstract void manufacture();
}

class Car extends Vehicle {
    Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    void manufacture() {
        System.out.println("Car:");
        workshop1.work();
        workshop2.work();
    }
}

class Bike extends Vehicle {
    Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    void manufacture() {
        System.out.println("Bike:");
        workshop1.work();
        workshop2.work();
    }
}

public class BridgeVehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car(new Produce(), new Assemble());
        Vehicle bike = new Bike(new Produce(), new Assemble());

        car.manufacture();
        bike.manufacture();
    }
}
