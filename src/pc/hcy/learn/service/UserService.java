package pc.hcy.learn.service;

import pc.hcy.learn.pojo.User;

import java.util.List;

public interface UserService {
    User findUserByuserNameAndPassword(String username, String password);

    void saveUser(User user);

    List findAllUser();

    User findUserById(String id);

    void updateUser(User user);

    void delete(String id);
}
