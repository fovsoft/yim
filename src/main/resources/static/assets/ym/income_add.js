$(document).ready(function () {
    income_add.onload();
});

let income_add = (function () {

    layui.use(['form', 'element'], function () {
        let fid = getQueryVariable('fid');
        let element, form;
        form = layui.form;
        element = layui.element;
        // income1
        form.on('submit(income1)', function (data) {
            data.field.fid = fid;
            data = JSON.stringify(data.field);
            $.ajax({
                url: '/income/addIncome1',
                method: 'post',
                contentType: "application/json",
                data: data,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (data) {
                    layer.msg("提交成功!", function () {
                        subtotal_1();
                    });
                },
                error: function (data) {
                    layer.msg("提交失败!");
                }
            });
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        // income3
        form.on('submit(income3)', function (data) {
            data.field.fid = fid;
            data = JSON.stringify(data.field);
            $.ajax({
                url: '/income/addIncome3',
                method: 'post',
                contentType: "application/json",
                data: data,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (data) {
                    layer.msg("提交成功!", function () {
                        subtotal_2();
                    });
                },
                error: function (data) {
                    layer.msg("提交失败!");
                }
            });
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        // income5
        form.on('submit(income5)', function (data) {
            data.field.fid = fid;
            data = JSON.stringify(data.field);
            $.ajax({
                url: '/income/addIncome5',
                method: 'post',
                contentType: "application/json",
                data: data,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (data) {
                    layer.msg("提交成功!", function () {
                        subtotal_5();
                    });
                },
                error: function (data) {
                    layer.msg("提交失败!");
                }
            });
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        // income9
        form.on('submit(income9)', function (data) {
            data.field.fid = fid;
            data = JSON.stringify(data.field);
            $.ajax({
                url: '/income/addIncome9',
                method: 'post',
                contentType: "application/json",
                data: data,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (data) {
                    layer.msg("提交成功!", function () {
                        subtotal_9();
                    });
                },
                error: function (data) {
                    layer.msg("提交失败!");
                }
            });
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        // 页面加载后初始化income1
        $.ajax({
            url: "/income/getIncome1",
            data: {fid: fid},
            success: function (data) {
                form.val('income1', data.data);
                subtotal_9(); // 小计
                form.render();
            }
        });

        element.on('tab(incomeTab)', function (data) {
            if (data.index == 1) {
                // 初始化income3
                $.ajax({
                    url: "/income/getIncome3",
                    data: {fid: fid},
                    success: function (data) {
                        form.val('income3', data.data);
                        subtotal_2();
                        form.render();
                    }
                });
            }

            if (data.index == 2) {
                $.ajax({
                    url: "/income/getIncome5",
                    data: {fid: fid},
                    success: function (data) {
                        form.val('income5', data.data);
                        subtotal_5();
                        form.render();
                    }
                });
            }
            if (data.index == 3) {
                $.ajax({
                    url: "/income/getIncome9",
                    data: {fid: fid},
                    success: function (data) {
                        form.val('income9', data.data);
                        subtotal_9();
                        form.render();
                    }
                });
            }
            if (data.index == 4) {

            }
        });
    });

    // 小计函数 1
    function subtotal_1() {
        // 逐行累加，再写入
        let inputsJe11 = $("#je11").children().find("input");
        let inputsJe12 = $("#je12").children().find("input");
        let inputsJe13 = $("#je13").children().find("input");

        let xjData1 = [0, 0, 0, 0, 0, 0, 0, 0, 0];
        inputsJe11.each(function (index, e) {
            if ($(e).val())
                xjData1[index] += parseFloat($(e).val());
        });
        inputsJe12.each(function (index, e) {
            if ($(e).val())
                xjData1[index] += parseFloat($(e).val());
        });
        inputsJe13.each(function (index, e) {
            if ($(e).val())
                xjData1[index] += parseFloat($(e).val());
        });

        let xjRow1 = $("#xj1").children().find("input");
        xjRow1.each(function (index, e) {
            if (xjData1[index] != 0)
                $(e).val(xjData1[index]);
            else
                $(e).val("");
        });


        // 逐行累加，再写入
        let inputsJe121 = $("#je21").children().find("input");
        let inputsJe122 = $("#je22").children().find("input");
        let inputsJe123 = $("#je23").children().find("input");

        let xjData2 = [0, 0, 0, 0, 0, 0, 0, 0, 0];
        inputsJe121.each(function (index, e) {
            if ($(e).val())
                xjData2[index] += parseFloat($(e).val());
        });
        inputsJe122.each(function (index, e) {
            if ($(e).val())
                xjData2[index] += parseFloat($(e).val());
        });
        inputsJe123.each(function (index, e) {
            if ($(e).val())
                xjData2[index] += parseFloat($(e).val());
        });

        let xjRow2 = $("#xj2").children().find("input");
        xjRow2.each(function (index, e) {
            if (xjData2[index] != 0)
                $(e).val(xjData2[index]);
            else
                $(e).val("");
        });
    }

    // 小计函数 3
    function subtotal_2() {
        // 表3小计
        let inputsJe31 = $("#je31").children().find("input");
        let inputsJe32 = $("#je32").children().find("input");
        let inputsJe33 = $("#je33").children().find("input");
        let inputsJe34 = $("#je34").children().find("input");
        let inputsJe35 = $("#je35").children().find("input");

        let xjData3 = [0, 0, 0, 0, 0, 0, 0, 0, 0];

        // 逐行累加
        inputsJe31.each(function (index, e) {
            if (index >= 5) {
                if ($(e).val())
                    xjData3[index - 5] += parseFloat($(e).val());
            }
        });
        inputsJe32.each(function (index, e) {
            if (index >= 5) {
                if ($(e).val())
                    xjData3[index - 5] += parseFloat($(e).val());
            }
        });
        inputsJe33.each(function (index, e) {
            if (index >= 5) {
                if ($(e).val())
                    xjData3[index - 5] += parseFloat($(e).val());
            }
        });
        inputsJe34.each(function (index, e) {
            if (index >= 5) {
                if ($(e).val())
                    xjData3[index - 5] += parseFloat($(e).val());
            }
        });
        inputsJe35.each(function (index, e) {
            if ($(e).val())
                xjData3[index] += parseFloat($(e).val());
        });

        let xjRow3 = $("#xj3").children().find("input");
        xjRow3.each(function (index, e) {
            if (xjData3[index] != 0)
                $(e).val(xjData3[index]);
            else
                $(e).val("");
        });


        // 表4小计
        let inputsJe41 = $("#je41").children().find("input");
        let inputsJe42 = $("#je42").children().find("input");
        let xjData4 = [0, 0, 0, 0, 0, 0, 0, 0, 0];
        inputsJe41.each(function (index, e) {
            if ($(e).val())
                xjData4[index] += parseFloat($(e).val());
        });
        inputsJe42.each(function (index, e) {
            if ($(e).val())
                xjData4[index] += parseFloat($(e).val());
        });

        let xjRow4 = $("#xj4").children().find("input");
        xjRow4.each(function (index, e) {
            if (xjData4[index] != 0)
                $(e).val(xjData4[index]);
            else
                $(e).val("");
        });
    }

    // 小计函数 5
    function subtotal_5() {
        // 表5小计

    }

    // 小计函数 9
    function subtotal_9() {
        // 表9小计

    }

    // 获取请求参数
    function getQueryVariable(variable) {
        let query = window.location.search.substring(1);
        let vars = query.split("&");
        for (let i = 0; i < vars.length; i++) {
            let pair = vars[i].split("=");
            if (pair[0] == variable) {
                return pair[1];
            }
        }
        return (false);
    }

    return {
        onload: function () {
        }
    };
})();