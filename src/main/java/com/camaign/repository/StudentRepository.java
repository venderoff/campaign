package com.camaign.repository;

import com.camaign.dto.StudentDto;
import com.camaign.entity.Student;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

//find by name
    List<Student> findByName(String name) ;

    //using AND query
    List<Student> findByNameAndEmail(String name, String email) ;
}