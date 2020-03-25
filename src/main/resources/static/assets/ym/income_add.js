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
                subtotal_1(); // 小计
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
                        form.val('income5', data.data.jeMap);
                        subtotal_5();
                        form.render();

                        let jtwdzsr2018 = data.data.jtwdzsr.jtwdzsr2018;
                        let jtwdzsr2019 = data.data.jtwdzsr.jtwdzsr2019;

                        let jtwdzzc2018 = data.data.jtwdzsr.jtwdzzc2018;
                        let jtwdzzc2019 = data.data.jtwdzsr.jtwdzzc2019;

                        let num = data.data.jtwdzsr.num; // 家庭成员数

                        // 填总收入
                        $("#jtwdzsr2018").val(jtwdzsr2018.toFixed(2));
                        $("#jtwdzsr2019").val(jtwdzsr2019.toFixed(2));
                        // 填纯收入
                        $("#jtwdcsr2018").val((jtwdzsr2018 - jtwdzzc2018).toFixed(2));
                        $("#jtwdcsr2019").val((jtwdzsr2019 - jtwdzzc2019).toFixed(2));
                        // 填人均纯收入
                        if(num) {
                            $("#rjcsr2018").val(((jtwdzsr2018 - jtwdzzc2018) / num).toFixed(2));
                            $("#rjcsr2019").val(((jtwdzsr2019 - jtwdzzc2019) / num).toFixed(2));
                        }
                        else {
                            $("#rjcsr2018").val("无家庭成员信息");
                            $("#rjcsr2019").val("无家庭成员信息");
                        }
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
        let jeqt11 = $("#jeqt11").children().find("input");
        let jeqt12 = $("#jeqt12").children().find("input");

        let xjData1 = [];
        for(let i = 0; i < inputsJe11.length; i++) {
            xjData1[i] = 0;
        }
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
        jeqt11.each(function (index, e) {
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

        let xjData2 = [];
        for(let i = 0; i < inputsJe121.length; i++) {
            xjData2[i] = 0;
        }

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
        jeqt12.each(function (index, e) {
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


        let xjData3 = [];
        for(let i = 0; i < inputsJe31.length; i++) {
            xjData3[i] = 0;
        }

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

        let xjData4 = [];
        for(let i = 0; i < inputsJe41.length; i++) {
            xjData4[i] = 0;
        }
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
        let jhsyj = $("#jhsyj").children().find("input");
        let dbjA = $("#dbjA").children().find("input");
        let dbjB = $("#dbjB").children().find("input");
        let dbjC = $("#dbjC").children().find("input");
        let tkgyj = $("#tkgyj").children().find("input");
        let stbcj = $("#stbcj").children().find("input");

        let shbz = $("#shbz").children().find("input");
        let nybt = $("#nybt").children().find("input");
        let glbt = $("#glbt").children().find("input");
        let skymbt = $("#skymbt").children().find("input");
        let qtcqxbt = $("#qtcqxbt").children().find("input");

        let xjData6_10 = []; // 6-10小计, 1-10小计再累加前四行
        for(let i = 0; i < jhsyj.length; i++) {
            xjData6_10[i] = 0;
        }

        // 6-10逐行累加
        shbz.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        nybt.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        glbt.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        skymbt.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        qtcqxbt.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });

        let xjRow5 = $("#xj5").children().find("input");    console.log(xjRow5.length);
        xjRow5.each(function (index, e) {
            if (xjData6_10[index] != 0)
                $(e).val(xjData6_10[index]);
            else
                $(e).val("");
        });

        // 累加前四行作为1-10
        jhsyj.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        dbjA.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        dbjB.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        dbjC.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        tkgyj.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });
        stbcj.each(function (index, e) {
            if ($(e).val())
                xjData6_10[index] += parseFloat($(e).val());
        });

        let xjRow6 = $("#xj6").children().find("input");
        xjRow6.each(function (index, e) {
            if (xjData6_10[index] != 0)
                $(e).val(xjData6_10[index]);
            else
                $(e).val("");
        });
    }

    // 小计函数 9
    function subtotal_9() {  console.log(111);
        // 表9小计
        let jybzl = $("#jybzl").children().find("input");
        let ylbzl = $("#ylbzl").children().find("input");
        let zfbzl = $("#zfbzl").children().find("input");
        let cyjbl = $("#cyjbl").children().find("input");
        let jrl = $("#jrl").children().find("input");
        let shbzl = $("#shbzl").children().find("input");
        let bxpfj = $("#bxpfj").children().find("input");
        let cjrbt = $("#cjrbt").children().find("input");
        let jzjd = $("#jzjd").children().find("input");
        let dqfxjd = $("#dqfxjd").children().find("input");
        let qtdqxbz = $("#qtdqxbz").children().find("input");

        let xjData9 = []; // 6-10小计, 1-10小计再累加前四行
        for(let i = 0; i < jybzl.length; i++) {
            xjData9[i] = 0;
        }
        jybzl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        ylbzl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        zfbzl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        cyjbl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        jrl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        shbzl.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        bxpfj.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        cjrbt.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        jzjd.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        dqfxjd.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        qtdqxbz.each(function (index, e) {
            if ($(e).val())
                xjData9[index] += parseFloat($(e).val());
        });
        let xjRow9 = $("#xj10").children().find("input");
        xjRow9.each(function (index, e) {
            if (xjData9[index] != 0)
                $(e).val(xjData9[index]);
            else
                $(e).val("");
        });
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