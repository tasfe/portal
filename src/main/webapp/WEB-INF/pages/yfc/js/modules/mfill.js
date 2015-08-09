define(function(require, exports, modules) {
    var $ = require("jquery");

    window.fill = function(data) {
        var max = 1;
        var buynumbers = [],
            incomeratios = [],
            commissions = [];
        for (var x in data) {
            // input 类型直接赋值
            if (x != 'relatedoc') {
                $('#form').find('input[name=' + x + ']').val(data[x]);
                // textarea  类型 直接赋值
                $('#form').find('textarea[name=' + x + ']').val(data[x]);
                // select  类型 
                $('#form').find('select[name=' + x + ']').val(data[x]);
            } else {
                if (data[x].length > 0) {
                    $('#form').find('.uploadtext').show().find('em').text(data[x]);
                }
            }

            if (x == 'protype' || x == 'strategy') {
                var select = $('#form').find('select[name=' + x + ']');
                var text = select.find('option[value=' + data[x] + ']').text();
                select.closest('.uew-select').find('.uew-select-text').text(text);
            }


            if (x == 'buynumbers' || x == 'incomeratios' || x == 'commissions') {
                switch (x) {
                    case 'buynumbers':
                        buynumbers = data[x].split(",");
                        max = buynumbers.length > max ? buynumbers.length : max;
                        break;
                    case 'incomeratios':
                        incomeratios = data[x].split(",");
                        max = incomeratios.length > max ? incomeratios.length : max;
                        break;
                    case 'commissions':
                        commissions = data[x].split(",");
                        max = commissions.length > max ? commissions.length : max;
                        break;
                }
            }
        }
        var tr = $('#sylist').find('tbody > tr').eq(0);
        var othertr = tr.clone();
        othertr.find('.del').removeClass('disable');
        // 清楚内容
        othertr.find('input').empty();
        for (var i = 1; i < max; i++) {
            $('#sylist').find('tbody').append(othertr[0].outerHTML);
        }

        for (var i = 0; i < buynumbers.length; i++) {
            $('.buynumber').eq(i).val(buynumbers[i]);
        }

        for (var i = 0; i < incomeratios.length; i++) {
            $('.incomeratio').eq(i).val(incomeratios[i]);
        }

        for (var i = 0; i < commissions.length; i++) {
            $('.commission').eq(i).val(commissions[i]);
        }
    }
})
