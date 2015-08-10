define(function(require, exports, modules){
	var $ = require("jquery");
    	require("select")($);
        require("editor");
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

        var numarrs = ["paytype","pest","ratiosize","collectpregress","threshold"];
        console.log(JSON.stringify($("#form").serializeObject(numarrs)));
        // 表单提交url
        $.ajax({
            url: '/asset/new',
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