package de.bht.pr2.lab03.part1;

import de.bht.pr2.lab03.store.AudioBook;
import de.bht.pr2.lab03.store.Book;
import de.bht.pr2.lab03.store.BookStore;
import de.bht.pr2.lab03.store.EBook;

import java.util.List;

public class SumPrices {

  public static void main(String[] args) {
    /* Das Ergebnis der Berechnungen sollte sein:

    Summe Buch:     € 381.88
    Summe Ebuch:    € 255.82
    Summe Hoerbuch: € 344.58
    Summe Alle:     € 982.28
   */
    List<String> soldBookData = BookStore.getSoldBooks();
    List<Book> soldBooks = Book.parseArray(soldBookData);
    double sumBook = 0;
    double sumEBook = 0;
    double sumAudioBook = 0;
    double sumAllBooks = 0;
    for (Book book : soldBooks) {
      double price = book.getPrice();
      if (book instanceof EBook) sumEBook+=price;
      else if (book instanceof AudioBook) sumAudioBook+=price;
      else sumBook+=price;
      sumAllBooks+=price;
    }
    System.out.println("Summe Buch:\t\t€ " + String.format("%.2f",sumBook));
    System.out.println("Summe EBuch:\t€ " + String.format("%.2f",sumEBook));
    System.out.println("Summe Hoerbuch:\t€ " + String.format("%.2f",sumAudioBook));
    System.out.println("Summe Alle:\t\t€ " + String.format("%.2f",sumAllBooks));
  }
}
