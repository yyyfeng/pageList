<%--
  Created by IntelliJ IDEA.
  User: yingfeng
  Date: 2019/8/14
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="form1" name="form1" method="post" action="/upload" enctype="multipart/form-data">
        <table border="0" align="center">
            <tr>
            </tr>
            <tr>
                <td>上传文件：</td>
                <td><input name="file " type="file" size="20" ></td>
            </tr>
            <tr>
                <td></td><td>
                <input type="submit" name="submit" value="提交" >
                <input type="reset" name="reset" value="重置" >
                

            </td>
            </tr>
        </table>
    </form>
</body>
</html>
