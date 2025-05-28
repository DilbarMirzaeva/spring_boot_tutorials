package springboot_liquibase_crud.service;

import az.turing.springboot_liquibase_crud.domain.entity.CourseEntity;
import az.turing.springboot_liquibase_crud.domain.repository.CourseRepository;
import az.turing.springboot_liquibase_crud.mapper.CourseMapper;
import az.turing.springboot_liquibase_crud.model.request.CourseRequest;
import az.turing.springboot_liquibase_crud.model.response.CourseDto;
import az.turing.springboot_liquibase_crud.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
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
     void testSaveMethod(){
        CourseRequest courseRequest=new CourseRequest("Physics");

        CourseEntity course=new CourseEntity();
        course.setName("Physics");

        CourseEntity savedCourse=new CourseEntity();
        savedCourse.setId(1L);
        savedCourse.setName("Physics");

        CourseDto expectedCourseDto=new CourseDto(1L,"Physics");

        when(courseRepository.save(course)).thenReturn(savedCourse);
        when(courseRepository.existsByName("Physics")).thenReturn(false);
        when(courseMapper.toDto(savedCourse)).thenReturn(expectedCourseDto);

        CourseDto actualCourseDto=courseService.save(courseRequest);

        assertEquals(expectedCourseDto,actualCourseDto);

        verify(courseRepository).save(course);
        verify(courseMapper).toDto(savedCourse);
        verify(courseRepository).existsByName("Physics");
    }



}