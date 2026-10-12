
abstract class Pizza {
    void prepare() {
        System.out.println("Preparing pizza");
    }

    void bake() {
        System.out.println("Baking pizza");
    }

    void cut() {
        System.out.println("Cutting pizza");
    }

    void box() {
        System.out.println("Boxing pizza");
    }
}

class NYStyleCheesePizza extends Pizza {
    NYStyleCheesePizza() {
        System.out.println("New York Cheese Pizza");
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza() {
        System.out.println("Chicago Cheese Pizza");
    }
}

abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        if (pizza == null) {
            System.out.println("Pizza not available");
            return null;
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese"))
            return new NYStyleCheesePizza();
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese"))
            return new ChicagoStyleCheesePizza();
        return null;
    }
}

public class PizzaFactoryDemo {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");

        System.out.println();

        store = new ChicagoPizzaStore();
        store.orderPizza("cheese");
    }
}
