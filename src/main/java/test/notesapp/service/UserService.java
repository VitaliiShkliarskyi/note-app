package test.notesapp.service;

import test.notesapp.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    List<User> findAll();

    User add(User user);

    User get(String id);

    void delete(User user);

    User update(User user);
}
