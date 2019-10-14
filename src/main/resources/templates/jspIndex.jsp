<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
    <link href="/easyui/themes/icon.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg" class="easyui-datagrid" data-options="singleSelect:true ,pagination:true,url:'jspIndex'" width="1000px"
            toolbar="#tb" title="错误学生信息展示列表";>
        <thead>
        <tr>
            <th data-options="field:'code'">Code</th>
            <th data-options="field:'name'">Name</th>
            <th data-options="field:'price'">Price</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="users">
            <tr>
                <td>${users.name }</td>
                <td>${users.age }</td>
                <td>${users.sex }</td>
            </tr>
        </c:forEach>
        </tbody>
</table>

<div id="tb">
    <form action="jspIndex">
        <div>
            <input type="text"  id="name" name="name" data-options="prompt:'请输入...'" style="width:300px" />
            <button type="submit">搜索</button>

        </div>
    </form>
    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:alert('Add')">Add</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:alert('Cut')">Cut</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:alert('Save')">Save</a>
    </div>
</div>
<div id="add" class="easyui-window" title="添加用户"
     style="overflow: hidden; width: 500px; height: 500px ;margin-left: auto;margin-top: auto;"
     data-options="closed:true,iconCls:'icon-save',modal:true">
    <iframe width="100%" style="border: 0px;"
            height="100%"></iframe>
</div>
<div id="edit" class="easyui-window" title="修改用户"
     style="overflow: hidden; width: 500px; height: 500px; margin-left: auto; margin-top: auto;"
     data-options="closed:true,iconCls:'icon-save',modal:true">
    <iframe id="editUser" width="100%" style="border: 0px;"
            height="100%"></iframe>
</div>
<script type="text/javascript">
    $('#dg').datagrid({ loadFilter: pagerFilter }).datagrid({
        url: '/jspIndex'     //加载数据
    });

    // 分页数据的操作
    function pagerFilter(data) {
        if (typeof data.length == 'number' && typeof data.splice == 'function') {   // is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage: function (pageNum, pageSize) {
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                pager.pagination('refresh', {
                    pageNumber: pageNum,
                    pageSize: pageSize
                });
                dg.datagrid('loadData', data);
            }
        });
        if (!data.originalRows) {
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }

</script>
</body>