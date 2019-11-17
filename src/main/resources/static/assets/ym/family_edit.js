$(document).ready(function () {
    family_add.onload();
});
let family_add = (function () {

    // 首次更新标志
    let initTab1 = 0;
    let initTab2 = 0;
    let initTab3 = 0;

    layui.use(['form', 'element', 'laydate', 'table'], function () {
        var element, laydate, form, table;
        element = layui.element;
        laydate = layui.laydate;
        form = layui.form;
        table = layui.table;


        var poverty_causes1_value, poverty_causes2_value, poverty_causes3_value;

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
        // $.get("/getRegion", function (data) {
        //     $.each(data, function (index, item) {
        //         $("#city").append(new Option(item.name, item.id));
        //     });
        //     layui.form.render('select');
        // });

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
                    if (res.code == 0) {
                        if (res.data) {
                            $("#baseid").val(res.data);
                        }
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
            data.field.id = $("#additionid").val();
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
            data.field.id = $("#conditionid").val();
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

        /* ***** tab切换事件开始 **** */
        element.on('tab(addBaseInfo)', function(data){
            let fid = $("#baseid").val();
            // 家庭成员
            if(data.index == 1) {
                if(initTab1 == 0) {
                    layui.table.reload('tableMember', {
                        where: {
                            fid: fid
                        }
                    });
                    initTab1 = 1;
                }
            }
            // 致贫原因
            if(data.index == 2) {
                if(initTab2 == 0) {
                    $.ajax({
                        url : '/family/getAddition',
                        data : {fid : fid},
                        dataType: 'JSON',
                        success : function(res) {
                            // console.log(res.data);
                            form.val('form3', {
                                'additionid' : res.data.additionid,
                                'poverty_causes1' : res.data.poverty_causes1,
                                'poverty_causes2' : res.data.poverty_causes2,
                                'poverty_causes3' : res.data.poverty_causes3,
                                'household_num_Jan' : res.data.household_num_Jan,
                                'household_num_Dec' : res.data.household_num_Dec
                            });
                            form.render();
                        }
                    });
                    initTab2 = 1;
                }
            }
            // 生产生活条件
            if(data.index == 3) {
                if(initTab3 == 0) {
                    $.ajax({
                        url : '/family/getCondition',
                        data : {fid : fid},
                        dataType: 'JSON',
                        success : function(res) {
                            console.log(res);
                            // 单独处理燃料的其他项
                            if(res.data.type_fuel == 5) {
                                $("#label_type_fuel_other").css("color", '');
                                $("#type_fuel_other").removeClass("layui-disabled");
                                $("#type_fuel_other").attr("disabled", false);
                                $("#type_fuel_other").attr("lay-verify", "required");
                            }
                            form.val('form4', {
                                'conditionid' : res.data.conditionid,
                                'area_cultivated' : res.data.area_cultivated,
                                'area_woodland' : res.data.area_woodland,
                                'area_turninto' : res.data.area_turninto,
                                'area_fruit' : res.data.area_fruit,
                                'area_foragegrass' : res.data.area_foragegrass,
                                'area_waters' : res.data.area_waters,
                                'is_cooperative' : res.data.is_cooperative,
                                'get_leaded' : res.data.get_leaded,
                                'get_pioneer' : res.data.get_pioneer,
                                'get_electric' : res.data.get_electric,
                                'get_television' : res.data.get_television,
                                'get_potablewater' : res.data.get_potablewater,
                                'get_toilet' : res.data.get_toilet,
                                'distance_mainroad' : res.data.distance_mainroad,
                                'type_road' : res.data.type_road,
                                'area_housing' : res.data.area_housing,
                                'is_dilapidated' : res.data.is_dilapidated,
                                'level_dilapidated' : res.data.level_dilapidated,
                                'year_reform' : res.data.year_reform,
                                'type_fuel' : res.data.type_fuel,
                                'type_fuel_other' : res.data.type_fuel_other,
                            });
                            form.render();
                        }
                    });
                    initTab3 = 1;
                }
            }

            // console.log(this); //当前Tab标题所在的原始DOM元素
            // console.log(data.index); //得到当前Tab的所在下标
            // console.log(data.elem); //得到当前的Tab大容器
            // console.log($("#"))
        });
        /* ***** tab切换事件结束 **** */

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
                {field: 'memberid', title: 'ID'}
                , {field: 'member_name', title: '姓名',minWidth:100}
                , {field: 'sex', title: '性别'}
                , {field: 'id_num', title: '证件号码', minWidth:180}
                , {field: 'relation', title: '与户主关系'}
                , {field: 'nation', title: '民族'}
                , {field: 'political_exp', title: '政治面貌'}
                , {field: 'level_edu', title: '文化程度'}
                , {field: 'school_status', title: '在校生情况'}
                , {field: 'stopedu_rsn', title: '失学或辍学原因'}
                , {field: 'healthy_status', title: '健康状况'}
                , {field: 'labor_skill', title: '劳动技能'}
                , {field: 'can_mandarin', title: '是否会讲普通话'}
                , {field: 'medical_insurance', title: '是否参加城乡居民医疗保险'}
                , {field: 'business_insurance', title: '是否参加商业补充医疗保险'}
                , {field: 'basic_allowances', title: '是否享受农村居民最低生活保障'}
                , {field: 'endowment_insurance', title: '是否参加农村居民基本养老保险'}
                , {field: 'accident_insurance', title: '是否享受人身意外保险补贴'}
                , {field: 'tel', title: '联系电话',minWidth:130}
                , {title: '操作', toolbar: '#tableMemberBar', minWidth:130}
            ]]
            , page: false
            , done: function (res, curr, count) {

                $("[data-field='sex']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("男")
                    } else if ($(this).text() == 0) {
                        $(this).text("女");
                    }
                });

                $("[data-field='relation']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("户主")
                    } else if ($(this).text() == 2) {
                        $(this).text("之子");
                    } else if ($(this).text() == 3) {
                        $(this).text("之女");
                    } else if ($(this).text() == 4) {
                        $(this).text("之配偶");
                    } else if ($(this).text() == 5) {
                        $(this).text("之父");
                    } else if ($(this).text() == 6) {
                        $(this).text("之母");
                    }
                });

                $("[data-field='nation']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("汉族")
                    } else if ($(this).text() == 2) {
                        $(this).text("壮族");
                    } else if ($(this).text() == 3) {
                        $(this).text("瑶族");
                    } else if ($(this).text() == 4) {
                        $(this).text("水族");
                    }
                });

                $("[data-field='political_exp']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("群众")
                    } else if ($(this).text() == 2) {
                        $(this).text("党员");
                    } else if ($(this).text() == 3) {
                        $(this).text("民盟成员");
                    } else if ($(this).text() == 4) {
                        $(this).text("共青团员");
                    }
                });

                $("[data-field='level_edu']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("文盲")
                    } else if ($(this).text() == 2) {
                        $(this).text("小学");
                    } else if ($(this).text() == 3) {
                        $(this).text("初中");
                    } else if ($(this).text() == 4) {
                        $(this).text("高中");
                    } else if ($(this).text() == 5) {
                        $(this).text("本科");
                    }
                });

                $("[data-field='school_status']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("非在校生")
                    } else if ($(this).text() == 2) {
                        $(this).text("学前教育");
                    } else if ($(this).text() == 3) {
                        $(this).text("七年级");
                    } else if ($(this).text() == 4) {
                        $(this).text("八年级");
                    } else if ($(this).text() == 5) {
                        $(this).text("九年级");
                    } else if ($(this).text() == 6) {
                        $(this).text("高一");
                    } else if ($(this).text() == 7) {
                        $(this).text("高二");
                    } else if ($(this).text() == 8) {
                        $(this).text("高三");
                    } else if ($(this).text() == 9) {
                        $(this).text("中职一");
                    }
                });

                $("[data-field='stopedu_rsn']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("因病")
                    } else if ($(this).text() == 2) {
                        $(this).text("因疾");
                    } else if ($(this).text() == 3) {
                        $(this).text("厌学");
                    } else if ($(this).text() == 4) {
                        $(this).text("其他");
                    }
                });

                $("[data-field='healthy_status']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("健康")
                    } else if ($(this).text() == 2) {
                        $(this).text("残疾");
                    } else if ($(this).text() == 3) {
                        $(this).text("大病");
                    } else if ($(this).text() == 4) {
                        $(this).text("长期慢性病");
                    }
                });

                $("[data-field='labor_skill']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("普通劳动力")
                    } else if ($(this).text() == 2) {
                        $(this).text("技能劳动力");
                    } else if ($(this).text() == 3) {
                        $(this).text("弱劳动力或半劳动力");
                    } else if ($(this).text() == 4) {
                        $(this).text("丧失劳动力");
                    } else if ($(this).text() == 4) {
                        $(this).text("无劳动力");
                    }
                });

                $("[data-field='can_mandarin']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });

                $("[data-field='medical_insurance']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });

                $("[data-field='basic_allowances']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });

                $("[data-field='business_insurance']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });

                $("[data-field='endowment_insurance']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });

                $("[data-field='accident_insurance']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否");
                    }
                });
            }
        });

        // 新增家庭成员
        table.on('toolbar(tableMember)', function (obj) {
            let checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    parent.layer.open({
                        title: '新增家庭成员',
                        type: 2,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['70%', '60%'], //宽高
                        content: '/memberAdd',
                        success: function (layero, index) {
                            // 兄弟窗口传值
                            var baseid = $("#baseid").val();
                            window.parent.$("#layui-layer-iframe" + index).contents().find('.fid').val(baseid);
                        },
                        end: function () {
                            layui.table.reload('tableMember', {
                                where: {
                                    fid: $("#baseid").val()
                                }
                            });
                        }
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
                layer.confirm('是否删除该记录？', function (index) {
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
            console.log($("#baseid").val());
        }
    };
})();



