package by.prostrmk.mongocheck.model.repository;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.entity.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {

    User findUserByName(String name);
    User findUserByNameLike(String name);
    User findUserByNameIgnoreCase(String name);
    List<User> findUsersByNameLike(String name);
    List<User> findUsersByNameLikeIgnoreCase(String name);
    List<User> findUsersByNameEndsWith(String end);
    List<User> findAllByUserRole(UserRole userRole);
    User findUserById(String id);

}
