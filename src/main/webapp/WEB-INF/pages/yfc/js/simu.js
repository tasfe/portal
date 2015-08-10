define(function(require, exports, modules){
    var $ = require("jquery");
        require("modules/main");
    var template = require("public/arttemplate.js");    
    var render = function(npage){
        $.ajax({
            url:'/product/donation/'+npage,
            dataType:'JSON',
            type:"get",
            cache: false,
            success:function(json){
            	if(json.success){
            		console.log(json);
            		console.log(JSON.stringify(json));
                for(var i=0;i<json.data.length;i++){
                    var obj = json.data[i];
                    obj.protypetext = datastorage.protype[obj.protype];
                    obj.strategytext = datastorage.strategy[obj.strategy];
                    obj.comment = obj.comment.substring(0,20)+"...";
                    obj.prointro = obj.prointro.substring(0,20)+"...";
                }
                var html = template('cntItemTpl', json); 
                $('#cntul').html(html);

                $('.tablelist tbody tr:odd').addClass('odd');

                var html = pageBar(json.totalCount,10,json.currentPage);

                $('#pagination').html(html);
            	}
            }
        })      
    }
    render(1);
    // 分页
    $('#pagination').on('click','.paginItem:not(.current)',function(){
        var datapn = $(this).find('a').attr("data-pn");
        render(datapn);
    }) 

    function getids(){
        var ids = [];
        $('.ui-datagrid').find('.ui-chk:checked').each(function(){
            var id = $(this).closest('tr').attr('data-id');
            ids.push(id);
        });
        return ids;
    }

     // 删除
    $('#delpop').on('click','.sure',function(){
        $.ajax({
            url:'/donation/delete/'+getids().join(','),
            dataType:'JSON',
            type:"delete",
            success:function(data){
                if(data.success){
                    actiondone.success();
                    var currentPage = $('#pagination').find('.blue:last').text() || 1;
                    render(currentPage);

                }else{
                    actiondone.fail();
                }
            }
        })
        $('#delpop').hide();
    });
})