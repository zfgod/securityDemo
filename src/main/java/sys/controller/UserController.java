package sys.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.model.Role;
import sys.model.User;
import sys.model.validateGroups.UserTest1;
import sys.service.RoleService;
import sys.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * author: zf
 * Date: 2016/10/24  16:36
 * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService ;

    @RequestMapping(value = "/letGo/testDateConverter",method = RequestMethod.POST)
    @ResponseBody
    public Object dateUsers(@Validated(value = {UserTest1.class}) //只校验标记分组含UserTest1的字段
                                User user,
                            BindingResult bindingResult){
        /*
           必须是 @Validated，@Valid不行
         *参数校验-对使用同一个vo对象进行校验，但是存在字段的冲突时，采用给校验分组的方式分别校验
         *字段上面的校验注解加入需要校验的分组（可以多个，被多个接口同时使用），
         *在接口中校验是指定明确的校验分组 （唯一，只校验被此分组标记的校验规则）
         */
        if(bindingResult.hasErrors()){//测试同一个vo对象里面书写校验规则,并运用到指定的group中
            return hasFieldErrors(bindingResult);
        }
        //测试日期转换器配置,读取时间字符串转换为日期
        JSONObject result = new JSONObject();
        Date regTime = user.getRegTime();
        result.put("time",regTime);
        return result;
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public Object queryUsers(){
        JSONObject result = new JSONObject();
        List<User> userList = userService.queryUsers();
        if(userList!=null &&userList.size()>0){
            result.put("code",200);
            result.put("list",userList);
        }else {
            result.put("code",404);
        }
        return result;
    }
    @RequestMapping(value = "/letGo/rSelect",method = RequestMethod.POST)
    @ResponseBody
    public Object getRolesForBind(@RequestBody User user){
        JSONObject result = new JSONObject();
        List<Integer> cList = userService.getCurrentRoles(user);
        List<Role> rSelect = roleService.findAllRoles();
        result.put("code",200);
        result.put("currentRoles",cList);
        result.put("rSelect",rSelect);
        return result;
    }

    @RequestMapping(value = "/bindRole",method = RequestMethod.POST)
    @ResponseBody
    public Object bindRoles(@RequestBody User user){
        JSONObject result = new JSONObject();
        boolean flag = userService.bindRoles(user);
        if(flag){
            result.put("code",200);
            result.put("msg","绑定成功");
        }
        return result;
    }

}
