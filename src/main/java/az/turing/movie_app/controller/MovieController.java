package az.turing.movie_app.controller;

import az.turing.movie_app.mapper.MovieMapper;
import az.turing.movie_app.model.request.CreateMovieRequest;
import az.turing.movie_app.model.request.UpdateMovieRequest;
import az.turing.movie_app.model.response.MovieResponse;
import az.turing.movie_app.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<MovieResponse> update(@RequestParam Long id, @Valid @RequestBody UpdateMovieRequest updateMovieRequest){
        return ResponseEntity.ok(movieService.updateMovie(id,updateMovieRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponse>> getAll(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getByIdMovie(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
