package az.turing.movie_app.model.request;

import az.turing.movie_app.domain.enums.MovieGenre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovieRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @NotBlank
    private String director;

    @NotNull
    private Integer duration;

}
