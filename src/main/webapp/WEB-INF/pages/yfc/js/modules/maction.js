define(function(require, exports, modules){
	var $ = require("jquery");


	window.actiondone = {
		init: function(){
			var html ="<div class='popup' id='successpop'><div class='container'></div></div>";
				html += "<div class='popup' id='failpop'><div class='container'></div></div>";

			$('body').append(html);
		},
		success: function(fn){
			$('#successpop').show();
            setTimeout(function(){
                $('#successpop').fadeOut(function(){
                	if($.isFunction(fn)){
	            		fn();
	            	}
                });
            },2000);
		},
		fail: function(fn){
			$('#failpop').show();
            setTimeout(function(){
                $('#failpop').fadeOut(function(){
	            	if($.isFunction(fn)){
	            		fn();
	            	}
	            });
            },2000);
		}
	}
	actiondone.init();
	
})	

