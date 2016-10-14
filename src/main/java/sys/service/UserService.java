package sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.dao.UserMapper;
import sys.model.User;

/**
 * author: zf
 * Date: 2016/10/13  17:17
 * Description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User commitLogin(User user) {
        User singleUser = userMapper.querySingleUser(user.getUserName());//登录时获取用户
        if(singleUser!=null && user.getUserPassword().equals(singleUser.getUserPassword())){
            return singleUser;
        }
        return null;
    }
}
