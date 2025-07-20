package com.rest.webservices.restful_web_services.user;

import com.rest.webservices.restful_web_services.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    /**
     Get All
     */

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

/**
 GetByID
*/
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable int id) {
        User user = service.findById(id);
        if (user == null) {
            throw  new UserNotFoundException("id: " + id);
        }
        return user;
    }


//    @PostMapping("/users") without response entity
//    public void createUser(@RequestBody User user) {
//        service.save(user);
//    }

    /**
     Create
     */
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User Saveduser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(Saveduser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     Delete
     */
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

}
