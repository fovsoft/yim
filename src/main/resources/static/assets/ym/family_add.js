$(document).ready(function () {
    family_add.onload();
});
let family_add = (function () {


    layui.use(['form', 'element', 'laydate', 'table'], function () {
        var element, laydate, form, table;
        element = layui.element;
        laydate = layui.laydate;
        form = layui.form;
        table = layui.table;


        var poverty_causes1_value, poverty_causes2_value, poverty_causes3_value;

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

        /* ***** 表单提交开始 **** */

        // 基本信息
        form.on('submit(base1)', function (data) {
            $.ajax({
                url: '/family/add',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
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

        // 致贫原因及家庭人口情况
        form.on('submit(base3)', function (data) {
            data.field.fid = $("#baseid").val();
            $.ajax({
                url: '/family/addAddition',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        console.log(res.data);
                        $("#additionid").val(res.data);
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

        // 生产生活条件表单
        form.on('submit(base4)', function (data) {
            data.field.fid = $("#baseid").val();
            $.ajax({
                url: '/family/addCondition',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        $("#conditionid").val(res.data);
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
        /* ***** 表单提交结束 **** */


        form.on('select(city)', function (data) {
            $.get("/getRegion", {id: data.value}, function (data) {
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
            $.get("/getRegion", {id: data.value}, function (data) {
                $("#town").empty();
                $.each(data, function (index, item) {
                    $("#town").append(new Option(item.name, item.id));
                });
                layui.form.render('select');
            });
        });

        // 致贫原因1的事件
        form.on("select(poverty_causes1)", function (data) {
            poverty_causes1_value = data.value;
            if (data.value == '') {
                // 将选型二三恢复
                $("#poverty_causes2 option").attr("disabled", false);
                $("#poverty_causes3 option").attr("disabled", false);
                // 第一项
                $('#poverty_causes2').val('');
                $('#poverty_causes3').val('');
                layui.form.render('select');
                return;
            }
            $("#poverty_causes2 option").attr("disabled", false);
            $("#poverty_causes3 option").attr("disabled", false);
            // 以1为主，如果1选择了，则其余两个无法选择，存在冲突则以1为准
            // 如果2的值跟1相等则2还原
            if ($("#poverty_causes2").val() == data.value) {
                $('#poverty_causes2').val('');
            }
            // 将2中1已选择的禁用
            $('#poverty_causes2').find("option[value=" + data.value + "]").attr('disabled', true);

            // 如果3的值与1相等则还原三
            if ($("#poverty_causes3").val() == data.value) {
                $('#poverty_causes3').val('');
            }
            // 将3中1已选择的禁用
            $('#poverty_causes3').find("option[value=" + data.value + "]").attr('disabled', true);
            // 如果2不为空，则还需要将2已选择的值禁用
            if (poverty_causes2_value != '') {
                $('#poverty_causes3').find("option[value=" + poverty_causes2_value + "]").attr('disabled', true);
            }
            layui.form.render('select');
        });

        // 致贫原因2的事件
        form.on("select(poverty_causes2)", function (data) {
            poverty_causes2_value = data.value;
            // 如果2不选择，则3置空
            if (data.value == '') {
                $("#poverty_causes3 option").attr("disabled", false);
                if (poverty_causes1_value != '') {
                    $('#poverty_causes3').find("option[value=" + poverty_causes1_value + "]").attr('disabled', true);
                    $('#poverty_causes3').val('');
                }
                layui.form.render('select');
                return;
            }
            $("#poverty_causes3 option").attr("disabled", false);
            if (poverty_causes1_value != '') {
                $('#poverty_causes3').find("option[value=" + poverty_causes1_value + "]").attr('disabled', true);
            }

            if ($("#poverty_causes3").val() == data.value) {
                $('#poverty_causes3').val('');
            }
            // 将3中2已选择的禁用
            $('#poverty_causes3').find("option[value=" + data.value + "]").attr('disabled', true);
            layui.form.render('select');
        });


        // 主要燃料类型
        // 如选择“其他”则放开“具体燃料名称”，反之禁用
        form.on("select(type_fuel)", function (data) {
            if (data.value == 5) {
                $("#label_type_fuel_other").css("color", '');
                $("#type_fuel_other").removeClass("layui-disabled");
                $("#type_fuel_other").attr("disabled", false);
                $("#type_fuel_other").attr("lay-verify", "required");
            }
            else {
                $("#label_type_fuel_other").css("color", 'gainsboro');
                $("#type_fuel_other").addClass("layui-disabled");
                $("#type_fuel_other").val('');
                $("#type_fuel_other").attr("disabled", true);
                $("#type_fuel_other").removeAttr("lay-verify", "required");
            }
            layui.form.render();
        });

        /**
         * 家庭成员列表
         */
        table.render({
            elem: '#tableMember'
            , url: '/family/getMemberList'
            , toolbar: '#tableMemberToolbar' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '家庭成员表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID'}
                , {field: 'name', title: '姓名', width: 80, edit: 'text'}
                , {field: 'username', title: '性别', width: 60, edit: 'text'}
                , {field: 'username', title: '证件号码', width: 100, edit: 'text'}
                , {field: 'username', title: '与户主关系', width: 60, edit: 'text'}
                , {field: 'username', title: '民族', width: 60, edit: 'text'}
                , {field: 'username', title: '政治面貌', width: 60, edit: 'text'}
                , {field: 'username', title: '文化程度', width: 60, edit: 'text'}
                , {field: 'username', title: '在校生情况', width: 60, edit: 'text'}
                , {field: 'username', title: '失学或辍学原因', width: 60, edit: 'text'}
                , {field: 'username', title: '健康状况', width: 60, edit: 'text'}
                , {field: 'username', title: '劳动技能', width: 60, edit: 'text'}
                , {field: 'username', title: '是否会讲普通话', width: 60, edit: 'text'}
                , {field: 'username', title: '是否参加城乡居民医疗保险', width: 60, edit: 'text'}
                , {field: 'username', title: '是否参加商业补充医疗保险', width: 60, edit: 'text'}
                , {field: 'username', title: '是否享受农村居民最低生活保障', width: 60, edit: 'text'}
                , {field: 'username', title: '是否参加农村居民基本养老保险', width: 60, edit: 'text'}
                , {field: 'username', title: '是否享受人身意外保险补贴', width: 60, edit: 'text'}
                , {field: 'username', title: '联系电话', width: 120, edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#tableMemberBar', width: 120}
            ]]
            , page: false
            , done: function (res, curr, count) {
                $("[data-field='id']").css('display', 'none');
            }
        });

        // 新增家庭成员
        table.on('toolbar(tableMember)', function (obj) {
            let checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: '新增家庭成员',
                        type: 2,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['70%', '60%'], //宽高
                        content: '/memberAdd',
                        moveOut : true,

                    });
                    break;
                case 'del':
                    var data = checkStatus.data;
                    var ids = [];
                    $.each(data, function (i, n) {
                        ids.push(n.id);
                    });
                    layer.alert(JSON.stringify(ids));
                    break;
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
            }
            ;
        });

        //监听工具条
        table.on('tool(tableMember)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            }
        });
    });

    return {
        onload: function () {

        }
    };
})();


