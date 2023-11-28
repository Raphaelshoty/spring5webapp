package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String adressLine;

    private String city;

    private String state;

    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher" )
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String adressLine, String city, String state, String zip) {
        this.name = name;
        this.adressLine = adressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Publisher(String name, String adressLine, String city, String state, String zip, Set<Book> books) {
        this.name = name;
        this.adressLine = adressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdressLine() {
        return adressLine;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setAdressLine(String adressLine) {
        this.adressLine = adressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Publisher{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", adressLine='").append(adressLine).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", zip='").append(zip).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
