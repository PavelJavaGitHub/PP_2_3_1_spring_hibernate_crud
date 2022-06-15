package ru.pavel_java_dev.spring_hiber_crud.dao;

import ru.pavel_java_dev.spring_hiber_crud.models.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User get(long id);

    void update(long id, User user);

    void delete(long id);

    List<User> list();
}
