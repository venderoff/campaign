package com.camaign.controller;


import com.camaign.dto.StudentDto;
import com.camaign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService service ;
    @PostMapping("/add")
    public ResponseEntity<StudentDto> CreateStudent(@RequestBody StudentDto studentDto){


        return new ResponseEntity<>(service.CreateStudent(studentDto), HttpStatus.CREATED) ;
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<StudentDto> GetById(@PathVariable("id") String id) {
        return  new ResponseEntity<>(service.FindById(id),HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAll(){

        return new ResponseEntity<>(service.Alldocument(), HttpStatus.valueOf(200));
    }

    @PostMapping("/update")
    public StudentDto update(@RequestBody  StudentDto studentDto) {

        return new ResponseEntity<>(service.Update(studentDto), HttpStatus.CREATED).getBody();

    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<StudentDto>> findByName(@PathVariable("name") String name){


        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK) ;
    }

    @GetMapping("/findByNameAndEmail")
    public ResponseEntity<List<StudentDto>> findByNameEmail(@RequestParam ("name") String name,
                                                      @RequestParam("email") String email){

        return new ResponseEntity<>(service.findByNameAndEmail(name, email), HttpStatus.OK) ;
    }
}