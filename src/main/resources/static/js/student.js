$(function () {
    // formValidator();
    $(".showMsg").hide();
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    // /*d导出弹框*/
    $("#user-export").click(function () {
        var idArray = [];
        var opts = $('#tb_body').bootstrapTable('getSelections');
        if (opts == "") {
            bootbox.alert({
                title: "操作提示",
                message: "请至少勾选一个员工再进行操作",
            });
            return;
        }
        else {
            for (var i = 0; i < opts.length; i++) {
                if (!opts[i].id == "") {
                    idArray.push(opts[i].id);
                } else {
                    bootbox.alert({
                        title: "操作提示",
                        message: "请至少勾选一个员工再进行操作",
                    });

                }
            }
            for (var i = 0; i < idArray.length; i++) {
                //alert(idArray[i])
            }
            alert(idArray)
          window.location.href = "/ReportForm/export?ids[]=" + idArray;
         //    $.ajax({
         //        url: "/ReportForm/export?ids[]="+idArray,
         //        type: "get",
         //        contentType: "application/json",
         //        success: function (result) {
         //
         //        }
         //    });

        }
    })
    /*新增弹窗*/
    $("#user-add").click(function () {
        $("#modal-container-edit").modal("show");
        $(".userForm").get(0).reset();
        $("#modal-container-edit .modal-title").empty();
    })

    /*修改性别弹窗(批量修改)*/
    $("#updateSex").click(function () {
        $("#personModa3").modal("show");
    })

    /*点击确定(批量修改)*/
    $("#update1").click(function () {
        var opts = $('#tb_body').bootstrapTable('getSelections');
        var idArray = [];
        for (var i = 0; i < opts.length; i++) {
                idArray.push(opts[i].id);
            }
            var sex=$("#radio1 input[type='radio']:checked").val();
       alert(sex);
       // var ids   =JSON.stringify({
       //      ids:idArray
       //  })
        alert(idArray);
        $.ajax({
            url: "/student/updateSex?ids[]="+idArray+"&sex="+sex,
            type: "get",
            contentType: "application/json",
            success: function (result) {
                $("#personModa3").modal("hide");

            }
        });

        })




    /*修改弹窗*/
    $("#user-edit").click(function () {
        $(".userForm").get(0).reset();
        var opts = $('#tb_body').bootstrapTable('getSelections');
        if (opts == "" || opts.length > 1) {
            $("#modal-container-edit").modal("hide");
            bootbox.alert({
                title: "操作提示",
                message: "请勾选一个员工再进行编辑",
            });
            return;
        } else {
            $("#modal-container-edit").modal("show");
            $(".userForm input[ name='id' ] ").val(opts[0].id);
            $(".userForm input[ name='name' ] ").val(opts[0].name);
            $(".userForm input[ name='age' ] ").val(opts[0].age);
            $(".userForm input[ name='school' ] ").val(opts[0].school);
            $(".userForm input[ name='count' ] ").val(opts[0].count);
            //设置下拉框的值(直接获取下拉框的值，不能加上option:selected)
            var select = $(".userForm select[ name='grade' ]").val(opts[0].grade);
            //   alert(select);
            //获取单选框的值
            var sex = opts[0].sex;
            //  alert(sex);
            if (sex == "男") {
                $(".userForm input[ name='sex' ][value=男] ").attr("checked", true);
                $(".userForm input[ name='sex' ][value=女] ").attr("checked", false);
            } else {
                $(".userForm input[ name='sex' ][value=女] ").attr("checked", true);
                $(".userForm input[ name='sex' ][value=男] ").attr("checked", false);
            }


        }

    })


    /**
     * 新增or修改的提交
     */
    $("#button2019").click(function () {
        var data = $(".userForm").serialize();
        var DataDeal = {
            //将从form中通过$('#form').serialize()获取的值转成json
            formToJson: function (data) {
                data = data.replace(/&/g, "\",\"");
                data = data.replace(/=/g, "\":\"");
                data = "{\"" + data + "\"}";
                return data;
            },
        };
        data = decodeURIComponent(data, true);//防止中文乱码
        var json = DataDeal.formToJson(data);//转化为json

        var id = $(".userForm input[ name='id' ] ").val();//获取id
        if (!id == "") {
            $.ajax({
                url: "/student/update",
                type: "post",
                data: json,
                contentType: "application/json",
                success: function (result) {

                }
            });
            $("#modal-container-edit").modal("hide");
            $("#tb_body").bootstrapTable('refresh');
        } else {
            $.ajax({
                url: "/student/add",
                type: "post",
                data: json,
                contentType: "application/json",
                success: function (result) {

                }
            });
            $("#modal-container-edit").modal("hide");
            $("#tb_body").bootstrapTable('refresh');
        }


    });


    /*删除,重置,冻结弹窗*/
    // $(".showModel").click(function () {
    //     var opts = $('#tb_body').bootstrapTable('getSelections');
    //     if (opts == "") {
    //         $("#modal-container-edit").modal("hide");
    //         bootbox.alert({
    //             title: "操作提示",
    //             message: "请至少勾选一个员工再进行操作",
    //         });
    //         return;
    //     }
    //     else{
    //         $("#modal-container-sdc").modal("show");
    //     }
    // })
    /*员工启用/冻结*/
    // $(".status").click(function () {
    //     var opts = $('#tb_body').bootstrapTable('getSelections');
    //     $('.btn-sdc').unbind('click');
    //     $("#modal-container-sdc .modal-title,#modal-container-sdc .modal-body,#modal-container-sdc .btn-sdc").empty();
    //     var state = opts[0].state;
    //     if(state==false){
    //         $("#modal-container-sdc .btn-sdc").append("启用");
    //         $("#modal-container-sdc .modal-title").append("启用员工");
    //         $("#modal-container-sdc .modal-body").append("是否确认启用?启用后,对应用户可正常登录后台及APP");
    //         state = true;
    //     }else{
    //         $("#modal-container-sdc .btn-sdc").append("冻结");
    //         $("#modal-container-sdc .modal-title").append("冻结员工");
    //         $("#modal-container-sdc .modal-body").append("是否确认冻结?冻结后,对应用户无法登录后台及APP");
    //         state = false;
    //     }
    //     var arr = [];
    //     for (var i = 0; i < opts.length; i++) {
    //         arr.push(opts[i].workId);
    //     }
    //     $(".btn-sdc").click(function (){
    //         $.post("/user/setState", {arr: arr,state:state}, function (result) {
    //             $("#tb_body").bootstrapTable('refresh');
    //             showMsg(result.msg);
    //         });
    //     });
    // });
    /*删除员工*/
    // $(".delete").click(function () {
    //     //     var opts = $('#tb_body').bootstrapTable('getSelections');
    //     //     $('.btn-sdc').unbind('click');
    //     //     $("#modal-container-sdc .modal-title,#modal-container-sdc .modal-body,#modal-container-sdc .btn-sdc").empty();
    //     //     $("#modal-container-sdc .btn-sdc").append("删除");
    //     //     $("#modal-container-sdc .modal-title").append("删除员工");
    //     //     $("#modal-container-sdc .modal-body").append("是否删除员工?删除员工是:");
    //     //     var arr = [];
    //     //     for (var i = 0; i < opts.length; i++) {
    //     //         arr.push(opts[i].workId);
    //     //         $("#modal-container-sdc .modal-body").append(opts[i].userName);
    //     //         (i < opts.length-1) ? $("#modal-container-sdc .modal-body").append("，") : "";
    //     //     }
    //     //     $(".btn-sdc").click(function (){
    //     //         prompt("是否确认删除,删除后不可恢复","/user/delete",{arr: arr});
    //     //     });
    //     // });
    /*重置密码*/
    // $(".reset").click(function () {
    //     var opts = $('#tb_body').bootstrapTable('getSelections');
    //     $('.btn-sdc').unbind('click');
    //     $("#modal-container-sdc .modal-title,#modal-container-sdc .modal-body,#modal-container-sdc .btn-sdc").empty();
    //     $("#modal-container-sdc .btn-sdc").append("重置");
    //     $("#modal-container-sdc .modal-title").append("重置员工密码");
    //     $("#modal-container-sdc .modal-body").append("是否确认重置员工密码?重置密码为:123456");
    //     var arr = [];
    //     for (var i = 0; i < opts.length; i++) {
    //         arr.push(opts[i].workId);
    //     }
    //     $(".btn-sdc").click(function (){
    //         $.post("/user/resetPassword", {arr: arr}, function (result) {
    //             $("#tb_body").bootstrapTable('refresh');
    //             showMsg(result.msg);
    //         });
    //     });
    // });
    $(".search-btn").click(function () {

        var i = $("#selectQuery").val();
        alert(i);
        $("#tb_body").bootstrapTable('refresh');

    });
});
TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_body').bootstrapTable({
            url: '/student/getUserList',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '序号',
                align: 'center',
                events: operateEvents2,
                formatter: function (value, row, index) {
                    return "<a class='showUserWindow2'>" + value + "</a>";
                }
            },
                {
                    field: 'name',
                    title: '姓名',
                    align: 'center'
                }, {
                    field: 'school',
                    title: '学校',
                    align: 'center',

                }, {
                    field: 'sex',
                    title: '性别',
                    align: 'center',
                    events: operateEvents3,
                    formatter: function (value, row, index) {
                        return "<a class='showUserWindow3'>" + value + "</a>";
                    }

                }, {
                    field: 'age',
                    title: '年龄',
                    align: 'center'
                }, {
                    field: 'grade',
                    title: '年级',
                    align: 'center',
                }, {
                    field: 'count',
                    title: '统计',
                    align: 'center',
                    events: operateEvents,
                    formatter: function (value, row, index) {
                        return "<a class='showUserWindow'>" + value + "</a>";
                    }
                }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params, val) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,
            name: $(".search input[ name='name']").val(),
            school: $(".search input[ name='school2019']").val(),
            grade: $("#selectQuery").val()
        };
        return temp;
    };
    return oTableInit;
};
//新增用户提交验证  验证用户名和工号
// function formValidator(){
//     $(".userForm").bootstrapValidator({
//         excluded: [':disabled', ':hidden', ':not(:visible)'],
//         feedbackIcons: {
//             valid: 'glyphicon glyphicon-ok',
//             validating: 'glyphicon glyphicon-refresh'
//         },
//         fields: {
//             workId: {
//                 validators: {
//                     notEmpty: {
//                         message: '员工工号不能为空'
//                     },
//                     stringLength: {
//                         min: 1,
//                         max: 10,
//                         message: '输入长度为10以内个的字符'
//                     },
//                     threshold :  1 ,
//                     remote: {
//                         url: '/user/validateWorkId',
//                         message: '工号已存在',
//                         delay :  0,
//                         type: 'POST',
//                         data: function(validator) {
//                             return {
//                                 id: $(".userForm input[ name='id' ]").val(),
//                                 workId: $(".userForm input[ name='workId']").val(),
//                             };
//                         }
//                     },
//                 }
//             },
//             username: {
//                 validators: {
//                     notEmpty: {
//                         message: '员工姓名不能为空'
//                     },
//                     stringLength: {
//                         min: 1,
//                         max: 10,
//                         message: '输入长度为10以内个的字符'
//                     },
//                 }
//             }
//         }
//     });
// };
// prompt=function(msg,url,data){
//     bootbox.confirm({
//         message: msg,
//         buttons: {
//             confirm:{
//                 label:"确认",
//                 className: "btn-success btn-alt"
//             },
//             cancel:{
//                 label:"取消",
//                 className: "btn-default btn-alt"
//             }
//         },callback: function (result) {
//             if(result){
//                 $.post(url, data, function (result) {
//                     $("#tb_body").bootstrapTable('refresh');
//                     showMsg(result.msg);
//                 });
//             }
//         }
//     });
// }
showMsg = function (msg) {
    $(".showMsg .msgtxt").empty();
    $(".showMsg .msgtxt").append(msg);
    $(".showMsg").show();
    setTimeout(function () {
        $('.showMsg').hide();
    }, 3000)
};

