package az.turing.springboot_liquibase_crud.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "students")
public class StudentEntity extends BaseEntity{

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name",nullable = false)
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    @Column(name = "surname",nullable = false)
    private String surname;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

}
