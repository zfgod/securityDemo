package sys.dao;

import com.github.abel533.mapper.Mapper;
import sys.model.User;
import sys.model.UserRoleKey;

public interface UserRoleMapper extends Mapper<UserRoleKey> {

    int insertBatch(User user);
}