package springboot_liquibase_crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_liquibase_crud.domain.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
