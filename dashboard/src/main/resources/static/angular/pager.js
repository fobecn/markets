/**
 * 分页 v1  随便写写的。不要方.
 * paramter 开始行,大小,总数
 * author linjishuang
 * date   20161119
 * return 返回已经计算好的上下页和 附近页
 */

function pager(page,size,total){
    var pager = {};


    var begin = page*size;
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