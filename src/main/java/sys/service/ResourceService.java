package sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.dao.ResourcesMapper;
import sys.model.Resources;

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
}
