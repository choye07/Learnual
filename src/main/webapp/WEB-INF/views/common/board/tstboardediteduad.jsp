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
<title>tst-board-edit(강사)</title>
</head>

<body>
	<div class="tst-board board tutor edit">
		<div class="board-header">
			<h1>시험 게시판</h1>
			<div class="board-toolbox">
				<div class="board-tutor-toolbox">
					<div class="btn-go-list">
						<a href="#">목록 보기</a>
					</div>
				</div>
			</div>
		</div>

		<div class="board-body">
			<div class="board-wrapper">
				<form id="tst-form" action="#">
					<!-- 모든 input의 id명을 name과 통일 시키는걸 추천! -->
					<!-- name은 VO의 멤버변수 값과 똑같이 만드세요 -->
					<!-- p.s 직접 하시는 게 좋을 것 같아 놔두었어요. -->
					<div class="tstTtl-area">
						<label>시험명</label> <input type="text" value="자바 기초 시험" />
					</div>
					<div class="tstExamDt-area">
						<label>정규 시험 날짜</label> <input type="text"
							value="2025-04-25 09:00:00" />
					</div>
					<!-- VO에 없음 주의 -->
					<div class="tutorNm-area">
						<label>강사명</label> <input type="text" value="박성연" />
					</div>
					<div class="tstRspnsPth-area">
						<label>응답 URL</label> <input type="text"
							value="https://google.com/forms/asdf" />
					</div>
					<div class="tstEdtPth-area">
						<label>편집 URL</label> <input type="text"
							value="https://google.com/forms/asdf" />
					</div>
					<div class="btn-area">
						<button type="submit">변경사항 저장</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>