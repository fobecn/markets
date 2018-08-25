/**
 * 用户，密码和用户信息
 */

dashboard.config(['$routeProvider', function($routeProvider, $locationProvider){
        $routeProvider
            .when('/users/:page/:size',{ templateUrl: 'angular/templates/user/users.html',controller: "usersController"})
            .otherwise({redirectTo:'/'});
}]);

//用户管理
dashboard.controller('usersController', function($scope,$location,$routeParams,$http, $timeout) {

    $http.get(basePath + "/dashboard/users?page="+$routeParams.page+"&size="+$routeParams.size).success(function (response) {
        if(response.code == "0"){
            $scope.response = response;

            //计算分页
            $scope.pager = pager($routeParams.page,$routeParams.size,response.count);


            alert($scope.pager);

        }else{
            alert(response.message);
        }




    });

    //修改用户的状态：正常和黑名单
    $scope.updateStatus = function (id,status) {
        var msg = '确定修改?';
        if(confirm(msg) == false){
            return false;
        }
        if(status == 1){
            status = 2;
        }else{
            status = 1;
        }
        $http.get(basePath + "/app/master/user/"+id+"/status/"+status+"/change").success(function (response){
            if(response.result_code == "200"){
                alert("修改成功!");
                window.location.reload();
            }else{
                alert("修改失败");
            }
        })
    };

    //搜索
    $scope.search = function(keyword) {
        //alert(keyword);
        if(keyword == null || keyword == ""){
            //重定向
            window.location.href="#/user/list/0/20";
        }else{
            window.location.href="#/user/search/"+keyword+"/list/0/20"
        }
    };

});


dashboard.filter('userStatus', function(){

    return function (input) {
        var status = "";
        switch (input){
            case 1:
                status="正常";
                break;
            case 2:
                status="黑名单";
                break;
        }
        return status;
    };
});


