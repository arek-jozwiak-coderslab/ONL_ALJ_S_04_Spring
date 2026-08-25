package pl.visa.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/")
    public List<StudentDTO> list() {
        return studentRepository.findAll().
                stream().
                map(s -> {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(s.getId());
                    studentDTO.setFirstName(s.getFirstName());
                    studentDTO.setLastName(s.getLastName());
                    return studentDTO;
                }).toList();
    }
}
