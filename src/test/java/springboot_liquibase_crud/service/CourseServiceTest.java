package springboot_liquibase_crud.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import springboot_liquibase_crud.domain.entity.CourseEntity;
import springboot_liquibase_crud.domain.repository.CourseRepository;
import springboot_liquibase_crud.mapper.CourseMapper;
import springboot_liquibase_crud.model.CourseDto;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseMapper courseMapper;

    @InjectMocks
    private CourseService courseService;

    @Test
    public void testSaveMethod(){
        CourseDto courseDto=new CourseDto(1L,"Physics");
        CourseEntity course=new CourseEntity();
        course.setId(1L);
        course.setName("Physics");

        when(courseMapper.toEntity(courseDto)).thenReturn(course);

        courseService.save(courseDto);

        Mockito.verify(courseRepository).save(course);
    }



}