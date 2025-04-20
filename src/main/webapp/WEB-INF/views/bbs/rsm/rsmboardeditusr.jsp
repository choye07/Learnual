<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>이력서 수정(usr)</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>
<body>
	<div class="rsm-board board student edit">
		<div class="board-header">
			<h1>이력서 관리</h1>
			<div class="board-toolbox">
				<div class="btn-go-list">
					<a href="#">목록 보기</a>
				</div>
			</div>
		</div>

		<div class="board-body">
			<div class="board-wrapper">
				<form id="rsm-form" action="#">
					<!-- 모든 input의 id명을 name과 통일 시키는걸 추천! -->
					<!-- name은 VO의 멤버변수 값과 똑같이 만드세요 -->
					<!-- p.s 직접 하시는 게 좋을 것 같아 놔두었어요. -->
					<div class="custom1-area form-group">
						<label>이력서 제목</label> <input type="text" value="기존 작성 되었던 제목" />
					</div>
					<div class="writer-area form-group">
						<label>작성자</label> <input type="text" value="장유진" />
					</div>
					<div class="custom3-area form-group">
						<label>내용</label> <input type="file" />
					</div>
					<div class="btn-area">
						<button type="submit">수정내용 저장</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>