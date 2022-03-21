package sk.tobas;

public class Book {

    private final String name;
    private final int price;

    public Book(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
