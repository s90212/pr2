package de.bht.pr2.lab03.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    String title;
    String type;
    double price;
    int edition;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Book(String title, String type, double price, int edition) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return edition == book.edition && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, edition);
    }

    public static List<Book> parseArray(List<String> data) {
        List<Book> bookList = new ArrayList<>();
        for (String bookData : data) {
            bookList.add(parseLine(bookData));
        }
        return bookList;
    }
    public static Book parseLine(String data) {
        String[] dataArray = data.split(";");
        Book book = new Book(dataArray[0], dataArray[1], Double.parseDouble(dataArray[2]), Integer.parseInt(dataArray[3]));
        if (dataArray.length == 5) {
            if (dataArray[4].equals("Streaming") || dataArray[4].equals("Download") || dataArray[4].equals("CD")) {
                book = new AudioBook(book, dataArray[4]);
            } else book = new EBook(book, Integer.parseInt(dataArray[4]));
        }
        return book;
    }
}
