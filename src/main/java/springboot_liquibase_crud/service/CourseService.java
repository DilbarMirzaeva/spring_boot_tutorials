package springboot_liquibase_crud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springboot_liquibase_crud.domain.entity.CourseEntity;
import springboot_liquibase_crud.domain.repository.CourseRepository;
import springboot_liquibase_crud.mapper.CourseMapper;
import springboot_liquibase_crud.model.CourseDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper courseMapper;

    public void save(CourseDto courseDto) {
        repository.save(courseMapper.toEntity(courseDto));

    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public CourseDto getById(Long id){
        return courseMapper.toDto(repository.findById(id).orElse(null));
    }

    public List<CourseDto> getAll(){
        return courseMapper.toDto(repository.findAll());
    }

    public void update(long id,CourseDto courseDto){
        CourseEntity courseEntity=repository.findById(id).orElse(null);
        courseMapper.updateEntityFromDto(courseDto,courseEntity);
    }

}
