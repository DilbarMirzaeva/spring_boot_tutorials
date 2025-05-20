package az.turing.movie_app.mapper;

import az.turing.movie_app.domain.entity.MovieEntity;
import az.turing.movie_app.model.response.MovieResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper extends EntityMapper<MovieEntity, MovieResponse> {

    @Override
    MovieResponse toDto(MovieEntity entity);

    @Override
     MovieEntity toEntity(MovieResponse dto);
}
