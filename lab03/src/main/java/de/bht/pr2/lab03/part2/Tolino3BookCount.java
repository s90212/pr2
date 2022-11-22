package de.bht.pr2.lab03.part2;

import de.bht.pr2.lab03.store.Book;
import de.bht.pr2.lab03.store.BookStore;
import de.bht.pr2.lab03.store.EBook;

import java.util.List;

public class Tolino3BookCount {

  public static void main(String[] args) {
    /* Das Ergebnis der Berechnungen sollte sein:

    Anzahl Ebuecher bei Tolino 3: 9

     */
    List<String> soldBookData = BookStore.getSoldBooks();
    List<Book> soldBooks = Book.parseArray(soldBookData);
    int t3 = 0;
    for (Book book : soldBooks) {
      if (book instanceof EBook) {
        if (((EBook) book).gettVersion() == 3) t3++;
      }
    }
    System.out.println("Anzahl Ebuecher bei Tolino 3: " + t3);
  }
}
