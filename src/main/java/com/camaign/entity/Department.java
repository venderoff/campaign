package com.camaign.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {

    @Field(name = "'department_name")
    private String departmentName ;

    private String location ;

}
