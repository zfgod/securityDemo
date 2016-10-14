package sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * author: zf
 * Date: 2016/10/13  16:05
 * Description:
 */
public class BaseController {
    protected HttpSession session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute()
    public  void setHttpObjects(HttpSession session,
                                HttpServletRequest request,
                                HttpServletResponse response)
    {
        this.request = request;
        this.response = response;
        this.session = session;
    }
}
