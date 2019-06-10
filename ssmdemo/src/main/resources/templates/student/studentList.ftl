<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="/jquery-easyui-1.5.2/jquery.min.js" type="text/javascript"></script>
<link href="/jquery-easyui-1.5.2/themes/default/easyui.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/themes/icon.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/demo/demo.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/othercss/css/easyuistyle02.css" rel="stylesheet" type="text/css">
<script src="/jquery-easyui-1.5.2/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/extends/datagridTooltip.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/datagrid-detailview.js" type="text/javascript"></script>
<body class="easyui-layout">
<div data-options="region:'north',split:false,collapsible:false" style="height:40px;">

</div>

<div class="easyui-panel" data-options="region:'center'" style="overflow:hidden;">
    <div id="tb" style="padding:5px;height:auto">
        <div style="padding: 5px;border-bottom: 1px solid #E0ECFF;">
            <label class="seclet-lable">学生名称：</label>
            <input class="easyui-textbox" id="studentName" name="studentName" style="width:140px;" />
            <span style="margin-left: 20px">
                	<a class="easyui-linkbutton buttonBlue" href="#" iconcls="icon-search" id="btn_paramQuery" onclick="doSearch()">查询</a>
                	<a class="easyui-linkbutton buttonWhite" href="#" iconcls="icon-clear" id="btn_paramQueryReset" onclick="paramReset()">清空</a>
               </span>
        </div>
        <div style="padding: 8px;">
            <a class="easyui-linkbutton buttonBlue" href="#" onclick="editInfo()" toggle="true">编辑</a>
            <a class="easyui-linkbutton buttonBlue" href="#" onclick="insertInfo()" toggle="true">添加</a>
            <a class="easyui-linkbutton buttonRed" href="#"  onclick="deleteInfo()" toggle="true">删除</a>
        </div>
    </div>
    <table id="initGrid"></table>
</div>
<div id="update_dlg"  style="width: 800px;height: 440px;display:none;" title="修改">
    <div class="easyui-layout" style="width: 100%; height: 100%;">
        <div data-options="region:'center',border:false" style="height: 87%;">
            <form action="" id="form2" style="margin-left:30px;font-size:12px;">
                <table align="center" style="border-collapse:separate; border-spacing:30px 40px;">
                    <tr style="display: none">
                        <td><input class="easyui-textbox" id="id" name="id"  style="width:200px;" type="text" value="" /></td>
                    </tr>
                    <tr class="str">
                        <td>学生名称：<span style="color: red;float:right;margin-right: 8px; font-size: 16px;"></span></td>
                        <td><input class="easyui-textbox" id="name" name="name" required="required" style="width:200px;" type="text" value="" /></td>
                        <td>学生性别：<span style="color: red;float:right;margin-right: 8px; font-size: 16px;"></span></td>
                        <td><input class="easyui-textbox" id="sex" name="sex" required="required" style="width:200px;" type="text" value="" /></td>
                    </tr>
                    <tr>
                        <td>出生年月：<span style="color: red;float:right;margin-right: 8px; font-size: 16px;"></span></td>
                        <td><input class="easyui-datebox" id="birth" name="birth" required="required" style="width:200px;"/></td>
                        <td>手机号：<span style="color: red;float:right;margin-right: 8px; font-size: 16px;"></span></td>
                        <td><input class="easyui-textbox" id="phone" name="phone" required="required" style="width:200px;" type="text" value="" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="dialog_style" data-options="region:'south',border:false" style="width: 100%; height: 13%">
            <span class="easyui-linkbutton c6" iconCls="icon-ok" onclick="insertOrUpdate()" style="width:80px">保存</span>
            <span class="easyui-linkbutton easyui-linkbutton1" iconCls="icon-cancel" onclick="updateClosedlg()" style="width:80px">取消</span>
        </div>
    </div>
