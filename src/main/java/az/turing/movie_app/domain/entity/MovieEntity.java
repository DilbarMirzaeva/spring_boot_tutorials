package az.turing.movie_app.domain.entity;

import az.turing.movie_app.domain.enums.MovieGenre;
import az.turing.movie_app.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Table(name="movie")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "movie_seq")
    @SequenceGenerator(name="movie_seq",sequenceName = "movie_seq",allocationSize = 1)
    private Long id;

    @Column(name="name",nullable = false,unique = true)
    private String name;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="genre",nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @ToString.Exclude
    @Column(name="director",nullable = false)
    private String director;

    @Column(name="duration",nullable = false)
    private Integer duration;

    @Column(name="movie_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TicketEntity> tickets;
}
