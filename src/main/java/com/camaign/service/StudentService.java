package com.camaign.service;

import com.camaign.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public StudentDto CreateStudent(StudentDto studentDto) ;

    public StudentDto FindById(String id) ;

    public List<StudentDto> Alldocument();

    public StudentDto Update (StudentDto studentDto) ;

    //find by name
    public List<StudentDto> findByName(String name) ;

     //AND query

    public List<StudentDto> findByNameAndEmail(String name, String email) ;
}
