import java.util.*;

class EnumerationAdapter implements Iterator<String> {
    private Enumeration<String> enumeration;

    EnumerationAdapter(Enumeration<String> enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();

        return enumeration.nextElement();
    }
}

public class EnumerationAdapterDemo {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        Iterator<String> iterator = new EnumerationAdapter(fruits.elements());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
