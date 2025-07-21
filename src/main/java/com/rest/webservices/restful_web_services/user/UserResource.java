package com.rest.webservices.restful_web_services.user;

import com.rest.webservices.restful_web_services.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
//HATEOAS Example
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id) {
        User user = service.findById(id);
        if (user == null) {
            throw  new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
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
