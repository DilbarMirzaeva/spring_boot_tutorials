package az.turing.springboot_liquibase_crud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "courses")
public class CourseEntity extends BaseEntity{

    @Column(name="name", nullable=false)
    private String name;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<StudentEntity> studentList;
}
