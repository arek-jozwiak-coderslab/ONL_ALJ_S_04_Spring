package pl.visa.student;

import org.springframework.stereotype.Service;
import pl.visa.student.dto.StudentDTO;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> findAll() {
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

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
