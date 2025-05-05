package springboot_liquibase_crud.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springboot_liquibase_crud.model.CourseDto;
import springboot_liquibase_crud.model.StudentDto;
import springboot_liquibase_crud.service.StudentService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentServiceMock;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void aveStudent_ShouldCallServiceAndReturnCreatedStatus() {

        StudentDto studentDto=new StudentDto();
        studentDto.setId(1L);
        studentDto.setName("Ave");
        studentDto.setSurname("Kaldiroglu");
        studentDto.setEmail("<EMAIL>");
        studentDto.setPhoneNumber("05555555555");
        studentDto.setCourse(new CourseDto(1L,"Physics"));

        studentController.saveStudent(studentDto);

        verify(studentServiceMock).save(studentDto);
    }
}