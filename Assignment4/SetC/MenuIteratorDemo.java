
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(name + " - Rs. " + price);
    }
}

class Menu {
    private List<MenuItem> items = new ArrayList<>();

    void addItem(String name, double price) {
        items.add(new MenuItem(name, price));
    }

    Iterator<MenuItem> createIterator() {
        return items.iterator();
    }

    void displayMenu() {
        Iterator<MenuItem> iterator = createIterator();

        while (iterator.hasNext()) {
            iterator.next().display();
        }
    }
}

public class MenuIteratorDemo {
    public static void main(String[] args) {
        Menu breakfast = new Menu();
        Menu lunch = new Menu();
        Menu dinner = new Menu();

        breakfast.addItem("Poha", 30);
        breakfast.addItem("Idli", 40);

        lunch.addItem("Veg Thali", 100);
        lunch.addItem("Paneer Rice", 120);

        dinner.addItem("Roti Bhaji", 80);
        dinner.addItem("Dal Rice", 70);

        System.out.println("BREAKFAST MENU");
        breakfast.displayMenu();

        System.out.println("\nLUNCH MENU");
        lunch.displayMenu();

        System.out.println("\nDINNER MENU");
        dinner.displayMenu();
    }
}
