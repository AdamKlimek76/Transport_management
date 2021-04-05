package pl.coderslab.service;

import java.util.List;
import java.util.Optional;


public interface MethodsService<T> {

    void add(T t);

    void update(T t);

    void delete(long id);

    List<T>showAll();

    Optional<T> showById(long id);


}
