package test.notesapp.service.impl;

import org.springframework.stereotype.Service;
import test.notesapp.model.User;
import test.notesapp.service.AuthenticationService;
import test.notesapp.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        return user;
    }
}
