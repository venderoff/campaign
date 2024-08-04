package com.camaign.service.impl;

import com.camaign.dto.StudentDto;
import com.camaign.entity.Student;
import com.camaign.repository.StudentRepository;
import com.camaign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository ;
    @Override
    public StudentDto CreateStudent(StudentDto studentDto) {

        StudentDto dto =  MaptoDto(studentDto) ;
//        dto.setDepartment(studentDto.getDepartment());
//        dto.setName(studentDto.getName());
//        dto.setEmail(studentDto.getEmail());
//        dto.setSubjects(studentDto.getSubjects());


//
//        Student student = new Student() ;
//        student.setDepartment(dto.getDepartment());
//        student.setEmail(dto.getEmail());
//        student.setSubjects(dto.getSubjects());
//        student.setName(dto.getName());

        Student ent =
//      repository.save(student) ;
      repository.save(MapToEntity(dto)) ;

//         StudentDto resp = new StudentDto() ;
//         resp.setSubjects(ent.getSubjects());
//         resp.setId(ent.getId());
//         resp.setDepartment(ent.getDepartment());
//         resp.setEmail(ent.getEmail());
//          resp.setName(ent.getName());

//        return resp;
        return MapToResp(Optional.of(ent));
    }

    @Override
    public StudentDto FindById(String id) {
        Optional<Student> st =
        repository.findById(id) ;


        return MapToResp(st);
    }

    @Override
    public List<StudentDto> Alldocument() {

        List<Student> list = repository.findAll() ;



        return list.stream()

                .sorted(Comparator.comparing(Student::getName))
                .map(ent -> {
            return MapToResp(Optional.ofNullable(ent));
//            StudentDto dt = new StudentDto();
//            dt.setName(ent.getName());
//            dt.setId(ent.getId());
//            dt.setSubjects(ent.getSubjects());
//            dt.setDepartment(ent.getDepartment());
//            dt.getEmail()ent.getEmail();
        })

                .collect(Collectors.toList()) ;
    }

    @Override
    public StudentDto Update(StudentDto studentDto) {

        return MapToResp(Optional.of(repository.save(MapToEntity(studentDto))));
    }

    @Override
    public List<StudentDto> findByName(String name) {
        List<Student> list =
        repository.findByName(name) ;

        return list.stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(student -> {
                    return MapToResp(Optional.of(student));
                        })
                .collect(Collectors.toList()) ;
    }

    @Override
    public List<StudentDto> findByNameAndEmail(String name, String email) {



        List<Student> list = repository.findByNameAndEmail(name,email) ;

        return list.stream()
                .sorted(Comparator.comparing(Student::getName))
                .map( st -> {
                    return MapToResp(Optional.of(st));
                        })
                .collect(Collectors.toList()) ;
    }

    public StudentDto MaptoDto(StudentDto studentDto){

        StudentDto dto =  new StudentDto() ;
        dto.setDepartment(studentDto.getDepartment());
        dto.setName(studentDto.getName());
        dto.setEmail(studentDto.getEmail());
        dto.setSubjects(studentDto.getSubjects());


        return dto ;
    }

    public Student MapToEntity(StudentDto dto){

        Student student = new Student() ;
        student.setId(dto.getId());
        student.setDepartment(dto.getDepartment());
        student.setEmail(dto.getEmail());
        student.setSubjects(dto.getSubjects());
        student.setName(dto.getName());

        return  student ;

    }

    public StudentDto MapToResp(Optional<Student> ent) {


        StudentDto resp = new StudentDto() ;
        resp.setSubjects(ent.get().getSubjects());
        resp.setId(ent.get().getId());
        resp.setDepartment(ent.get().getDepartment());
        resp.setEmail(ent.get().getEmail());
        resp.setName(ent.get().getName());

        return  resp ;

    }

}
