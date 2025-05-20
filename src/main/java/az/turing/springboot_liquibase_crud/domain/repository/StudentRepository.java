package az.turing.springboot_liquibase_crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import az.turing.springboot_liquibase_crud.domain.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
