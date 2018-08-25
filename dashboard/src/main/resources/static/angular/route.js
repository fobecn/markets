//定义 默认 对象

var basePath = location.origin;

var oss      = "http://club10000-test.img-cn-qingdao.aliyuncs.com/";

// angular 框架
var angular= angular.module('dashboard', ["ngRoute"]);
//定义controller传值


//$scope.oss = "http://club10000-test.img-cn-qingdao.aliyuncs.com/";




//AngularJS 路由

// angular.config(['$routeProvider', function($routeProvider, $locationProvider){
//         $routeProvider
//             .when('/home/:id',{templateUrl: 'template/signin2.html',controller: "loginController2"})
//             .when('/wellcome',{ templateUrl: 'template/wellcome.html'})
//             .when('/dashboard',{ templateUrl: 'template/dashboard.html'})
//             .otherwise({redirectTo:'/'});
//     }]);



/**
 * 分页 v1  随便写写的。不要方.
 * paramter 开始行,大小,总数
 * author linjishuang
 * date   20161119
 * return 返回已经计算好的上下页和 附近页
 */

function pager(begin,size,total){
	var pager = {};
	
	
	pager.begin = Number(begin);
	pager.size = Number(size);
	pager.total = Number(total);
	pager.count = Math.ceil(total / size);
	
	pager.last =  Number(begin) - Number(size);
	pager.next =  Number(begin) + Number(size);
	
	pager.currentPage = begin / size + 1;
	pager.lastPages = [];
	pager.nextPages = [];
	
	var maxNextNumber =Number(begin) + size * 10;
 	
	//alert(maxNextPageNumber);
 	for(var i= Number(begin);i<total ;i=i + Number(size)){
 		if(maxNextNumber < i){
 			break;
 		}
 		pager.nextPages.push(Math.ceil(i / size) + 1);
 	}
 	
 	var minLastNumber = begin - size * 10;
 	if(minLastNumber < 0){
 		minLastNumber = 0;
 	}
 	
 	for(i=minLastNumber;i < Number(begin)  ;i=i+Number(size)){
 		pager.lastPages.push(i / size + 1);
 	}
	
	return pager;
}
