package az.turing.author_book.controller;

import az.turing.author_book.entity.Author;
import az.turing.author_book.entity.Book;
import az.turing.author_book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id){
        return bookService.getById(id);
    }

    @PostMapping
    public Book save(@Valid @RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable long id){
        return bookService.update(book,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookService.delete(id);
    }
}
