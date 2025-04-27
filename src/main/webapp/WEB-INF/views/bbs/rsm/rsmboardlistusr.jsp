<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>이력서 목록(usr)</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="rsm-board board student">
		<div class="board-header">
			<h1>이력서 관리</h1>
			<div class="board-toolbox">
				<div class="btn-write">
					<button type="button" class="btn-rsm-regist">이력서 등록</button>
				</div>

				<div class="search-area">
					<select name="search-option" id="search-option">
						<option value="title">제목</option>
						<option value="regist-date">등록날짜</option>
					</select> <input class="search-input" type="text" />
					<button type="button" class="btn-search">검색</button>
				</div>
			</div>
		</div>
	</div>

	<div class="board-body rsm-body">
		<div class="board-list-top">
			<div>이력서 제목</div>
			<div>이력서 관리</div>
		</div>
		<!-- 이력서 목록 -->
		<ul class="board-list-wrapper">
			<c:choose>
				<c:when test="${not empty rsmListVO.rsmList}">
					<c:forEach items="${rsmListVO.rsmList}" var="rsm"
						varStatus="status">

						<li data-rsm-id="${rsm.rsmId}">
							<div class="rsm-content-area">
								<div class="rsm-content-title">${rsm.rsmTtl}</div>
								<span class="rsm-content-time">${rsm.rsmRgstDt}</span>
							</div>
							<div class="rsm-manage-area">
								<a href="/eduad/file/${rsm.rsmId}/${rsm.file.flId}">다운로드</a>
								<button type="button" class="btn-file-remove btn">삭제</button>
							</div>
						</li>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<li class="empty">등록된 이력서가 없습니다.</li>
				</c:otherwise>
			</c:choose>
			<!-- 등록/수정 폼이 붙을 영역 -->

		</ul>

		<ul class="pagination">
			<li><a href="#">이전</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">다음</a></li>
		</ul>
	</div>
	<template class="rsm-form-container">
		<form class="rsm-write-form" enctype="multipart/form-data">
			<div class="title-area form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="rsmTtl" placeholder="이력서 제목 입력" required />
				<div class="error rsmTtl-error"></div>
			</div>
			<div class="file-area form-group">
				<label>첨부파일</label>
				<div class="file-container">
					<div class="file-item">
						<input type="file" id="file" name="file" />
						<button type="button" class="btn-rsm-remove btn">x</button>
					</div>
				</div>
			</div>
			<button type="submit">등록</button>
		</form>
	</template>
	
</body>

</html>