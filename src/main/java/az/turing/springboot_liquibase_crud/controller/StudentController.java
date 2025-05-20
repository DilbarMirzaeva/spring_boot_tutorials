package az.turing.springboot_liquibase_crud.controller;

import az.turing.springboot_liquibase_crud.model.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import az.turing.springboot_liquibase_crud.model.response.StudentDto;
import az.turing.springboot_liquibase_crud.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentRequest studentRequest){
       return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest){
        studentService.update(id,studentRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
