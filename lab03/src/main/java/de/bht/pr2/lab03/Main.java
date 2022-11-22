package de.bht.pr2.lab03;

import de.bht.pr2.lab03.store.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> soldBookData = BookStore.getSoldBooks();
        List<Book> soldBooks = Book.parseArray(soldBookData);
    }
}
