package by.prostrmk.mongocheck.model.repository;

import by.prostrmk.mongocheck.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByName(String name);
    User findUserByNameLike(String name);


}
