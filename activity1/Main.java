public class Main {
    public static void main(String[] args) {

        Book b1 = new Book();
        b1.title = "One Piece";
        b1.author = "Eiichiro Oda";
        b1.isbn = "978-1-4215-6074-8";
        b1.publicationDate = "December 24, 1997";

        Book b2 = new Book();
        b2.title = "Naruto";
        b2.author = "Masashi Kishimoto";
        b2.isbn = "978-1569319000";
        b2.publicationDate = "September 21, 1999";
        

        
        Book book1 = new Book("One Piece", "Eiichiro Oda", "978-1-4215-6074-8", "December 24, 1997");
        Book book2 = new Book("Naruto", "Masashi Kishimoto", "978-1569319000", "September 21, 1999");

        
        System.out.println("The title is " + book1.title + ", The author is " + book1.author + ", The Book ISBN is " + book1.isbn + ", The publication date is " + book1.publicationDate);
                           

        
        System.out.println("Displaying Book 1");
        book1.displayInfo();
        
        System.out.println("Displaying Book 2");
        book2.displayInfo();
    }
}
