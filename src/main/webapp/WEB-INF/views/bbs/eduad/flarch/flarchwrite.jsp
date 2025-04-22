<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
<title>board-write</title>
</head>

<body>
	<div class="flarch-write-board board">
		<div class="board-header">
			<h1>자료실 게시판</h1>
		</div>

		<!-- 폼에 파일이 포함되면 폼 태그에 enctype을 작성해줘야한다. -->
		<form:form modelAttribute="flArchWriteRequestVO"
			class="flarch-write-form" enctype="multipart/form-data">

			<div class="author-area form-group">
				<label for="author">작성자</label> <input type="text" id="author"
					name="instrId" value="${flArchWriteRequestVO.instrId}" required />
			</div>
			<div class="title-area form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="flArchTtl" value="${flArchWriteRequestVO.flArchTtl}" required />
				<form:errors path="flArchTtl" element="div" cssClass="error" />
			</div>
			<div class="file-area form-group">
				<label>첨부파일</label>
				<div class="file-container">
					<div class="file-item">
						<input type="file" id="file" name="flList" />
						<button type="button" class="btn-file-remove btn">x</button>
					</div>
				</div>
			</div>

			<div class="content-area form-group">
				<label for="content">내용</label>
				<textarea id="content" name="flArchCtt" rows="5" required>${flArchWriteRequestVO.flArchCtt}</textarea>
				<form:errors path="flArchCtt" element="div" cssClass="error" />
			</div>
			<div class="btn-area">
				<a href="/eduad/flarch/list">
				  <button type="button" class="btn-flarch-list btn">목록 보기</button>
				</a>
				<button type="submit" class="btn-flarch-submit btn">작성 완료</button>
			</div>

		</form:form>
	</div>

	<!-- 파일 아이템 추가를 위한 템플릿 생성 -->
	<template id="flarch-file-item-template">
		<div class="file-item">
			<input type="file" id="file" name="flList" />
			<button type="button" class="btn-file-remove btn">x</button>
		</div>
	</template>
</body>
</html>