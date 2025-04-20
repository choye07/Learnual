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
					<a href="#">이력서 작성</a>
				</div>
			</div>
		</div>

		<div class="board-body">
			<div class="board-list-top">
				<div>이력서 제목</div>
				<div>이력서 관리</div>
			</div>
			<!-- 이력서 목록 -->
			<ul class="board-list-wrapper">
				<!-- 이력서 view 페이지가 없기 때문에 a태그로 감싸지 않음 -->
				<li>
					<div class="rsm-content-area">
						<div class="rsm-content-title">내가 작성한 이력서 제목1</div>
						<span class="rsm-content-time">2025-04-19</span>
					</div>
					<div class="rsm-manage-area">
						<a href="#">재등록</a> <a href="#">다운로드</a> <a href="#">삭제</a>
					</div>
				</li>
				<li>
					<div class="rsm-content-area">
						<div class="rsm-content-title">내가 작성한 이력서 제목2</div>
						<span class="rsm-content-time">2025-04-21</span>
					</div>
					<div class="rsm-manage-area">
						<a href="#">재등록</a> <a href="#">다운로드</a> <a href="#">삭제</a>
					</div>
				</li>
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
	</div>
</body>

</html>