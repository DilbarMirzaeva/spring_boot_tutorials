package az.turing.author_book.controller;

import az.turing.author_book.entity.Author;
import az.turing.author_book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable long id){
        return authorService.getById(id);
    }

    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable long id){
        return authorService.update(author,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        authorService.delete(id);
    }

}
