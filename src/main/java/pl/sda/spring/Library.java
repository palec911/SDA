package pl.sda.spring;

public class Library
{
    private Book book;
    private Magazine magazine;

    public Library(Magazine magazine) {
        this.magazine = magazine;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Book getBook()
    {
        return book;
    }
    public Magazine getMagazine() {
        return magazine;
    }
    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}