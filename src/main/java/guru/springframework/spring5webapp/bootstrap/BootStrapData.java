package guru.springframework.spring5webapp.bootstrap;


import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;

        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher holyPress = new Publisher("Holy Press", "Rua Shalon 36", "Nazaré","Cesaréia", "123456");
        publisherRepository.save(holyPress);

        Author josias = new Author("Josias", "Da Josete");
        Book historiasDoJubileu = new Book("Histórias do jubileu","123456");

        josias.getBooks().add(historiasDoJubileu);
        historiasDoJubileu.getAuthors().add(josias);
        historiasDoJubileu.setPublisher(holyPress);
        holyPress.getBooks().add(historiasDoJubileu);

        authorRepository.save(josias);
        bookRepository.save(historiasDoJubileu);

        Author malaquias = new Author("Malaquias", "Da Bíblia");
        Book altasAventurasMalaquias = new Book("Altas Aventuras do malaquias","1357911");
        altasAventurasMalaquias.setPublisher(holyPress);
        holyPress.getBooks().add(altasAventurasMalaquias);

        authorRepository.save(malaquias);
        bookRepository.save(altasAventurasMalaquias);


        System.out.println("Bootstrapping started");
        System.out.println("Number of Books " + bookRepository.count() + "\nNumber of authors " +authorRepository.count() +
                "\nNumber of publishers " +publisherRepository.count() +"\nNumber of boots on publisher " + holyPress.getBooks().size());


    }
}