window.operateEvents = {
    "click .showUserWindow": function (e, value, row, index) {

        var name = $(".search input[ name='name']").val();
        alert(value);

        if (value == 0) {
            return;
        }
        $("#personModal").modal("show");
        loadUser();
    }
}

window.operateEvents2 = {
    "click .showUserWindow2": function (e, value, row, index) {
        var id0=row.id;
        // var opts = $('#tb_body').bootstrapTable('getSelections');
        // var id = opts[0].id;
        window.location.href = "../views/StudentDetails.html?" + id0;
    }
}


window.operateEvents3 = {
    "click .showUserWindow3": function (e, value, row, index) {
        alert("123");
        var opts = $('#tb_body').bootstrapTable('getSelections');
        var id = opts[0].id;
        console.log(id);
        alert(id);
        $("#personModal2").modal("show");
        loadUser2();
    }
}


//弹窗过后的分页
function loadUser() {
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#tb_user').bootstrapTable({
                url: '/student/getUserListForPop',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //设置为 true 会在表格底部显示分页条。
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,
                columns: [{
                    field: 'name',
                    title: '姓名',
                    align: 'center'
                }, {
                    field: 'school',
                    title: '学校',
                    align: 'center'
                }]
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {

        };

        function queryParams() {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                name: $(".search input[ name='name']").val(),
                school: $(".search input[ name='school']").val()

            }
            return temp;
        }

        return oTableInit;
    };
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
}


//弹窗分页（展示书籍的名字，id）
function loadUser2() {
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#tb_user2').bootstrapTable({
                url: '/book/getBookPop',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //设置为 true 会在表格底部显示分页条。
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,
                columns: [{
                    field: 'id',
                    title: '书籍对应学生id',
                    align: 'center'
                }, {
                    field: 'bookName',
                    title: '书名',
                    align: 'center'
                }]
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {

        };

        function queryParams() {
            var opts = $('#tb_body').bootstrapTable('getSelections');
            var id = opts[0].id;
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                id:id
            }
            return temp;
        }

        return oTableInit;
    };
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
}