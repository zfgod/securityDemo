package sys.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.model.ResourcesRoleKey;
import sys.model.Role;
import sys.service.ResourceService;
import sys.service.RoleService;

import java.util.List;

/**
 * author: zf
 * Date: 2016/10/19  10:25
 * Description:
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/query.do")
    @ResponseBody
    private Object queryRoles(){
        JSONObject result = new JSONObject();
        try{
            List<Role> roleList = roleService.queryList();
            result.put("code",200);
            result.put("roleList",roleList);
        }catch (Exception e){
            result.put("code",500);
            result.put("msg","获取失败！");
        }
        return result;
    }

    /**
     * @Description: 查看角色-权限绑定信息
     * @author: zf
     * @Date:   2016/10/19
//     */
    @RequestMapping(value = "/letGo/bindRoleRes.do",method = RequestMethod.POST)
    @ResponseBody
    private Object getBindRoleRes(@RequestBody Role role){
        JSONObject result = new JSONObject();
        try{
            roleService.findRoleResList(result,role);
            result.put("code",200);
        }catch (Exception e){
            result.put("code",500);
            result.put("msg","获取失败！");
        }
        return result;
    }

    /**
     * 更新角色绑定的权限
     * @param role
     * @return
     */
    @RequestMapping(value = "/bindRoleRes.do",method = RequestMethod.POST)
    @ResponseBody
    private Object updateBindRoleRes(@RequestBody Role role){
        JSONObject result = new JSONObject();
        try{
            boolean b = roleService.updateBindRoleRes(role);
            if(b){
                result.put("code",200);
                result.put("msg","授权成功！");
            }
        }catch (Exception e){
            result.put("code",500);
            result.put("msg","授权失败！");
        }
        return result;
    }


}
