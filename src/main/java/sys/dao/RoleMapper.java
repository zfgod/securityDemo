package sys.dao;

import com.github.abel533.mapper.Mapper;
import sys.model.ResourcesRoleKey;
import sys.model.Role;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<ResourcesRoleKey> findRoleResList(Role role);

    List<Role> queryList();

}