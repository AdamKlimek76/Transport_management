package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements MethodsService<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void add(User user) {
        userRepository.save(user);

    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> showById(long id) {
        return userRepository.findById(id);
    }


}
