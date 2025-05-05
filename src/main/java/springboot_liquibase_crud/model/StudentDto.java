package springboot_liquibase_crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private CourseDto course;
}
