<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<!--
   상대경로 사용, [현재 URL 이 속한 계층 경로 + /save]
   "/servlet-mvc/members/new-form -> /servlet-mvc/members/save"
   만일 "/save" 면 절대경로이다.
 -->
<form action="save" method="post">
  username: <input type="text" name="username" />
  age: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>
</body>
</html>