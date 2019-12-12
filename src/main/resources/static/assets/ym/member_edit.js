$(document).ready(function () {
    member_edit.onload();
});
let member_edit = (function () {

    layui.use(['form'], function () {

        let form = layui.form;

        layui.form.render('select');

        // 提交
        form.on('submit(member)', function (data) {
            data.field.fid = $("#fid").val();
            $.ajax({
                url: '/family/addMember',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        layer.msg("✔ 保存成功!", {shift: -1, time: 2000}, function () {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                    }
                    else {
                        layer.msg("× 保存失败");
                    }
                },
                error: function (data) {

                }
            });
        });

        $.ajax({
            url: "/family/getMember",
            method: 'get',
            data: {id: $("#memberid").val()},
            contentType: "application/json",
            success: function (res) {
                // 初始化表单
                console.log(res.data);

                form.val('member11', {
                    'memberid': res.data.memberid,
                    'fid': res.data.fid,
                    'sex': res.data.sex,
                    'relation': res.data.relation,
                    'nation': res.data.nation,
                    'tel': res.data.tel,
                    'member_name': res.data.member_name,
                    'id_num': res.data.id_num,
                    'political_exp': res.data.political_exp,
                    'level_edu': res.data.level_edu,
                    'school_status': res.data.school_status,
                    'stopedu_rsn': res.data.stopedu_rsn,
                    'healthy_status': res.data.healthy_status,
                    'labor_skill': res.data.labor_skill,
                    'can_mandarin': res.data.can_mandarin,
                    'medical_insurance': res.data.medical_insurance,
                    'business_insurance': res.data.business_insurance,
                    'basic_allowances': res.data.basic_allowances,
                    'endowment_insurance': res.data.endowment_insurance,
                    'accident_insurance': res.data.accident_insurance
                });
                form.render();
            },
        });
    });


    return {
        onload: function () {
        }
    };
})();

