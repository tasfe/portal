define(function(require,exports,moudles){
    return function($){
    /*
        author: jiangzhiqiang
     */
    (function($) {
        $.fn.popup = function(options){
            var defaults = {
                beforeShow : null,
                afterShow : null,
                isDrag : true
            };
            var opts = $.extend(defaults, options),$pop;
            var dragmove = function(pop) {
                if (!opts.isDrag) return false;
                var bDrag = false;
                var _x, _y;
                var trig = pop.find('.pop-header');
                var popcontainer = pop.find('.pop-container');
                trig.mousedown(function(event) {
                    var e = event || window.event;
                    bDrag = true;
                    _x = e.pageX - popcontainer.offset().left;
                    _y = e.pageY - popcontainer.offset().top;

                    trig.css('cursor', 'move');
                    $(document).mousemove(function(event) {
                        if (!bDrag) return false;
                        trig.css('cursor', 'move');
                        var e = event || window.event;
                        var x = e.pageX - _x;
                        var y = e.pageY - _y;
                        var maxL = $(document).width() - popcontainer.outerWidth();
                        var maxT = $(document).height() - popcontainer.outerHeight();
                        x = x < 0 ? 0  : x;
                        x = x > maxL ? maxL : x;
                        y = y < 0 ? 0  : y;
                        y = y > maxT ? maxT : y;
                        popcontainer.css({
                            left: x,
                            top: y
                        });
                        return false;
                    }).mouseup(function() {
                        trig.css('cursor', 'default');
                        return bDrag = false;
                    })
                });
            };
            var show = function(pop) {
                if (opts.beforeShow) opts.beforeShow(pop);
                pop.fadeIn(function(){
                    if (opts.afterShow) opts.afterShow(pop);
                });
                pop.on('click','.pop-close',function(){
                   hide(100); 
                });
            };
            var hide = function(time) {
                $pop.fadeOut(time);
            };

            return this.each(function() {
                $pop = $(this);
                if(opts.isDrag){
                    dragmove($pop);
                }
                show($pop);
            });
        }
    })(jQuery);
    }
})