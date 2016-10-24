package pl.shadoq.dao;

import org.hibernate.SessionFactory;
import pl.shadoq.entity.User;
import pl.shadoq.repository.impl.GenericRepositoryImpl;

/**
 * Created by Jan on 2016-10-22.
 */
public class UserDao extends GenericRepositoryImpl<User> {

    public UserDao() {
        super(User.class);
    }

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
}