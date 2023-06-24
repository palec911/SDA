package pl.sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application
{
    public static void main(String args[])
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Library library = (Library) appContext.getBean("library");
        library.getBook().getBookDetails();
        library.getMagazine().getMagazineDetails();
    }
}