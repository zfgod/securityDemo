package sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sys.service.RoleService;

import java.util.*;


/**
 * author: zf
 * Date: 2016/10/31  10:15
 * Description: 这里只是演示请求时条件满足做数据推送，实际运用不上，涉及很多处理还没有做
 * 请求服务，未满足条件的后续处理，如thread的控制
 * 请求服务，满足条件的后续处理
 * so: 目的是演示 sse服务端推送
 * 如果需要把这个角色权限修改后通知客户端做重新登录完善，
 * servletContext： 登录用户的Set,有做更新的角色Set.角色对应需要通知的用户，基于此
 *  更新考虑建表处理数据，存入servletContext不合理
 *  如果有没关系性缓存 如redis，则使用redis存储
 */
@Controller
@RequestMapping("/sse")
public class SSEController  extends BaseController{

    @Autowired
    private RoleService roleService;
    /**
     * 角色_资源绑定修改后通知客户端
     * @return
     */
    @RequestMapping(value = "/letGo/rr",produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody String r_rPush(){
        try {
            boolean flag = false;
            if(servletContext.getAttribute("updateRoles")!=null){
                Set<Integer> updateRoles = (Set<Integer>) servletContext.getAttribute("updateRoles");
                List<Integer> users = roleService.getUsersUseRole(updateRoles);
                Integer loginUserId = getLoginUserId();
                if(users.contains(loginUserId)){
                    flag = true;
                }
            }
            if(flag){
                return "data:"+"您的角色资源有修改,请重新登录使用最新权限！"+"\n\n";
            }else {
                //这里没做处理
                Random r =new Random();
                try {
//          so 这里可以根据需要触发 ,系统有相关操作后进行调用并获取推送数据
                    Thread.sleep(5000);//5秒
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("获取推送信息。。");
                return "data:Testing ..."+r.nextInt()+"\n\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
