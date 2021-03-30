package myj2ee.dao;

import myj2ee.bean.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUser();
    public User getUserByUsername(String username);
    public int addUser(User user);
    public int deleteUser(Integer id);

}
