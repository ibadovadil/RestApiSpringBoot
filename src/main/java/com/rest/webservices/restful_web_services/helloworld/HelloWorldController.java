package com.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")  //this return string
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-bean") //this return JSON
    public HelloBean helloBean() {
        return new HelloBean("Hello World");
    }

    @GetMapping("/hello-bean/path-variable/{name}")
    public HelloBean helloPathVeriable(@PathVariable String name) {
        return new HelloBean(
                String.format("Hello %s", name)
        );
    }
}
