var familyTabel = table.render({
    elem : '#familyListTable',
    url : '/getFamliyList',
    page : true,
    limits : [10,15,20,25],
    limit : 10,
    id : "familyListTable",
    cols : [[
        {type: "checkbox", fixed:"left", width:50},
        {field: 'userName', title: '用户名', minWidth:100, align:"center"},
        {field: 'userEmail', title: '用户邮箱', minWidth:200, align:'center'},
        {field: 'userSex', title: '用户性别', align:'center'},
        {field: 'userStatus', title: '用户状态',  align:'center'},
        {field: 'userGrade', title: '用户等级', align:'center'},
        {field: 'userEndTime', title: '最后登录时间', align:'center',minWidth:150},
        {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
    ]]
});
