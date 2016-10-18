/**
 * Created by Administrator on 2016/10/14.
 * 系统应用 统一抽取配置
 */

/* js请求参数提交contentType
 * 设置请求头信息并格式化参数
 * */
var configForm = {
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    transformRequest: function (data) {
        if (!data) return undefined;
        return toBodyString(data);
    }
};

var configJson = {
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    },
    transformRequest: function (data) {
        if (!data) return undefined;
        return JSON.stringify(data);
    }
};

function toBodyString(obj) {
    var ret = [];
    for (var key in obj) {
        var values = obj[key];
        if (values && values.constructor == Array) { //数组
            var queryValues = [];
            for (var i = 0, len = values.length, value; i < len; i++) {
                value = values[i];
                queryValues.push(toQueryPair(key, value));
            }
            ret = ret.concat(queryValues);
        } else { //字符串
            ret.push(toQueryPair(key, values));
        }
    }
    return ret.join('&');
}
function toQueryPair(key, value) {
    if (typeof value == 'undefined') {
        return key;
    }
    return key + '=' + encodeURIComponent(value === null ? '' : String(value));
}

function judgeInt(num){
    var regex =/^[0-9]*[1-9][0-9]*$/;
    if(regex.test(num)){
        return true;
    }
    return false;
// ”^\\d+$”　　//非负整数（正整数   +   0）
//“^[0-9]*[1-9][0-9]*$”　　//正整数
//“^((-\\d+)|(0+))$”　　//非正整数（负整数   +   0）
//“^-[0-9]*[1-9][0-9]*$”　　//负整数
//“^-?\\d+$”　　　　//整数
//“^\\d+(\\.\\d+)?$”　　//非负浮点数（正浮点数   +   0）
//“^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$”　　//正浮点数
//“^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$”　　//非正浮点数（负浮点数   +   0）
//“^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$”　　//负浮点数
//“^(-?\\d+)(\\.\\d+)?$”　　//浮点数
}

