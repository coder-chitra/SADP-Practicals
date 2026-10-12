
interface Shape extends Cloneable {
    Shape clone();

    void display();
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public Shape clone() {
        return new Circle(radius);
    }

    public void display() {
        System.out.println("Circle radius: " + radius);
    }
}

class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Shape clone() {
        return new Rectangle(length, width);
    }

    public void display() {
        System.out.println(
                "Rectangle length: " + length
                        + ", width: " + width);
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Circle c2 = (Circle) c1.clone();

        Rectangle r1 = new Rectangle(10, 4);
        Rectangle r2 = (Rectangle) r1.clone();

        System.out.println("Original Circle:");
        c1.display();

        System.out.println("Cloned Circle:");
        c2.display();

        System.out.println("Original Rectangle:");
        r1.display();

        System.out.println("Cloned Rectangle:");
        r2.display();
    }
}
