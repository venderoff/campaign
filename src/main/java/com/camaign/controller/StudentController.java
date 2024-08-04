package com.camaign.controller;


import com.camaign.dto.RespStudent;
import com.camaign.dto.StudentDto;
import com.camaign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<RespStudent>> getAll(@RequestParam("pageNo") int pageNo){

        return new ResponseEntity<>(service.Alldocument(pageNo), HttpStatus.valueOf(200));
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

    @GetMapping("/findByNameOrEmail")
    public ResponseEntity<List<StudentDto>> findByNameOrEmail(@RequestParam ("name") String name,
                                                            @RequestParam("email") String email){

        return new ResponseEntity<>(service.findByNameOrEmail(name, email), HttpStatus.OK) ;
    }

    @GetMapping("/sort")
 public ResponseEntity<List<StudentDto>> Sorting(){

        return new ResponseEntity<>(service.sorting(),HttpStatus.OK) ;

 }

 // by subdocument

    @GetMapping("/dept")
    public ResponseEntity<List<StudentDto>> findByDepartment(@RequestParam("depatName") String deptName) {

        return new ResponseEntity<>(service.findByDepartName(deptName), HttpStatus.valueOf(200));
    }

    // Cearch  by arrays
    @GetMapping("/subject")
    public ResponseEntity<List<StudentDto>> subjectName(@RequestParam ("name") String name){

        return new ResponseEntity<>(service.findBySubjects(name), HttpStatus.valueOf(200)) ;
    }

}
