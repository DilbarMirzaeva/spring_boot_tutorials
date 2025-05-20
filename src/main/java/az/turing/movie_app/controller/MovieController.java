package az.turing.movie_app.controller;

import az.turing.movie_app.mapper.MovieMapper;
import az.turing.movie_app.model.request.CreateMovieRequest;
import az.turing.movie_app.model.response.MovieResponse;
import az.turing.movie_app.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@Validated
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody CreateMovieRequest createMovieRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.saveMovie(createMovieRequest));
    }
}
