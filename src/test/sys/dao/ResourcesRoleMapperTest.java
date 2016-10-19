package sys.dao;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sys.model.Role;

import java.util.Arrays;
import java.util.List;


/**
 * author: zf
 * Date: 2016/10/19  18:08
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class ResourcesRoleMapperTest {
    @Autowired
    private ResourcesRoleMapper resourcesRoleMapper;
    @Before
    public void setUp(){

    }
    @Test
    public void test() throws Exception {
        Role role = new Role();
        role.setId(2);
        Integer[] a= {1,2,3,4,5};
        List<Integer> resList = Arrays.asList(a);
        role.setResList(resList);
        resourcesRoleMapper.insertBindRoleRes(role);
    }
}