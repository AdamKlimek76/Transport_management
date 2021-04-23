package pl.coderslab.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


public interface CrudService<T> {

    void add(T t);

    void update(T t);

    void delete(long id);

    List<T> showAll();

    T showById(long id);


}
