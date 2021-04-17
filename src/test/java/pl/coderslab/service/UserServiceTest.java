package pl.coderslab.service;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldAdd() {
        User user = new User();
        ArgumentCaptor<User>argumentCaptor=ArgumentCaptor.forClass(User.class);

        userService.add(user);

        Mockito.verify(userRepository).save(argumentCaptor.capture());
        Assert.assertSame(user, argumentCaptor.getValue());
    }

    @Test
    public void shouldUpdate() {
        User user = new User();
        user.setFirstName("Adam");
        ArgumentCaptor<User>argumentCaptor=ArgumentCaptor.forClass(User.class);

        userService.update(user);

        Mockito.verify(userRepository).save(argumentCaptor.capture());
        Assert.assertSame("Adam", argumentCaptor.getValue().getFirstName());
    }

    @Test
    public void shouldDelete() {
        User user = new User();
        user.setId(102L);
        ArgumentCaptor<Long>argumentCaptor=ArgumentCaptor.forClass(Long.class);

        userService.delete(102L);

        Mockito.verify(userRepository).deleteById(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue()).isEqualTo(102L);
    }

    @Test
    public void shouldShowAll() {
        List<User>users=List.of(new User(), new User(), new User());

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User>foundUsers=userService.showAll();

        Assertions.assertThat(foundUsers).containsAll(users);
    }

    @Test
    public void shouldShowByIdIfUserExists() {
        User user = new User();
        user.setId(5L);
        user.setLastName("Kowalski");

        given(userRepository.findById(5L)).willReturn(Optional.of(user));

        User foundUser=userService.showById(5L);
        String foundUserLastName=foundUser.getLastName();

        Assert.assertSame(foundUserLastName, "Kowalski");
    }

    @Test(expected =EntityNotFoundException.class)
    public void shouldShowExceptionsIfUserDoesntExist(){
        User user = new User();
        user.setId(5L);
        user.setLastName("Kowalski");

        given(userRepository.findById(15L)).willReturn(Optional.ofNullable(null));

        User foundUser=userService.showById(15L);

    }
}