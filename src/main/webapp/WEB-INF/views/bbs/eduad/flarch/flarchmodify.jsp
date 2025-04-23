<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
<title>board-modify</title>
</head>

<body>
	<div class="flarch-modify-board board">
		<div class="board-header">
			<h1>자료실 게시판</h1>
		</div>

		<!-- 폼에 파일이 포함되면 폼 태그에 enctype을 작성해줘야한다. -->
		<form class="flarch-modify-form" enctype="multipart/form-data">

			<input type="hidden" name="flArchId" value="${flArchVO.flArchId}" />

			<div class="title-area form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="flArchTtl" value="${flArchVO.flArchTtl}" required />
			</div>
			<div class="file-area form-group">
				<label>첨부파일</label>
				<div class="file-container">
					<c:if test="${not empty flArchVO.flList}">
						<c:forEach var="file" items="${flArchVO.flList}">
							<div class="file-item">
								<a href="/file/download/${file.flObfsNm}" target="_blank">${file.flNm}</a>
								<button type="button" class="btn-file-remove btn"
									data-fl-id="${file.flId}">x</button>
							</div>
						</c:forEach>
					</c:if>

					<c:if test="${fn:length(flArchVO.flList) < 4}">
						<div class="file-item">
							<input type="file" name="flList" />
							<button type="button" class="btn-file-remove btn">x</button>
						</div>
					</c:if>
				</div>
			</div>

			<div class="content-area form-group">
				<label for="content">내용</label>
				<textarea id="content" name="flArchCtt" rows="5" required>${flArchVO.flArchCtt}</textarea>
			</div>
			<div class="btn-area">
				<a href="/eduad/flarch/list">
					<button type="button" class="btn-flarch-list btn">목록 보기</button>
				</a>
				<button type="submit" class="btn-flarch-submit btn">작성 완료</button>
			</div>

			<!-- 삭제할 파일 ID를 저장할 hidden input container -->
			<div id="delete-file-container">
				<!-- 여기에 JS로 deleteFileIds hidden input이 들어옴 -->
				<!-- <input type="hidden" name="deleteFileIds" value="삭제할파일ID" /> -->
			</div>

		</form>
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