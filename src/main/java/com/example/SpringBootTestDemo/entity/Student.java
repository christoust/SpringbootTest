package com.example.SpringBootTestDemo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "Name should not be blank")
    @Column(name = "NAME")
    private String name;
    @Column(name= "ADDRESS")
    private String address;
    @Column(name = "ROLLNO")
    private String rollNo;


//    public Object thenReturn(Student student) {
//    }
}
