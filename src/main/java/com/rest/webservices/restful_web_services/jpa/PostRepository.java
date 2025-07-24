package com.rest.webservices.restful_web_services.jpa;

import com.rest.webservices.restful_web_services.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
