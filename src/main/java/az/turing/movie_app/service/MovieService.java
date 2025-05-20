package az.turing.movie_app.service;

import az.turing.movie_app.domain.entity.MovieEntity;
import az.turing.movie_app.domain.repository.MovieRepo;
import az.turing.movie_app.exception.AlreadyExistsException;
import az.turing.movie_app.mapper.MovieMapper;
import az.turing.movie_app.model.request.CreateMovieRequest;
import az.turing.movie_app.model.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepo movieRepo;

    public MovieResponse saveMovie(CreateMovieRequest request){
        if(movieRepo.existsByNameAndDirector(request.getName(),request.getDirector())){
             throw new AlreadyExistsException("Movie already exists");
        }
        MovieEntity movieEntity=MovieEntity.builder()
                .name(request.getName())
                .movieGenre(request.getGenre())
                .director(request.getDirector())
                .duration(request.getDuration())
                .status(request.getStatus())
                .description(request.getDescription())
                .build();
        movieRepo.save(movieEntity);
        return movieMapper.toDto(movieEntity);
    }
}
