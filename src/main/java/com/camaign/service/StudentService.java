package com.camaign.service;

import com.camaign.dto.RespStudent;
import com.camaign.dto.StudentDto;
import com.camaign.entity.Student;

import java.util.List;

public interface StudentService {

    public StudentDto CreateStudent(StudentDto studentDto) ;

    public StudentDto FindById(String id) ;

    public List<RespStudent> Alldocument(int pageNo);

    public StudentDto Update (StudentDto studentDto) ;

    //find by name
    public List<StudentDto> findByName(String name) ;



     //AND query

    public List<StudentDto> findByNameAndEmail(String name, String email) ;

    // OR Query
    public List<StudentDto> findByNameOrEmail(String name, String email) ;
}

