package library.librarymanagmementsystem.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String title ;
    String author ;
    String publicationYear ;
    String ISPN ;

}
