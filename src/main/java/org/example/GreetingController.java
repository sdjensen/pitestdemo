package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greet")
    public String greet() {
        return "Hello, Mutation Testing!";
    }

    @PutMapping("/greet")
    public String update(@RequestBody String name) {
        return String.format("Hello %s, Mutating Testing!", name);
    }
}