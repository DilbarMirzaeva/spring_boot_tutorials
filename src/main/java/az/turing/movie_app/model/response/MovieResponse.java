package az.turing.movie_app.model.response;

import az.turing.movie_app.domain.enums.MovieGenre;
import az.turing.movie_app.domain.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Long id;

    private String name;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @NotBlank
    @ToString.Exclude
    private String director;

    @NotNull
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private Status status;
}
