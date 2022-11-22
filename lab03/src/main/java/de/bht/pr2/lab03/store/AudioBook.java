package de.bht.pr2.lab03.store;

public class AudioBook extends Book{
    String playmode;

    public String getPlaymode() {
        return playmode;
    }

    public void setPlaymode(String playmode) {
        this.playmode = playmode;
    }

    public AudioBook(String title, String type, double price, int edition, String playmode) {
        super(title, type, price, edition);
        this.playmode = playmode;
    }

    public AudioBook(Book book, String playmode) {
        super(book.title, book.type, book.price, book.edition);
        this.playmode = playmode;
    }
}
