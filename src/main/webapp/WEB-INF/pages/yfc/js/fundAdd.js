define(function(require, exports, modules){
	var $ = require("jquery");
       	require("select")($);
        require("editor");
        require("datepicker")($);
        require("modules/upload");    
    var KE;
    KindEditor.ready(function(K) {
        KE = K.create('#content7', {
            allowFileManager : true
        });
    });

    $(".select1").uedSelect({
        width: 345
    });
   

     // 时间控件
    $('.datepicker').datetimepicker({
        language:'zh-CN',
        format:'yyyy-mm-dd',
        endDate: new Date(),
        autoclose: true,
        minView:2
    });  

    // form 提交
    $('#form').find('.btn').on('click',function(){
        $('#content7').text(KE.html());
        var buynumbers=[],incomeratios=[],commissions=[];
        $('.buynumber').each(function(){
            buynumbers.push($(this).val());
        });
        $('.incomeratio').each(function(){
            incomeratios.push($(this).val());
        });
        $('.commission').each(function(){
            commissions.push($(this).val());    
        });
        $('input[name=buynumbers]').val(buynumbers);
        $('input[name=incomeratios]').val(incomeratios);
        $('input[name=commissions]').val(commissions);
        // 表 $("#form").serializeArray()单提交url
        // 
        var numarrs = ["protype","strategy","threshold"];

        $.ajax( {
            url: '/fund/new',
            type: 'post',
            dataType: 'JSON',
            contentType: 'application/json',
            data: JSON.stringify($("#form").serializeObject(numarrs)),
            success: function (data) {
               if(data.success){
                    actiondone.success(function(){
                        history.go(-1);
                    });
                }else{
                    actiondone.fail();
                }
            }
        });
        return false;
    });
})