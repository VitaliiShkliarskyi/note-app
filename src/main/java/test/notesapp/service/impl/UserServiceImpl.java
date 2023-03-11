package test.notesapp.service.impl;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.notesapp.model.User;
import test.notesapp.repository.UserRepository;
import test.notesapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.insert(user);
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
