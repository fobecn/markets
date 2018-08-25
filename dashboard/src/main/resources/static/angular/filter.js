/**
 * Created by Administrator on 2016/11/21.
 */
//0:用户下单 1:已经支付,等待确认地址 2.待发货 3:确认发出 4:用户确认收到货 5.等待确认货到付款 6.接受货到付款 7.拒绝货到付款 9:用户退货
angular.filter('shipmentStatus', function(){

    return function (input) {
        var status = "";
        switch (input){
            case 0:
                status="用户下单";
                break;
            case 1:
                status="已经支付,等待确认地址";
                break;
            case 2:
                status ="待发货";
                break;
            case 3:
                status ="已发货";
                break;
            case 4:
                status ="用已确认收货";
                break;
            case 5:
                status ="等待确认货到付款";
                break;
            case 6:
                status ="接受货到付款";
                break;
            case 7:
                status ="拒绝货到付款";
                break;
            case 8:
                status ="超时确认发货";
                break;
            case 9:
                status ="用户退货";
                break;

        }
        return status;
    };
});

//0:草稿 1:认证成功 2:待审核 3:认证失败
angular.filter('certificationStatus', function(){

    return function (input) {
        var status = "";
        switch (input){
            case 0:
                status="草稿";
                break;
            case 1:
                status="认证成功";
                break;
            case 2:
                status ="待审核";
                break;
            case 3:
                status ="认证失败";
                break;
            default :
                status ="";
                break;
        }
        return status;
    };
});



//关键字上色
angular.filter("highLight", function($sce, $log){

    var fn = function(text){
        var regex = new RegExp('未填写');
        var result = text.replace(regex, "<span style='font-color:#ddd'>$&</span>");
        return result;
    };

    return fn;
});