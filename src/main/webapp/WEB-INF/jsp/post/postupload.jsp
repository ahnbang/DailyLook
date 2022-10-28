<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 하기</title>
<script src = "http://code.jquery.com/jquery-latest.js"></script>

 
</head>
<body>
    <h1>파일 업로드 하기</h1>
    <form method="post" action="/post/upload?">
      <div class="formGroup">
        <input type="text"  placeholder="제목" name="title" required autocomplete="off">
      </div>
      <div class="formGroup">
        <input type="text"  placeholder="내용" name="content" required autocomplete="off">
      </div>
      <div class="formGroup">
        <input type="text"  placeholder="카테고리" name="category" required autocomplete="on">
      
            <input type="submit" value="업로드">
    </form>
</body>
</html>
