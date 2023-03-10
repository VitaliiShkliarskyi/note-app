package test.notesapp.service;

import test.notesapp.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
