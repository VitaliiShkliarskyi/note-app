package test.notesapp.service;

import java.util.List;
import test.notesapp.model.User;

public interface UserService {
    User findByEmail(String email);

    List<User> findAll();

    User add(User user);

    User get(String id);

    void delete(User user);

    User update(User user);
}
