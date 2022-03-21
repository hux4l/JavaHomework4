package sk.tobas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // get sum of numbers 1 - 1000 dividable by 3 & 5 not 7
        var sum = Stream.iterate(1, i -> i+= 1)
                .limit(1000)
                .filter(num -> (num % 3 == 0 && num % 5 == 0 && num % 7 != 0))
                .reduce(0, (a, b) -> a = a + b);

        System.out.println(sum);

        // sum off first 100 even numbers that are not dividable by 8
        var sum2 = Stream.iterate(2, i -> i +=2)
                .limit(100)
                .filter(num -> (num % 8 != 0))
                .reduce(0, Integer::sum);

        System.out.println(sum2);

        Book b1 = new Book("Here", 10);
        Book b2 = new Book("There", 101);
        Book b3 = new Book("And here", 99);
        Book b4 = new Book("Something", 134);
        Book b5 = new Book("Name me", 205);
        Book b6 = new Book("I have a name", 34);
        Book b7 = new Book("Do you know my name", 649);
        Book b8 = new Book("Hoy", 324);
        Book b9 = new Book("Uno", 223);
        Book b10 = new Book("Shot", 123);

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        // print alphabetical ordered book names with price less than 100
        books.stream()
                .filter(b -> b.getPrice() < 100)
                .sorted(Comparator.comparing(Book::getName))
                .forEach(b -> System.out.println(b.getName()));

        // how many book with name shorter than 5
        var shortBooks = books.stream().filter(book -> book.getName().length() < 5).count();
        System.out.println(shortBooks);

        // average price of books in the list
        var averagePrice = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElseThrow();

        System.out.println(averagePrice);

        // if all books in list are cheaper than 500
        var allCheap = books.stream().allMatch(book -> book.getPrice() < 500);
        System.out.println(allCheap);
    }
}
