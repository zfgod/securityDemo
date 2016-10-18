package sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.dao.ResourcesMapper;
import sys.model.Resources;
import sys.model.User;

import java.util.List;

/**
 * author: zf
 * Date: 2016/10/17  15:39
 * Description:
 */
@Service
public class ResourceService {
    @Autowired
    private ResourcesMapper resourcesMapper;

   /**
    * @Description: 资源列表数据
    * @author: zf
    * @Date:   2016/10/17
    */
    public List<Resources> findList() {
        return resourcesMapper.findAll();//资源列表数据
    }
    /**
     * @Description: 指定资源获取
     * @author: zf
     * @Date:   2016/10/18
     */
    public Resources findOne(Resources resources) {
        return resourcesMapper.selectByPrimaryKey(resources);
    }
    /**
     * @Description: 添加资源
     * @author: zf
     * @Date:   2016/10/18
     */
    public int addRes(Resources resources) {
        return resourcesMapper.insertSelective(resources);
    }
   /**
    * @Description: 资源下拉获取
    * @author: zf
    * @Date:   2016/10/18
    */
    public List<Resources> getSelect() {
        return resourcesMapper.getSelect();
    }
}
