$(document).ready(function () {
    income.onload();
});

let income = (function () {

    layui.use('table', function () {
        var table = layui.table;
        var familyTabel = table.render({
            elem: '#familyListTable',
            url: '/family/getList',
            page: true,
            toolbar: '#toolbarDemo',
            limits: [10, 15, 20, 25],
            limit: 10,
            even: true,
            title: '贫困户家庭基本情况',
            cols: [[
                {type: 'checkbox'}
                , {field: 'id', title: 'ID', width: 80, unresize: true, sort: true}
                , {field: 'zjhm', title: '证件号码'}
                , {field: 'hzxm', title: '户主姓名', width: 120}
                , {field: 'pkhsx', title: '贫困户属性'}
                , {field: 'jhtpnd', title: '计划脱贫年度'}
                , {field: 'fpnd', title: '返贫年度',}
                , {field: 'sfydbqh', title: '是否易地搬迁户'}
                , {title: '操作', toolbar: '#barDemo', fixed: 'right', width: 160}
            ]],
            done: function (res, curr, count) {
                $("[data-field='pkhsx']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("一般贫困户")
                    } else if ($(this).text() == 2) {
                        $(this).text("低保贫困户")
                    } else if ($(this).text() == 3) {
                        $(this).text("特困供养贫困户");
                    }
                });
                $("[data-field='sfydbqh']").children().each(function () {
                    if ($(this).text() == 1) {
                        $(this).text("是")
                    } else if ($(this).text() == 0) {
                        $(this).text("否")
                    }
                });
            },
            skin: 'row'
        });

        //监听工具条
        table.on('tool(userList)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('是否删除该记录？', function (index) {
                    $.ajax({
                        url: '/family/del',
                        method: 'get',
                        data: {id: data.id},
                        contentType: "application/json",
                        success: function (data) {
                            obj.del();
                            layer.close(index);
                        },
                        error: function (data) {
                            layer.msg("删除失败!");
                        }
                    });
                });
            } else if (obj.event === 'edit') {
               window.location.href = "/income_add?fid=" + obj.data.id;
            }
        });
    });

    return {
        onload: function () {

        }
    };
})();