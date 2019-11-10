$(document).ready(function () {
    family_add.onload();
});
let family_add = (function () {


    layui.use(['form', 'element', 'laydate'], function () {
        var element, laydate, form;
        element = layui.element;
        laydate = layui.laydate;
        form = layui.form;


        var poverty_causes1_value,poverty_causes2_value,poverty_causes3_value;

        // 提交限制
        // element.on('tab(addBaseInfo)', function (data) {
        //
        //     if(!$("#baseid").val() && data.index != 0) {
        //         layer.open('请先保存基本信息', {btn : ['确定']}, function () {
        //             console.log('123');
        //         });
        //         layer.open({title : '提示', skin: 'layui-layer-lan',content:'请先提交基本信息', btn: ['确定'],end:
        //                 function(index, layero){
        //                     element.tabChange('addBaseInfo','1');
        //             }});
        //     }
        // });


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

        // 加载js初始化市的下拉框，待优化
        $.get("/getRegion", function (data) {
            $.each(data, function (index, item) {
                $("#city").append(new Option(item.name, item.id));
            });
            layui.form.render('select');
        });

        // 基本信息表单提交
        form.on('submit(base1)', function (data) {
            $.ajax({
                url: '/family/add',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function(xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content") ,$("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        $("#baseid").val(res.data);
                        layer.msg("✔ 保存成功!");
                    }
                    else {
                        layer.msg("× 保存失败");
                    }
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

        //
        form.on('select(county)', function (data) {
            $.get("/getRegion",{id : data.value}, function (data) {
                $("#town").empty();
                $.each(data, function (index, item) {
                    $("#town").append(new Option(item.name, item.id));
                });
                layui.form.render('select');
            });
        });

        // 致贫原因1的事件
        form.on("select(poverty_causes1)", function(data){
            poverty_causes1_value = data.value;
            if(data.value == '') {
                // 将选型二三恢复
                $("#poverty_causes2 option").attr("disabled",false);
                $("#poverty_causes3 option").attr("disabled",false);
                // 第一项
                $('#poverty_causes2').find("option[value='']").attr('selected',true);
                $('#poverty_causes3').find("option[value='']").attr('selected',true);
                layui.form.render('select');
                return;
            }
            $("#poverty_causes2 option").attr("disabled",false);
            $("#poverty_causes3 option").attr("disabled",false);
            // 以1为主，如果1选择了，则其余两个无法选择，存在冲突则以1为准
            // 如果2的值跟1相等则2还原
            if($("#poverty_causes2").val() == data.value) {
                $('#poverty_causes2').find("option[value='']").attr('selected',true);
            }
            // 将2中1已选择的禁用
            $('#poverty_causes2').find("option[value=" + data.value +"]").attr('disabled',true);

            // 如果3的值与1相等则还原三
            if($("#poverty_causes3").val() == data.value) {
                $('#poverty_causes3').find("option[value='']").attr('selected',true);
            }
            // 将3中1已选择的禁用
            $('#poverty_causes3').find("option[value=" + data.value +"]").attr('disabled',true);
            // 如果2不为空，则还需要将2已选择的值禁用
            if(poverty_causes2_value != '') {
                $('#poverty_causes3').find("option[value=" + poverty_causes2_value +"]").attr('disabled',true);
            }
            layui.form.render('select');
        });

        // 致贫原因2的事件
        form.on("select(poverty_causes2)", function(data){
            poverty_causes2_value = data.value;
            // 如果2不选择，则3置空
            if(data.value == '') {
                $("#poverty_causes3 option").attr("disabled",false);
                if(poverty_causes1_value != '') {
                    $('#poverty_causes3').find("option[value=" + poverty_causes1_value +"]").attr('disabled',true);
                }
                layui.form.render('select');
                return;
            }
            $("#poverty_causes3 option").attr("disabled",false);
            if(poverty_causes1_value != '')
                $('#poverty_causes3').find("option[value=" + poverty_causes1_value +"]").attr('disabled',true);
            if($("#poverty_causes3").val() == data.value) {
                $('#poverty_causes3').find("option[value='']").attr('selected',true);
            }
            // 将3中2已选择的禁用
            $('#poverty_causes3').find("option[value=" + data.value +"]").attr('disabled',true);
            layui.form.render('select');
        });
    });

    return {
        onload: function () {

        }
    };
})();


