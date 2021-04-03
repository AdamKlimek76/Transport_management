package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Service
public class UserService implements MethodsService<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void add(User user) {


    }
}
