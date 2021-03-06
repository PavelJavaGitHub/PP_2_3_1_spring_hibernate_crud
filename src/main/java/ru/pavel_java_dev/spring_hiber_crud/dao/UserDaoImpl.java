package ru.pavel_java_dev.spring_hiber_crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pavel_java_dev.spring_hiber_crud.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> list() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(long id, User user) {
        entityManager.merge(user);
    }

    public void delete(long id) {
        entityManager.remove(get(id));
    }
}