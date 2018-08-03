package by.prostrmk.mongocheck.model.service;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.entity.UserRole;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCustomService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAdmins(){
        return userRepository.findAllByUserRole(UserRole.ADMIN);
    }

    public List<User> getUsers(){
        return userRepository.findAllByUserRole(UserRole.USER);
    }

}
