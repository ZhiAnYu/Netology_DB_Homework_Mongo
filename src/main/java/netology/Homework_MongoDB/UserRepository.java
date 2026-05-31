package netology.Homework_MongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    //Optional<User> findByEmail(String email);    нереализовано

}
