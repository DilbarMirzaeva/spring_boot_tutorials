package az.turing.springboot_liquibase_crud.service;

import az.turing.springboot_liquibase_crud.domain.entity.CourseEntity;
import az.turing.springboot_liquibase_crud.domain.repository.CourseRepository;
import az.turing.springboot_liquibase_crud.exception.NotFoundException;
import az.turing.springboot_liquibase_crud.model.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import az.turing.springboot_liquibase_crud.domain.entity.StudentEntity;
import az.turing.springboot_liquibase_crud.domain.repository.StudentRepository;
import az.turing.springboot_liquibase_crud.mapper.StudentMapper;
import az.turing.springboot_liquibase_crud.model.response.StudentDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseRepository courseRepository;

    public StudentDto save(StudentRequest studentRequest) {
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(studentRequest.getName());
        studentEntity.setSurname(studentRequest.getSurname());
        studentEntity.setEmail(studentRequest.getEmail());
        CourseEntity courseEntity=courseRepository.findById(studentRequest.getCourseId()).orElse(null);
        studentEntity.setCourse(courseEntity);
        studentEntity.setPhoneNumber(studentRequest.getPhoneNumber());
        StudentEntity savedStudent=studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudent);
    }

    public List<StudentDto> getAll(){
       return studentMapper.toDto(studentRepository.findAll());
    }

    public void deleteByID(long id){
        if ( !studentRepository.existsById(id)){
            throw new NotFoundException("Student not found with id :"+id);
        }
        studentRepository.deleteById(id);
    }

    public StudentDto getById(long id){
        if ( !studentRepository.existsById(id)){
            throw new NotFoundException("Student not found with id :"+id);
        }
        return studentMapper.toDto(studentRepository.findById(id).orElse(null));
    }

    public void update(long id,StudentRequest studentRequest){
        StudentEntity studentEntity=studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
        studentEntity.setName(studentRequest.getName());
        studentEntity.setSurname(studentRequest.getSurname());
        studentEntity.setEmail(studentRequest.getEmail());
        studentEntity.setPhoneNumber(studentRequest.getPhoneNumber());
        CourseEntity courseEntity=courseRepository.findById(studentRequest.getCourseId()).orElse(null);
        studentEntity.setCourse(courseEntity);
        studentRepository.save(studentEntity);
    }
}
