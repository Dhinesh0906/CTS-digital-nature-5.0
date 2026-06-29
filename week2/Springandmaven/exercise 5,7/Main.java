package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static class BookRepository {

        public void getBook() {
            System.out.println("Book Repository Working");
        }

        public void showBook() {
            System.out.println("Book Repository Connected");
        }
    }

    public static class BookService {

        private BookRepository bookRepository;

        // Default constructor (Exercise 5)
        public BookService() {
        }

        // Constructor Injection (Exercise 7)
        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
            System.out.println("Constructor Injection Successful");
        }

        // Setter Injection
        public void setBookRepository(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
            System.out.println("Setter Injection Successful");
        }

        // Exercise 5
        public void displayBook() {
            System.out.println("Book Service Working");
            bookRepository.getBook();
        }

        // Exercise 7
        public void display() {
            System.out.println("Book Service Running");
            bookRepository.showBook();
        }
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("========== Exercise 5 ==========");

        BookService setterService =
                context.getBean("bookServiceSetter", BookService.class);

        setterService.displayBook();

        System.out.println();

        System.out.println("========== Exercise 7 ==========");

        BookService constructorService =
                context.getBean("bookServiceConstructor", BookService.class);

        constructorService.display();
    }
}