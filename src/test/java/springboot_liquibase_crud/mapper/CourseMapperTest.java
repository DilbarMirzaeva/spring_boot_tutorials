package springboot_liquibase_crud.mapper;

import az.turing.springboot_liquibase_crud.domain.entity.CourseEntity;
import az.turing.springboot_liquibase_crud.mapper.CourseMapper;
import az.turing.springboot_liquibase_crud.model.response.CourseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CourseMapperTest {

    private CourseMapper courseMapper= Mappers.getMapper(CourseMapper.class);;

    @Test
    void toEntityTest(){
        //Arrange
        CourseDto courseDto=new CourseDto(1L,"Physics");

        CourseEntity expectedCourseEntity=new CourseEntity();
        expectedCourseEntity.setId(1L);
        expectedCourseEntity.setName("Physics");

        //Act
        CourseEntity actualCourseEntity=courseMapper.toEntity(courseDto);

        //Assert
        assertEquals(expectedCourseEntity,actualCourseEntity);
    }

    @Test
    void toDtoTest(){
        //Arrange
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setId(1L);
        courseEntity.setName("Physics");

        CourseDto expectedCourseDto=new CourseDto(1L,"Physics");

        //Act
        CourseDto actualCourseDto=courseMapper.toDto(courseEntity);

        //Assert
        assertEquals(expectedCourseDto,actualCourseDto);

    }

}