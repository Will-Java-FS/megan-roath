package com.revature.basic.Controller;
import java.util.Map;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.annotation.*;


// @CrossOrigin("http://localhost:3000") This annotation is extremely important because it defines what all ports on your computer can communicate with the backend. CORS stands for Cross Origin Resource Sharing. This annotation can be used on the method level or the class level.
//@ResponseBody // creates serializable object like json or xml instead of just returning a string but not working
@RestController  //specialized form of @Component
@RequestMapping(value="/**")
public class theController {


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value="/hi")
    //@ResponseBody // creates serializable object like json or xml instead of just returning a string but this is not working for some reason
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/Yo")
    public String sayYo(){
        return "Yo!";
    }

    //@RequestParam annotation can be used to assign variables to query parameters in Http Requests
    //http://localhost:8080/name?firstname=John&lastname=doe
    @GetMapping("/name")
    public String demo(@RequestParam("firstname") String fname, @RequestParam("lastname") String lname) {
        //System.out.println(fname+" "+lname);
        return fname+" "+lname;
    }

    //http://localhost:8080/index/{page} where page is variables that has values as page=page1, page2, page3…pageN

    @GetMapping("/index/{page}") //this needs to be the same name as passsed in
    public String getPage(@PathVariable String page) {
    return "You visited "+page;
    }

    //@RequestBody annotation is used to bind the HTTP request body to a method parameter in a controller
    //send this in postman
    //{
    //    "name" : "Geek",
    //    "dob" : "29-2-99",
    //    "id" : 3,
    //    "state": "Uttarakhand"
    //}
    @ResponseBody
    @GetMapping("/userData")
    public String getUserAndId(@RequestBody Map<String,String> userData) {
        return "The name of the user is= "+userData.get("name")+" and their id is= "+userData.get("id");
    }

    //The @CookieValue annotation is used to tie the value of http cookies to the method arguments of controllers in Spring MVC.
    //create cookie in postman that looks like this JSESSIONID=value; Path=/user; Expires=Mon, 04 Aug 2025 00:10:26 GMT;
    //date and time dont matter for the cookie just the first two values
    @GetMapping("/user")
    public String getCookieValue(@CookieValue("JSESSIONID") String jSessionId) {
        return "The session id is: "+jSessionId;
    }

    //@ExceptionHandler is also called as a Local Exception Handler in spring, because it handles exceptions at the class level
    @GetMapping("/except")
    @ExceptionHandler(Exception.class)
    public String getErrorMessage1(Exception ex) {
        return "Exception";
    }

}
