package pl.shadoq.service.impl;

import org.hibernate.SessionFactory;
import pl.shadoq.HibernateUtil;
import pl.shadoq.dao.UserDao;
import pl.shadoq.entity.User;
import pl.shadoq.service.UserService;

import javax.annotation.PostConstruct;

/**
 * Created by Jan on 2016-06-18.
 */
public class UserServiceImpl implements UserService {

    SessionFactory sessionFactory;

    private UserDao userDao;

    public UserServiceImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
        userDao = new UserDao(sessionFactory);
    }

    public Long add(User emp) {
        return userDao.add(emp);
    }

    public User get(Long id) {
        return userDao.get(id);
    }

    public Boolean update(Long id, User emp)  {
        return userDao.update(id,emp);
    }

    public Boolean delete(User emp) {
        return null;
    }
}
