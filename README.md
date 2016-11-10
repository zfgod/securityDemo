# securityDemo
后台：   SpringMvc+Spring4.2.3.RELEASE+SpringSecurity3.2.3.RELEASE+Mybatis3.3.1
   druid连接池使用：
   SpringSecurity做安全框架;
        使用自定义登录
        系统资源权限和用户资源权限的加载
        配置放行与拦截规则：用户请求的过滤、静态资源放行、特殊类别的数据请求放行
        用户拦截定义，获取请求所需权限资源并进行匹配
        系统在security中未定义资源在security拦截中的处理
   模块：
     登录
     用户：  列表，绑定角色
     角色:   新增，修改，查看，列表，角色授权
     权限：  新增，修改，查看，列表
前端： h5+angularJS1+jquery
      页面导航路径统一配置,请求路径统一配置,请求提交类型统一配置，请求参数统一格式化
      服务端返回统一监测并处理。
      绑定角色和角色授权的js逻辑
其他：
    SSE,推送用户的权限有修改，提醒重新登录（servletContext,server send event,EventSource）

