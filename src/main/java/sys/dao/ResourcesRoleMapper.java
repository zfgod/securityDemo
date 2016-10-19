package sys.dao;

import com.github.abel533.mapper.Mapper;
import sys.model.ResourcesRoleKey;
import sys.model.Role;

public interface ResourcesRoleMapper extends Mapper<ResourcesRoleKey> {

    int insertBindRoleRes(Role role);
}