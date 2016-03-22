<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>上传图片</title>
</head>
<body>
<form action="/v1/image/text" method="post" enctype="multipart/form-data">
    <input type="file" name="file" /> <input type="submit" value="Submit" /></form>
</body>
</html>
