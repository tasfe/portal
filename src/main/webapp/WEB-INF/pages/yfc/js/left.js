define(function(require, exports, modules){
	var $ = require("jquery");
	//导航切换
    $(".menuson li").click(function() {
        $(".menuson li.active").removeClass("active")
        $(this).addClass("active");
    });

    $('.leftmenu').off('click').on('click','.title',function() {
        var cul = $(this).next('ul');
        cul.slideToggle(); 
    });
})