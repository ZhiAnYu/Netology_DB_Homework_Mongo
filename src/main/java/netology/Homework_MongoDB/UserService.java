package netology.Homework_MongoDB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import netology.Homework_MongoDB.ResourceNotException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotException("Пользователь не найден:" + id));
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByAge(Integer age) {
        return userRepository.findByAge(age);
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        // Проверяем существование, чтобы не летело непонятное исключение
        if (!userRepository.existsById(id)) {
            throw new ResourceNotException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
