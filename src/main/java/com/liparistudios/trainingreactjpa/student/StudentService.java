package com.liparistudios.trainingreactjpa.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepo;

    @Autowired
    public StudentService( StudentRepository repo ) {
        this.studentRepo = repo;
    }

    public List<Student> getStudents() {
        /*
        return List.of(
                new Student(
                    1l,
                    "Vito",
                    "vito@mail.com",
                    LocalDate.of(1981, Month.APRIL, 25 ),
                    41
                )
        );
        */
        return this.studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepo.findStudentByEmail( student.getEmail() );
        if( studentByEmail.isPresent() ) {
            throw new IllegalStateException("Email già presente");
        }
        System.out.println("arriva un salvataggio per student");
        System.out.println(student);
        studentRepo.save( student );
        System.out.println(student);
    }


    public void deleteStudent(Long studentId) {
        boolean isPresent = studentRepo.existsById( studentId );
        if( !isPresent ) {
            throw new IllegalStateException("Id inesistente ["+ studentId +"]");
        }
        studentRepo.deleteById( studentId );

    }


    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student =
                studentRepo
                        .findById( id )
                        .orElseThrow( () -> {
                            System.out.println("eccezione");
                            return (new IllegalStateException("Id dello studente non trovato"));
                        })
        ;

        if(
                name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)
        ) {
            student.setName( name );
        }

        if(
                email != null &&
                        email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)
        ) {

            // controllo email
            Optional<Student> studentByEmail = studentRepo.findStudentByEmail( email );
            if( studentByEmail.isPresent() ) {
                throw new IllegalStateException("Email già esistente");
            }

            student.setEmail( email );
        }





    }
}
