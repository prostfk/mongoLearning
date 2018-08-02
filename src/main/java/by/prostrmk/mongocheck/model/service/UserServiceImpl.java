package by.prostrmk.mongocheck.model.service;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository repository;

    @Override
    public User getUser(String username) {
        return repository.findUserByName(username);
    }
}
