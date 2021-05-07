package myj2ee.service;

import myj2ee.bean.User;
import myj2ee.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(String username, String password){
        User user = userDao.getUserByUsername(username);
        Map<String, Object> res = new HashMap<>();

        if(user == null){
            return null;
        }else if(!user.getPassword().equals(password)){
            user.setPassword(null);
        }

        return user;
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    public int addUser(User user){
        int state = userDao.addUser(user);
        return state;
    }

    public int deleteUser(int id){
        int state = userDao.deleteUser(id);
        return state;
    }
}
