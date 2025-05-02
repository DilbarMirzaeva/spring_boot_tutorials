package springboot_liquibase_crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import springboot_liquibase_crud.domain.entity.CourseEntity;
import springboot_liquibase_crud.model.CourseDto;

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

    @Mapping(target = "id",ignore = true)
    void updateEntityFromDto(CourseDto courseDto,@MappingTarget CourseEntity courseEntity);
}
