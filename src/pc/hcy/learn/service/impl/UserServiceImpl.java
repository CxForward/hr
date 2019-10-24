package pc.hcy.learn.service.impl;

import pc.hcy.learn.dao.UserDao;
import pc.hcy.learn.dao.impl.UserDaoImpl;
import pc.hcy.learn.pojo.User;
import pc.hcy.learn.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findUserByuserNameAndPassword(String username, String password) {
        User user = userDao.findUserByuserNameAndPassword(username, password);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
}
