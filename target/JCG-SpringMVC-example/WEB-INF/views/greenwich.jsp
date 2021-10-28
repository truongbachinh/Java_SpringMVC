<%--
  Created by IntelliJ IDEA.
  User: lottehpt
  Date: 10/25/2021
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${company.name}</h1>
    <img src="${company.image}" alt="anh">
    <p>${company.address}</p>
    <form action="uploader/upload.htm" method="post" enctype="multipart/form-data">
        <div>File</div>
        <input type="file" name="image">
        <button>Upload</button>
    </form>
</body>
</html>
