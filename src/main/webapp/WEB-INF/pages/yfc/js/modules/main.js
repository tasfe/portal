define(function(require, exports, modules){
	var $ = require("jquery");
	   require('popup')($);
       require('modules/maction');
    function getids(){
        var ids = [];
        $('.ui-datagrid').find('.ui-chk:checked').each(function(){
            var id = $(this).closest('tr').attr('data-id');
            ids.push(id);
        });
        return ids;
    }   
	$(document).on('click','.popclick',function(){
        if(getids().length > 0){
            var trigger = $(this).attr('data-target');
            $('#'+trigger).popup();  
        }
    });

    // 全选
    $('.ui-datagrid').on('click','.ui-chks',function(){
    	$('.ui-datagrid').find('.ui-chk').prop('checked',$(this).prop('checked')); 
    });	

    
    var checkOrNo = function(node){
    	var t_lens = node.closest('.ui-datagrid').find('.ui-chk').length;
    	var c_lens = node.closest('.ui-datagrid').find('.ui-chk:checked').length;
    	if(c_lens == t_lens){
    		node.closest('.ui-datagrid').find('.ui-chks').prop('checked',true);
    	}else{
    		node.closest('.ui-datagrid').find('.ui-chks').prop('checked',false);
    	}
    }

    $('.ui-datagrid').on('click','.ui-chk',function(){
    	checkOrNo($(this));
    });	

    $('.ui-datagrid').find('tbody').on('click','tr',function(e){
    	var e = e || window.event;
    	var tar = e.target;
    	if($(tar).is('.ui-chk')){
    		return;
    	}
    	var chk = $(this).find('.ui-chk');
    	chk.prop('checked',!chk.prop('checked'));
    	checkOrNo($(this));
    });

    window.pageBar = function(_total,_per,_pn){

        var _per = _per ? _per : 10;    // 当前页显示条数
        var _pn = _pn ? _pn : 1;        // 当前为第几页

        if(_total<=0){
            return '';
        }

        var _pagetotal = Math.ceil(_total / _per);   //总共多少页
        
        // 上一页
        var $str = '';

        $str += "<div class='message'>共<i class='blue'>"+_total+"</i>条记录，当前显示第&nbsp;<i class='blue'>"+_pn+"&nbsp;</i>页</div>";
        $str += "<ul class='paginList'>";   
        if(_pn==1){
            $str += '<li class="paginItem"><a href="javascript:;" class="disabled"><span class="pagepre"></span></a></li>';
        }else{
            $str += '<li class="paginItem"><a href="javascript:;" data-pn="'+(_pn-1)+'"><span class="pagepre"></span></a></li>';
        }
        
        // 如果当前页码靠近总数，总数在9以上，要在 6789页前追加 2345
        if( _pn > _pagetotal - 4 && _pn > 5 ){
            var _beforenumber = 4 - ( _pagetotal - _pn );
            for (var i=_pn-4-_beforenumber; i<=_pn-5; i++){
                if( i > 0 ){
                    $str += '<li class="paginItem"><a href="javascript:;" data-pn="'+ i +'">'+ i +'</a></li>';
                }
            }
        }

        //前4页
        for (var i=_pn-4; i<_pn; i++){
            if(i > 0){
                $str += '<li class="paginItem"><a href="javascript:;" data-pn="'+ i +'">'+ i +'</a></li>';
            }
        }

        //当前页
        $str += '<li class="paginItem current"><a href="javascript:;">'+_pn+'</a></li>';

        //后4页
        for (var i=_pn+1; i<=_pn+4; i++){
            if(i <= _pagetotal){
                $str += '<li class="paginItem"><a href="javascript:;" data-pn="'+ i +'">'+ i +'</a></li>';
            }
        }

        //如果当前小于5，但实际页码，在9以上，要在4之后加上56789 追加显示到第9页
        if( _pn < 5 && _pagetotal>_pn+4 ){
            for (var i=_pn+5; i<=9; i++){
                if( i <= _pagetotal){
                    $str += '<li class="paginItem"><a href="javascript:;" data-pn="'+ i +'">'+ i +'</a></li>';
                }
            }
        }
        
        if(_pn<_pagetotal)
        {
            $str += '<li class="paginItem"><a href="javascript:;"  data-pn="' + (_pn+1) + '"><span class="pagenxt"></span></a></li>';
        }else
        {   
            $str += '<li class="paginItem"><a href="javascript:;" class="disabled"><span class="pagenxt"></span></a></li>';
        }
        
        $str += '</ul>';
        
        return $str;

    }

   

    // 数据仓库
    window.datastorage = {
        // 产品类型
        protype: ["股票型","管理期货","混合型"],
        // 投资策略 
        strategy:["宏观策略","市场中性","量化对冲","价值投资","套利","趋势","并购重组","定向增发"],
        // 付息方式 
        paytype: ["按月付息","按季付息","半年付息","按年付息","到期付息"],
        // 投资领域 
        pest : ["工商企业","金融市场","基础设施","房地产","工矿企业","其他"],
        // 大小配比
        ratiosize: ["小额畅打","严格配比","全大额"]
    } 

})
