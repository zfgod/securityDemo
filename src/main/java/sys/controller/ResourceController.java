package sys.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sys.model.Resources;
import sys.service.ResourceService;

import java.util.List;

/**
 * author: zf
 * Date: 2016/10/17  15:38
 * Description:
 */
@Controller
@RequestMapping("/resManage")
public class ResourceController extends BaseController{

    @Autowired
    private ResourceService resourceService;



/**
 * @Description: 查询系统资源列表
 * @author: zf
 * @Date:   2016/10/17
 */
    @RequestMapping(value = "/resQuery",method = RequestMethod.GET)
    @ResponseBody
    public Object queryResList(){
        JSONObject result = new JSONObject();
        try {
            List<Resources> list = resourceService.findList();
            if(null!=list && list.size()>0){
                result.put("code",200);
                result.put("resList",list);
            }else {
                result.put("code",404);
            }
        }catch (Exception e){
            result.put("code",500);
        }
        return result;
    }


    @RequestMapping(value = "/")
    public Object add(){
        JSONObject result = new JSONObject();
        try {
            List<Resources> list = resourceService.findList();
            if(null!=list && list.size()>0){
                result.put("code",200);
                result.put("resList",list);
            }else {
                result.put("code",404);
            }
        }catch (Exception e){
            result.put("code",500);
        }
        return result;
    }

}
