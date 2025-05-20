package az.turing.springboot_liquibase_crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import az.turing.springboot_liquibase_crud.domain.entity.CourseEntity;
import az.turing.springboot_liquibase_crud.model.response.CourseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper extends EntityMapper<CourseDto, CourseEntity> {

    @Override
    CourseEntity toEntity(CourseDto courseDto);

    @Override
    List<CourseEntity> toEntity(List<CourseDto> courseDtoList);

    @Override
    CourseDto toDto(CourseEntity course);

    @Override
    List<CourseDto> toDto(List<CourseEntity> courseList);

}
