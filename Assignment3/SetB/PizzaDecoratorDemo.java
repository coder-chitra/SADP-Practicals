
interface Pizza {
    String getDescription();

    double getCost();
}

class BasicPizza implements Pizza {
    public String getDescription() {
        return "Basic Pizza";
    }

    public double getCost() {
        return 100;
    }
}

abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Cheese extends ToppingDecorator {
    Cheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 30;
    }
}

class Olives extends ToppingDecorator {
    Olives(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    public double getCost() {
        return pizza.getCost() + 20;
    }
}

class Mushrooms extends ToppingDecorator {
    Mushrooms(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    public double getCost() {
        return pizza.getCost() + 25;
    }
}

public class PizzaDecoratorDemo {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();

        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Mushrooms(pizza);

        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Total cost: Rs. " + pizza.getCost());
    }
}
