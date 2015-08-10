define(function(require, exports, modules){
	var $ = require("jquery");
       /* require("cloud")($);*/
	//导航切换
    $('.loginbox').css({
        'position': 'absolute',
        'left': ($(window).width() - 692) / 2
    });
    $(window).resize(function() {
        $('.loginbox').css({
            'position': 'absolute',
            'left': ($(window).width() - 692) / 2
        });
    });
    $('#form').find('.btn').on('click',function(){
    	//var account = {"mobilePhone":$('#mobilePhone').val(),"pwd":$('#pwd').val()};
    	
    	
    	$.ajax({
            url: "/login/manager",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
			data: JSON.stringify({
				"mobilePhone" : $("#mobilePhone").val(),
				"pwd" : $("#pwd").val()
			}),
            success: function (data) {
                if(data.success){
                   console.log(data);
                   window.location.href="main.html"; 
                }
            }
        });
//    	
//    	$.ajax({
//			type : 'post',
//			async : false,
//			contentType : "application/json",
//			url : ctx + '/videocourse/add',
//			dataType : "json",
//			data : JSON.stringify(_this.videoCourse),
//			success : function(data) {
//				if(data.success){
//					util.dialog.messageModal('创建成功',function(){
//						window.location.href = window.location.href; 
//					});
//				}
//			}
//		});
         
    });
})