</div>
</body>
<script>
    //参数表格对象
    var grid;
    //初始化加载
    $(function() {
        initGrid();
    });
    function initGrid() {
        grid = $('#initGrid').datagrid({
            url: "/student/List",
            fit: true,
            toolbar: '#tb',
            border: false,
            queryParams: {
                name: $("#studentName").textbox('getValue')
            },
            method: 'post',
            rownumbers: true,
            fitColumns: true,
            singleSelect: true,
            pagination: true,
            pageSize: 15,
            pageList:[15],
            columns: [
                [
                    {field: 'ck', checkbox: true },
                    {title: '学生编号',field: 'id',width: '80px',align: 'center',hidden: true},
                    {title: '学生姓名',field: 'name',width: '80px',align: 'center',hidden: false},
                    {title: '学生性别',field: 'sex',width: '80px',align: 'center',hidden: false},
                    {title: '学生生日',field: 'birth',width: '80px',align: 'center',hidden: false},
                    {title: '学生电话',field: 'phone',width: '80px',align: 'center',hidden: false},
                ]
            ],

            loadFilter: function(r) {
                var info={};
                info.rows=r.data;
                info.total=r.total;
                return info; //过滤数据，变成easyui表格默认的格式
            }
        }).datagrid('doCellTip', { cls: { 'max-width': '500px' } });
    }

</script>
<script>
    function editInfo(){
        var rows = $("#initGrid").datagrid("getSelections");
        if(rows.length == 0){
            //没有选中记录，弹出提示
            $.messager.alert("提示信息","请选择需要编辑的信息！","warning");
        }else{
            $("#update_dlg").dialog({modal:true});
            //表单值回填
            $('#form2').form('load',{
                name :rows[0].name,
                sex :rows[0].sex,
                phone :rows[0].phone,
                birth :rows[0].birth,
                id: rows[0].id,
            });
        }
    }
    //编辑中点击保存
    function insertOrUpdate(id){
        var rows = $("#initGrid").datagrid("getSelections");
        //验证表单，如果有信息未填完整，则进行提示
        var validate = $("#form2").form("validate");
        if(!validate){
            $.messager.alert("消息提醒","数据未填完整，请重新核对!","warning");
            return;
        }
        var urls="addOrUpdate";
        //表单提交
        $.ajax({
            type:"post",
            url: urls,
            data: {
                id: $('#id').textbox('getValue'),
                name: $('#name').textbox('getValue'),
                sex: $('#sex').textbox('getValue'),
                birth: $('#birth').textbox('getValue'),
                phone: $('#phone').textbox('getValue')
            },
            dataType: "json",
            success: function(r){
                console.log(r);
                if(r.data.count==1){
                    //刷新当前页
                    refreshLine('#initGrid',rows[0].id);
                    //关闭弹框
                    $('#update_dlg').window('close')
                }else{
                    $.messager.alert("提示信息","该信息已被其他用户删除，修改失败！","warning");
                    //刷新当前页
                    refreshLine('#initGrid',rows[0].id);
                    //关闭弹框
                    $('#update_dlg').window('close')
                }
            },
            error: function( ) {
                $.messager.alert("提示信息","网络异常请稍后重试！","warning");
            }
        });
    }
    //联系人电话验证
    function checkPhone(phoneNum){
        var pattern = /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^0{0,1}13[0-9]{9}$)|(^1(3|4|5|7|8)\d{9}$)/;
        return pattern.test(phoneNum);
    }
</script>
<script>
function insertInfo(){
    $("#update_dlg").dialog({modal:true});
}
function deleteInfo(){
    var rows = $("#initGrid").datagrid("getSelections");
    if(rows.length == 0){
        //没有选中记录，弹出提示
        $.messager.alert("提示信息","请选择需要删除的信息！","warning");
    }else{
        $.ajax({
            type:"post",
            url:"delete",
            data: {
                id: rows[0].id
            },
            dataType: "json",
            success: function(r){
                console.log(r);
                if(r.data.count==1){
                }else{
                    $.messager.alert("提示信息","删除失败！","warning");
                }
                refreshLine('#initGrid',rows[0].id);
                //关闭弹框
                $('#update_dlg').window('close')
            },
            error: function( ) {
                $.messager.alert("提示信息","网络异常请稍后重试！","warning");
            }
        });
    }
}
function  updateClosedlg() {
    $("#form2").form("clear");
    $('#update_dlg').window('close');

}
function doSearch() {
    initGrid();
}
function paramReset() {
    $('#studentName').textbox("setValue",'');
    initGrid();
}
</script>
</html>