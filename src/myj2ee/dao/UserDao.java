package myj2ee.dao;

import myj2ee.bean.User;

import java.util.List;

public interface UserDao {

    //获取所有用户信息
    public List<User> getAllUser();

    //根据用户名获取用户信息
    public User getUserByUsername(String username);

    //增加用户
    public int addUser(User user);

    //删除用户
    public int deleteUser(Integer id);

}
