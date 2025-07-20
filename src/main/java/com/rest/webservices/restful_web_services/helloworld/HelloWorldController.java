package com.rest.webservices.restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

//    send in Header Accept-Language :az or different languages or null
    @GetMapping("/hello-i18n")
    public String helloi18n() {
        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

//        return "Hello World V2";
    }
}
