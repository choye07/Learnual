<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/common.css" type="text/css" />
    <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
    <script src="/js/common.js" type="text/javascript"></script>
    <title>게시판</title>
  </head>
  <body>
    <div class="custom-board board-write">
      <form>
        <div class="author-area form-group">
          <label for="author">작성자</label>
          <input type="text" id="author" name="author" required />
        </div>
        <div class="title-area form-group">
          <label for="title">제목</label>
          <input type="text" id="title" name="title" required />
        </div>
        <div class="content-area form-group">
          <label for="content">내용</label>
          <textarea id="content" name="content" rows="5" required></textarea>
        </div>
        <div class="btn-area">
          <button type="button" class="btn-list btn">목록 보기</button>
          <button type="submit" class="btn-submit btn">작성 완료</button>
        </div>
      </form>
    </div>
  </body>
</html>
