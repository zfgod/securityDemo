/**
 * Created by Administrator on 2016/10/14.
 * 系统参数  统一配置
 */
var baseUrl = '//localhost:8082';

/**
 * 获取地址栏内指定的参数
 * @param name
 * @returns {*|string}
 */
var getSearch = function (name) {
    var reg = new RegExp('(?:^|&)' + name + '=([^&]*)(?:&|$)', 'i');
    return ((location.search.split('?')[1] || '').match(reg) || [])[1] || '';
};

/**
 * 系统资源访问路径  统一配置
 * resUrl.sys.toLogin
 * */
var resUrl = {
    //系统：登录页，登录提交
    sys:{toLogin:"/sys/toLogin.html",comLogin:"/sys/commitLogin.html",main:"/sys/main.html"},
    //用户管理：
    users:{},
    //资源管理：
    resources:{}
}