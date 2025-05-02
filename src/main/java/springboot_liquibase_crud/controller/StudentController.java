package springboot_liquibase_crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot_liquibase_crud.model.StudentDto;
import springboot_liquibase_crud.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(long id){
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto){
        studentService.update(id,studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(long id){
        studentService.deleteByID(id);
    }
}
