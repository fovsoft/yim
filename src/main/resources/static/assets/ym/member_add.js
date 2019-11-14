$(document).ready(function () {
    member_add.onload();
});
let member_add = (function () {


    layui.use(['form'], function () {

        let form = layui.form;

        layui.form.render('select');

        // 提交
        form.on('submit(member)', function(data) {
            data.field.fid = $("#baseid").val();
            $.ajax({
                url: '/family/addMember22',
                method: 'post',
                data: JSON.stringify(data.field),
                contentType: "application/json",
                dataType: 'JSON',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
                },
                success: function (res) {
                    if (res.code = '0') {
                        $("#memberid").val(res.data);
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
    });

    return {
        onload: function () {

        }
    };
})();
var index;
console.log(index = parent.layer.getFrameIndex(window.name));

var iframe = window[parent.layer.find('iframe')[0]['name']]
console.log(iframe.getBaseID());

