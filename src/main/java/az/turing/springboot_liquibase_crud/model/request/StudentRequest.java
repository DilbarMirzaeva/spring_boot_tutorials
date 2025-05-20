package az.turing.springboot_liquibase_crud.model.request;

import az.turing.springboot_liquibase_crud.model.response.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Long courseId;
}
