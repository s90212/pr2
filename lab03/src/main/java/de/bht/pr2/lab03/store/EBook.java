package de.bht.pr2.lab03.store;

public class EBook extends Book {
    int tVersion;

    public int gettVersion() {
        return tVersion;
    }

    public void settVersion(int tVersion) {
        this.tVersion = tVersion;
    }

    public EBook(String title, String type, double price, int edition, int tVersion) {
        super(title, type, price, edition);
        this.tVersion = tVersion;
    }
    public EBook(Book book, int tVersion) {
        super(book.title, book.type, book.price, book.edition);
        this.tVersion = tVersion;
    }
}
