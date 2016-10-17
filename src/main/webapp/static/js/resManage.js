/**
 * Created by Administrator on 2016/10/17.
 */
var resListApp = angular.module("ResListApp",[]);

//资源类型匹配
resListApp.filter('type_resType',function(){
    return function(input){
        switch (input){
            //数据为string,加单引号;为number 不加单引号
            case '0':
                return '菜单';
            case '1':
                return '页面';
            case '2':
                return '按钮';
            default:
                return '--';
        }
    }
});
resListApp.controller('ResListCtrl',['$scope','$http',
    function($scope,$http){
        var url = baseUrl+resUrl.resources.query;
        //页面加载完成，请求资源数据
        $http.get(url)
            .success(function(data){
                if(data.code = 200){
                    $scope.resList = data.resList;
                    $scope.dataSize = ($scope.resList && $scope.resList.length);
                }else{
                    $scope.dataSize = 0;
                }
            })
            .error(function(){
                console.log("error...");
            });
    }
]);