<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>入力画面</title>
</head>
<body>
<h1>入力画面</h1>
<form action="/servlet-sample/hello" method="get">
    <label for="name">名前:</label>
    <input type="text" id="name" name="name">
    <input type="submit" value="送信">
</form>
</body>
</html>