package de.bht.pr2.lab03.part3;

import de.bht.pr2.lab03.store.AudioBook;
import de.bht.pr2.lab03.store.Book;
import de.bht.pr2.lab03.store.BookStore;
import de.bht.pr2.lab03.store.EBook;

import java.util.List;

public class StreamingAudioBookCount {

  public static void main(String[] args) {
    /* Das Ergebnis der Berechnungen sollte sein:

    Anzahl Hoerbuecher per Streaming: 5

     */
    List<String> soldBookData = BookStore.getSoldBooks();
    List<Book> soldBooks = Book.parseArray(soldBookData);
    int cdAmount = 0;
    for (Book book : soldBooks) {
      if (book instanceof AudioBook) {
        if (((AudioBook) book).getPlaymode().equals("Streaming")) cdAmount++;
      }
    }
    System.out.println("Anzahl Hoerbuecher per Streaming: " + cdAmount);
  }
}
