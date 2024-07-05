package BookOrderer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBookName().compareTo(o2.getBookName());
            }
        });

        books.add(new Book("Ali", 132));
        books.add(new Book("Veli", 152));
        books.add(new Book("Salih", 156));
        books.add(new Book("Seçkin", 142));
        books.add(new Book("Kiraz", 131));

        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------------");
        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber();
            }
        });

        books2.add(new Book("Ali", 132));
        books2.add(new Book("Veli", 152));
        books2.add(new Book("Salih", 156));
        books2.add(new Book("Seçkin", 142));
        books2.add(new Book("Kiraz", 131));

        Iterator<Book> iterator2 = books2.iterator();

        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
