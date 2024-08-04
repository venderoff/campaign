package com.camaign.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subjects {

@Field(name = "subject_name")
    private String subjectName ;

@Field(name = "marks_obtained")
    private String marks;

}
