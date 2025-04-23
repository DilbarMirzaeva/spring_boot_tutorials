package az.turing.author_book.service;

import az.turing.author_book.entity.Author;
import az.turing.author_book.entity.Book;
import az.turing.author_book.exception.ResourceNotFoundException;
import az.turing.author_book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void delete(long id){
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book Not Found!");
        }
        bookRepository.deleteById(id);
    }

    public Book update(Book newBook,long id){
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setIsbn(newBook.getIsbn());
                    book.setAuthor(newBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElseThrow(()->new ResourceNotFoundException("Book not found!"));
    }
}
