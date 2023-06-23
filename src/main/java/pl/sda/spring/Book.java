package pl.sda.spring;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    private String title;
    private int releaseDate;
    private String author;


    public void getBookDetails()
    {
        System.out.println("**Published Book Details**");
        System.out.println("Book Title        : " + title);
        System.out.println("Book Author       : " + author);
        System.out.println("Release Date      : " + releaseDate);
    }
}