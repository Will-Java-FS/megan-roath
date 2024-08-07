package com.revature.basic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    String email;
    String major;
    int age;
    String password;


    //@Autowired
    //public Student(String email, String major, int age, String password) {
    //    this.email = email;
    //    this.major = major;
    //    this.age=age;
    //    this.password=password;
    //}

}