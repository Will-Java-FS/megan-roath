package com.revature.basic.Controller;
import com.revature.basic.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("student")
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student("admin@mail.com", "IT",100,"adminPass"));
        studentList.add(new Student("Charles@mail.com", "Biology",72,"password"));
        studentList.add(new Student("Nick@mail.com", "Computer Science",18,"superPass"));
    }

    @GetMapping("info/{email}")
    public @ResponseBody Student displayInfo(@PathVariable String email){

        for (Student student:studentList){
            if(student.getEmail().equals(email))
                return student;
        }
        return null;

    }
    //http://localhost:8080/student/submit?email=mail@mail.com&major=math&age=50&password=password
    @PostMapping("submit")
    public @ResponseBody String submit(@RequestParam String email,
                                       @RequestParam String major,
                                       @RequestParam int age,
                                       @RequestParam String password){

        studentList.add(new Student(email, major, age, password));
        return "Successfully submitted";

    }

    //Send a json object {
    //    "email": "admin@mail.com",
    //    "major": "ADMIN",
    //    "age": 100,
    //    "password": "adminPass"
    //}
    @PostMapping("jsonsubmit")
    public @ResponseBody String update(@RequestBody Student student){
        studentList.add(student);
        return "Successfully submitted";
    }


    /*@PutMapping("update")
    public @ResponseBody String update(@RequestBody Student updatedStudent){
        if(studentList.removeIf(student -> student.getEmail().equals(updatedStudent.getEmail()))) {
            studentList.add(updatedStudent);
            return "Successfully updated";
        }
        return "Email was not registered, check email and try again. Or register new student.";
    }
    */


}
