package az.turing.movie_app.domain.repository;

import az.turing.movie_app.domain.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public interface MovieRepo extends JpaRepository<MovieEntity,Long> {
    boolean existsByNameAndDirector(String name,String director);
}
