package az.turing.author_book.service;

import az.turing.author_book.entity.Author;
import az.turing.author_book.exception.ResourceNotFoundException;
import az.turing.author_book.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author getById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public void delete(long id){
        if(!authorRepository.existsById(id)){
            throw new ResourceNotFoundException("Author Not Found!");
        }
        authorRepository.deleteById(id);
    }

    public Author update(Author newAuthor,long id){
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setEmail(newAuthor.getEmail());
                    author.setBooks(newAuthor.getBooks());
                    return authorRepository.save(author);
                })
                .orElseThrow(()->new ResourceNotFoundException("Author Not Found!"));
    }

}
