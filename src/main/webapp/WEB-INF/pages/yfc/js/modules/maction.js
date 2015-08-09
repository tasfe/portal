define(function(require, exports, modules){
	var $ = require("jquery");


	window.actiondone = {
		init: function(){
			var html ="<div class='popup' id='successpop'><div class='container'></div></div>";
				html += "<div class='popup' id='failpop'><div class='container'></div></div>";

			$('body').append(html);
		},
		success: function(){
			$('#successpop').show();
            setTimeout(function(){
                $('#successpop').fadeOut();
            },2000);
		},
		fail: function(){
			$('#failpop').show();
            setTimeout(function(){
                $('#failpop').fadeOut();
            },2000);
		}
	}
	actiondone.init();
	
})	

