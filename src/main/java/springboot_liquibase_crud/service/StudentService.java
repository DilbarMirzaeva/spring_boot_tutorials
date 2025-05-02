package springboot_liquibase_crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot_liquibase_crud.domain.entity.StudentEntity;
import springboot_liquibase_crud.domain.repository.StudentRepository;
import springboot_liquibase_crud.mapper.StudentMapper;
import springboot_liquibase_crud.model.StudentDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public void save(StudentDto studentDto) {
       StudentEntity studentEntity= studentMapper.toEntity(studentDto);
        studentRepository.save(studentEntity);
    }

    public List<StudentDto> getAll(){
        return studentMapper.toDto(studentRepository.findAll());
    }

    public void deleteByID(long id){
        studentRepository.deleteById(id);
    }

    public StudentDto getById(long id){
        return studentMapper.toDto(studentRepository.findById(id).orElse(null));
    }

    public void update(long id,StudentDto studentDto){
        StudentEntity studentEntity=studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
        studentMapper.updateEntityFromDto(studentDto,studentEntity);
    }
}
