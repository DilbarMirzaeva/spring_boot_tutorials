package az.turing.movie_app.exception;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<GlobalResponse> alreadyExistsException(AlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                GlobalResponse.builder()
                        .message(e.getMessage())
                        .error(ErrorMessage.MOVIE_ALREADY_EXISTS)
                        .uuid(UUID.randomUUID())
                        .timeStamp(LocalDateTime.now())
                        .build()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalResponse> notFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                GlobalResponse.builder()
                        .message(e.getMessage())
                        .error(ErrorMessage.MOVIE_NOT_FOUND)
                        .uuid(UUID.randomUUID())
                        .timeStamp(LocalDateTime.now())
                        .build()
        );
    }

}
