(function (w, $) {
    /** 设置jqGrid插件的全局默认值 */

    $.extend({
        getFormData: function (form) {
            var data = {};
            var inputs = $(form + " :input");
            $.each(inputs, function (i, n) {
                data[n.name] = n.value;
            });
            return data;
        }
    });

    $.extend($.jgrid.defaults, {
        mtype: 'get',
        datatype: 'json',
        rowNum: 20,
        rowList: [10, 25, 20],
        jsonReader: {
            root: "dateList",
            repeatitems: false
        },
        altRows: true,// 隔行变色
        altclass: 'jqgrid-altclass',// 隔行变色样式
        multiselect: true,
        viewrecords: true,
        height: "auto",
        autowidth: true,
        hidegrid: false,// 禁用控制表格显示、隐藏的按钮
        loadtext: "努力加载中.....",
        rownumbers: true,
        sortorder: "desc",
        sortable: false,
        resizable: false
    });
}(window, jQuery));