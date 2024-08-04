package com.camaign.dto;

import com.camaign.entity.Department;
import com.camaign.entity.Subjects;
import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private String id ;

    private String name ;

    private String email ;

    private Department department ;

    private List<Subjects> subjects ;


}
