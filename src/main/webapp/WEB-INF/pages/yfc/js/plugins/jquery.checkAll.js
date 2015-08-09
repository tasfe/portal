define(function(require,exports,moudles){
    return function($){
/*
    author: jiangzhiqiang
 */
(function($) {
    $.fn.checkAll = function(options){
        var defaults = {
            checkAll : false,
            beforeCheck : null,
            afterCheck : null
        };
        var opts = $.extend(defaults, options), dataChks = [];
        
        var init = function(checks){
            if(opts.beforeCheck) opts.beforeCheck(checks);
            var data_flag = checks.attr('id');
            var totalLens = 0;
            $('.ui-chk').each(function(){
                var u_flag = $(this).attr('data-target');
                if(data_flag == u_flag){
                    totalLens ++;
                    dataChks.push($(this));
                }
            });
            checks.off('click').on('click',function(){
                for(var i=0;i<dataChks.length;i++){
                    dataChks[i].prop('checked',checks.is(':checked'));
                }
            });

            var curlength = 0;


            var allCheck = function(){
                var bool = true;
                for(var i=0;i<dataChks.length;i++){
                    if(!$(dataChks[i]).is(':checked')){
                       return bool = false;
                    }
                };
                return bool;
            } 

            for(var i=0;i<dataChks.length;i++){
                $(dataChks[i]).off('click').on('click',function(){
                    checks.prop('checked',allCheck());
                });
            };
           
            
            if(opts.afterCheck) opts.afterCheck(checks);
        }

        return this.each(function() {
            init($(this));
        });
    }
})(jQuery);

    }   
})