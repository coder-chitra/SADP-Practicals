// package SetB;

interface Car {
    void showDetails();
}

class NorthAmericanCar implements Car {
    public void showDetails() {
        System.out.println(
                "North American Car: Automatic, Left-hand drive");
    }
}

class EuropeanCar implements Car {
    public void showDetails() {
        System.out.println(
                "European Car: Manual, Left-hand drive");
    }
}

interface CarFactory {
    Car createCar();
}

class NorthAmericaFactory implements CarFactory {
    public Car createCar() {
        return new NorthAmericanCar();
    }
}

class EuropeFactory implements CarFactory {
    public Car createCar() {
        return new EuropeanCar();
    }
}

public class CarFactoryDemo {
    public static void main(String[] args) {
        CarFactory factory = new NorthAmericaFactory();
        Car car = factory.createCar();
        car.showDetails();

        factory = new EuropeFactory();
        car = factory.createCar();
        car.showDetails();
    }
}
