<%--
  Created by IntelliJ IDEA.
  User: Vincent
  Date: 2017/5/11
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/upload/uploadModle" method="post" enctype="multipart/form-data">
        <h2>文件上传</h2>
        文件:<input type="file" name="uploadFile"/><br/><br/>
        <input type="text" name="fileName" value="HoloScan.war">
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
