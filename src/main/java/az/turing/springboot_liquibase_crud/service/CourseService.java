package az.turing.springboot_liquibase_crud.service;

import az.turing.springboot_liquibase_crud.model.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import az.turing.springboot_liquibase_crud.domain.entity.CourseEntity;
import az.turing.springboot_liquibase_crud.domain.repository.CourseRepository;
import az.turing.springboot_liquibase_crud.exception.AlreadyExistsException;
import az.turing.springboot_liquibase_crud.exception.NotFoundException;
import az.turing.springboot_liquibase_crud.mapper.CourseMapper;
import az.turing.springboot_liquibase_crud.model.response.CourseDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper courseMapper;

    public CourseDto save(CourseRequest courseRequest) {
        if(repository.existsByName(courseRequest.getName())){
            throw new AlreadyExistsException("Course already exists");
        }
        CourseEntity course=new CourseEntity();
        course.setName(courseRequest.getName());
        CourseEntity savedCourse=repository.save(course);
        return courseMapper.toDto(savedCourse);
    }

    public void deleteById(Long id){
        if(!repository.existsById(id)){
            throw new NotFoundException("Course not found with id :"+id);
        }
        repository.deleteById(id);
    }

    public CourseDto getById(Long id){
        return courseMapper.toDto(repository.findById(id).orElse(null));
    }

    public List<CourseDto> getAll(){
        return courseMapper.toDto(repository.findAll());
    }

    public void update(long id,CourseRequest courseRequest){
        CourseEntity courseEntity=repository.findById(id)
                .orElseThrow(()->new NotFoundException("Course not found with id :"+id));
        courseEntity.setName(courseRequest.getName());
        repository.save(courseEntity);
    }

}
