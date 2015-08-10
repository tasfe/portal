define(function(require, exports, modules){
	var $ = require("jquery");

	require("modules/maction");

	// 添加行
	$('#sylist').on('click','.add',function(){
		var tr = $('#sylist').find('tbody > tr').eq(0);
		var othertr = tr.clone();
		othertr.find('.del').removeClass('disable');
		// 清楚内容
		othertr.find('input').empty();

		$('#sylist').find('tbody').append(othertr[0].outerHTML);
	});

	// 删除行
	$('#sylist').on('click','.del:not(.disable)',function(){
		var tr = $(this).closest('tr');
		tr.remove();
	});

	
})	