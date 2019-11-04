$(document).ready(function () {
    family_add.onload();
});
let family_add = (function () {


    layui.use(['form', 'element', 'laydate'], function () {
        var element, laydate, form;
        element = layui.element;
        laydate = layui.laydate;
        form = layui.form;

        element.on('tab(addBaseInfo)', function (data) {

            if(!$("#baseid").val() && data.index != 0) {
                layer.open('请先保存基本信息', {btn : ['确定']}, function () {
                    console.log('123');
                });
                layer.open({title : '提示', skin: 'layui-layer-lan',content:'请先提交基本信息', btn: ['确定'],end:
                        function(index, layero){
                            element.tabChange('addBaseInfo','1');
                    }});
            }
        });


        laydate.render({
            elem: '#poverty_relief_tm',
            type: 'year',
            trigger: 'click'
        });

        laydate.render({
            elem: '#poverty_rtn_tm',
            type: 'year',
            trigger: 'click'
        });


        $.get("/getRegion", function (data) {
            $.each(data, function (index, item) {
                $("#city").append(new Option(item.name, item.id));
            });
            layui.form.render('select');
            // layui.form.render('select', 'city');
        });


        form.on('submit(base1)', function (data) {
            $.ajax({
                url: '/family/add',
                method: 'post',
                data: data.field,
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function(xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content") ,$("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        parent.closeIframe(res.msg);
                    }
                    else
                        alert(res.msg);
                },
                error: function (data) {

                }
            });
        });

        form.on('select(city)', function (data) {
            $.get("/getRegion",{id : data.value}, function (data) {
                $("#county").empty();
                $.each(data, function (index, item) {
                    $("#county").append(new Option(item.name, item.id));
                });
                $("#town").empty();
                layui.form.render('select');
                // layui.form.render('select', 'county');
            });
        });

        form.on('select(county)', function (data) {
            $.get("/getRegion",{id : data.value}, function (data) {
                $("#town").empty();
                $.each(data, function (index, item) {
                    $("#town").append(new Option(item.name, item.id));
                });
                layui.form.render('select');
            });
        });
    });

    return {
        onload: function () {

        }
    };
})();


