package ru.pavel_java_dev.spring_hiber_crud.services;

import ru.pavel_java_dev.spring_hiber_crud.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User get(Long id);

    void update(Long id, User user);

    void delete(Long id);

    List<User> list();
}
