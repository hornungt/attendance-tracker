package backend;

import backend.model.Person;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.List;

@Controller("/")
public class HelloWorldController {

    @Get("/")
    public String GetHello() {
        return "HELLO";
    }

    @Get("/test")
    public List<Person> GetPerson() {
        return Arrays.asList( new Person("John", "Anderson", 0) );
    }
}
