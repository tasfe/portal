define(function(require, exports, modules){
	var $ = require("jquery");
        require("select")($);
        require("tab")($);
        require("editor")($);

	$("#usual1 ul").idTabs();
    $('.tablelist tbody tr:odd').addClass('odd');
    KE.show({
        id: 'content7',
        skinsPath:'js/editor/skins/'
    });

    $(".select1").uedSelect({
        width: 345
    });
   
})