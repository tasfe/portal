define(function(require, exports, modules){
	var $ = require("jquery");
	    require('modules/deftable');
	    require("modules/mfill");
	$.fn.serializeObject = function(arrs) {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var value = this.value || '';
	    	// 说明在数组中
	    	if(arrs.indexOf(this.name) > -1){
            	value = Number(value) || 0;
            }
	        if (o[this.name]) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name] = value;
	        } else {
	            o[this.name] = value;
	        }
	    });
	    console.log(o);
	    return o;
	};

	/*var inputfile = $('#uploadwrap').find('input[type=file]').clone();
		inputhtml = inputfile[0].outerHTML;

	// 监听文件上传 
	$('#uploadwrap').on("change","input[type=file]",function(){
		var filename = getFileName(getFullPath(this));
		var uploadtext = $('#uploadwrap').find('.uploadtext');
		uploadtext.find('em').text(filename);
		uploadtext.show();

	});	

	// 监听移除按钮
	$('#uploadwrap').on('click','.remove',function(){
		// 隐藏本身， 清空内容 ， 替换input
		var uploadtext = $('#uploadwrap').find('.uploadtext').hide();
		uploadtext.find('em').empty();

		$('#uploadwrap').find('input[type=file]').remove();
		$('#uploadwrap').find('.uploadwrap').append(inputhtml);
	});

	function getFullPath(obj) {
	    if (obj) {
	        if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
	            if (obj.files) {
	                return obj.files.item(0).name;
	            }
	            return obj.value;
	        }
	        return obj.value;
	    }
	}

	function getFileName(path) {
	    var pos1 = path.lastIndexOf('/');
	    var pos2 = path.lastIndexOf('\\');
	    var pos = Math.max(pos1, pos2)
	    if (pos < 0)
	        return path;
	    else
	        return path.substring(pos + 1);
	}
*/

})	