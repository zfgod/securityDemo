package sys.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sys.model.Role;

import static org.junit.Assert.*;

/**
 * author: zf
 * Date: 2016/10/19  15:26
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;
    @Before
    public void setUp(){

    }
    @Test
    public void testFindRoleResList() throws Exception {
        Role role = new Role();
        JSONObject result =new JSONObject();
        role.setId(1);
        roleService.findRoleResList(result,role);
        System.out.println(result.toJSONString());
    }
}