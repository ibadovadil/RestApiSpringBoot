package com.rest.webservices.restful_web_services.jpa;

import com.rest.webservices.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
