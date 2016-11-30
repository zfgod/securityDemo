# securityDemo
##后台：SpringMvc+Spring4.2.3.RELEASE+SpringSecurity3.2.3.RELEASE+Mybatis3.3.1
    >druid连接池使用：
    >SpringSecurity做安全框架;
        授权：系统资源权限和用户资源权限的加载
        登录：使用自定义登录.完成登录授权登录用户权限资源
        拦截配置：配置放行与拦截规则：用户请求的过滤、静态资源放行、特殊类别的数据请求放行
        认证：用户拦截定义，获取请求所需权限资源并进行用户权限匹配
        额外处理：在系统security中未定义资源请求在security拦截时的处理
    >模块：
        登录
        用户：  列表，绑定角色
        角色:   新增，修改，查看，列表，角色授权
        权限：  新增，修改，查看，列表
##前端： h5+angularJS1+jquery
    >页面导航路径统一配置,请求路径统一配置
    >请求提交对contentType和params统一格式化配置(表单格式,Json格式)
    >获取地址栏内指定的参数
    >服务端返回统一监测并处理。
    >用户绑定角色和角色授权的js逻辑
    >使用angular列举：
        factory,module,filter,controller,
        ng-controller,ng-repeat,{{param}},ng-show,ng-model,ng-click,ng-checked

###其他：
    >SSE,server send event
        推送用户的权限有修改，提醒重新登录（servletContext,server send event,EventSource）
    >properties文件操作：
        PropertiesLoaderUtils:类路径下属性文件参数读取和修改
        ResourceBundle：读取.properties文件
    >email发送：
        javax.mail：指定发送人及抄送人的形式,携带一个或多个附件

