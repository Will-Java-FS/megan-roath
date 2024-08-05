package com.revature.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
//@Data
@Table(name="users")
//@AllArgsConstructor
//@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Integer userid;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;

    @Autowired
    Users(){

    }

    @Autowired
    Users(String name, String password){
        this.name=name;
        this.password=password;
    }

    @Autowired
    Users(Integer id, String name, String password){
        this.userid=id;
        this.name=name;
        this.password=password;
    }

    public long getId() {
        return this.userid;
    }

    public void setId(Integer id) {
        this.userid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int passwordLength(){
        return this.password.length();
    }

    //todo connect to games table

}
