package az.turing.movie_app.service;

import az.turing.movie_app.domain.entity.MovieEntity;
import az.turing.movie_app.domain.enums.Status;
import az.turing.movie_app.domain.repository.MovieRepo;
import az.turing.movie_app.exception.AlreadyExistsException;
import az.turing.movie_app.exception.NotFoundException;
import az.turing.movie_app.mapper.MovieMapper;
import az.turing.movie_app.model.request.CreateMovieRequest;
import az.turing.movie_app.model.request.UpdateMovieRequest;
import az.turing.movie_app.model.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepo movieRepo;

    public MovieResponse saveMovie(CreateMovieRequest request) {
        if (movieRepo.existsByNameAndDirector(request.getName(), request.getDirector())) {
            throw new AlreadyExistsException("Movie already exists");
        }
        MovieEntity movieEntity = MovieEntity.builder()
                .name(request.getName())
                .movieGenre(request.getMovieGenre())
                .director(request.getDirector())
                .duration(request.getDuration())
                .status(request.getStatus())
                .description(request.getDescription())
                .build();
        MovieEntity savedMovie=movieRepo.save(movieEntity);
        return movieMapper.toDto(movieEntity);
    }

    public MovieResponse updateMovie(Long id, UpdateMovieRequest request) {
        MovieEntity movieEntity = getMovieById(id);

        movieEntity.setDescription(request.getDescription());
        movieEntity.setMovieGenre(request.getMovieGenre());
        movieEntity.setDirector(request.getDirector());
        movieEntity.setDuration(request.getDuration());
        movieEntity.setName(request.getName());

        MovieEntity updatedMovie=movieRepo.save(movieEntity);
        return movieMapper.toDto(movieEntity);
    }

    public List<MovieResponse> getAllMovie(){
        return movieRepo.findAll().stream().filter(movieEntity -> movieEntity.getStatus()==Status.AVAILABLE)
                .map(movieMapper::toDto).toList();
    }

    public MovieResponse getByIdMovie(Long id){
        MovieEntity movieEntity=getMovieById(id);
        return movieMapper.toDto(movieEntity);
    }

    public void deleteMovie(Long id){
        MovieEntity movie=getMovieById(id);
        movie.setStatus(Status.NOT_AVAILABLE);
        movieRepo.save(movie);
    }

    public MovieEntity getMovieById(Long id){
        return movieRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Movie not found"));
    }

}