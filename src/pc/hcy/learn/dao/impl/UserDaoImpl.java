package pc.hcy.learn.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pc.hcy.learn.dao.UserDao;
import pc.hcy.learn.pojo.User;
import pc.hcy.learn.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public User findUserByuserNameAndPassword(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        Object[] params = new Object[]{username, password};
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into user(username,password,sex,birthday,createtime,content) values(?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getUsername(), user.getPassword(), user.getSex(), user.getBirthday(), user.getCreatetime(), user.getContent()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findAllUser() {
        String sql = "select * from user";
        List<User> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from user where id=?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set username=?,password=?,sex=?,birthday=?,createtime=?,content=? where id=?";
        Object[] params = {user.getUsername(), user.getPassword(), user.getSex(), user.getBirthday(), user.getCreatetime(), user.getContent(), user.getId()};
        try {
            int i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete from user where id=?";
        try {
            queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
