package de.bht.pr2.lab03.part4;

import de.bht.pr2.lab03.store.*;

import java.util.HashSet;
import java.util.List;

public class GroupByBookType {

  public static void main(String[] args) {
    /* Das Ergebnis der Berechnungen sollte sein:

Buecher Anzahl: 6
	Buch: 7 Minuten am Tag (2016)
	Buch: Der Heimweg (2016)
	Buch: Ohne Schuld (2020)
	Buch: Escape Room (2020)
	Buch: Der Heimweg (2020)
	Buch: Ohne Schuld (2016)
Ebuecher Anzahl: 4
	Ebuch: Ohne Schuld (2020)
	Ebuch: Der Heimweg (2020)
	Ebuch: Zwei Handvoll Leben (2020)
	Ebuch: Kingsbridge - Der Morgen einer neuen Zeit (2020)
Hoerbuecher Anzahl: 5
	Hoerbuch: QualityLand 2.0 (2019)
	Hoerbuch: Funken Mord (2018)
	Hoerbuch: QualityLand 2.0 (2018)
	Hoerbuch: Funken Mord (2019)
	Hoerbuch: Harry Potter - alle 7 Baende (2018)

     */

    HashSet<Book> bookList = new HashSet<>();
    HashSet<Book> eBookList = new HashSet<>();
    HashSet<Book> audioBookList = new HashSet<>();
    List<String> soldBookData = BookStore.getSoldBooks();
    List<Book> soldBooks = Book.parseArray(soldBookData);
    for (Book book : soldBooks) {
      if (book instanceof EBook) eBookList.add(book);
      else if (book instanceof AudioBook) audioBookList.add(book);
      else bookList.add(book);
    }
    System.out.println("Buecher Anzahl: " + bookList.size());
    for (Book book : bookList) System.out.println("  " + book.getType() + ": " + book.getTitle() + " (" + book.getEdition() + ")");
    System.out.println("Ebuecher Anzahl: " + eBookList.size());
    for (Book book : eBookList) System.out.println("  " + book.getType() + ": " + book.getTitle() + " (" + book.getEdition() + ")");
    System.out.println("Hoerbuecher Anzahl: " + audioBookList.size());
    for (Book book : audioBookList) System.out.println("  " + book.getType() + ": " + book.getTitle() + " (" + book.getEdition() + ")");

  }
}
