package com.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adil", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Ali", LocalDate.now().minusYears(22)));
        users.add(new User(++usersCount, "Ahmet", LocalDate.now().minusYears(17)));
        users.add(new User(++usersCount, "Mehmet", LocalDate.now().minusYears(16)));
        users.add(new User(++usersCount, "Nur", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
