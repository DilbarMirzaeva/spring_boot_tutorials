package springboot_liquibase_crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import springboot_liquibase_crud.domain.entity.StudentEntity;
import springboot_liquibase_crud.model.StudentDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDto, StudentEntity> {

    @Override
    StudentEntity toEntity(StudentDto studentDto);

    @Override
    List<StudentEntity> toEntity(List<StudentDto> studentDtoList);

    @Override
    StudentDto toDto(StudentEntity student);

    @Override
    List<StudentDto> toDto(List<StudentEntity> studentList);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(StudentDto studentDto,@MappingTarget StudentEntity studentEntity);
}
