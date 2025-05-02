package springboot_liquibase_crud.mapper;

import springboot_liquibase_crud.domain.entity.CourseEntity;
import springboot_liquibase_crud.model.CourseDto;

import java.util.List;

public interface EntityMapper<D,E> {

    E toEntity(D d) ;

    D toDto(E e);

    List<E> toEntity(List<D> e);

    List<D> toDto(List<E> d);

}
