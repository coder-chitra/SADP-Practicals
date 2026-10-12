package SetC;

interface FlyingBird {
    void fly();
}

class Bird {
    void eat() {
        System.out.println("Bird is eating");
    }
}

class Sparrow extends Bird implements FlyingBird {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    void swim() {
        System.out.println("Penguin is swimming");
    }
}

public class LSPDemo {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly();

        Penguin penguin = new Penguin();
        penguin.eat();
        penguin.swim();
    }
}
