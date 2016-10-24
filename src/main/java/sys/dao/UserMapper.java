package sys.dao;

import com.github.abel533.mapper.Mapper;
import sys.model.User;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    User querySingleUser(String username);

    List<User> queryUserList();

    List<Integer> getCurrentRoles(User user);
}