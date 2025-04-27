<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>
<body>

			<div>
				<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />
			</div>
	<div class="article-manage">
		<h1>메뉴 관리</h1>
		<div class="home-page-button-group">
			<button class="main-home">메인 홈페이지</button>
			<button class="insttn-home">학원 홈페이지</button>
			<button class="crs-home">강좌 홈페이지</button>
		</div>
		<p class="check-manage-cat"></p>
		<a class="add-menu" style="border: 1px solid #c6c8c9">메뉴 추가</a> <a
			class="modi-menu" style="border: 1px solid #c6c8c9">메뉴 수정</a> <a
			class="del-menu" style="border: 1px solid #c6c8c9">메뉴 삭제</a>
		<form:form class="menu-regist-form">
		<input type="hidden" name="menuAcc" id="menuAcc" value="" />
		<input type="hidden" name="menuUsYn" id="menuUsYn" value="" />
			<div class="menu-Item-container">
				<h3>개설된 메뉴</h3>
				<ul class="menu-item-box"
					style="list-style: none; border: 1px solid #7cb3d3">
					<li>About</li>
				</ul>
			</div>
			<div class="artc-Item-container">
				<h3>개설된 게시판</h3>
				<ul class="artc-item-box"
					style="list-style: none; border: 1px solid #126291">
					<li>공지사항</li>
				</ul>
			</div>
			<div>
				<label for="menuNm">메뉴 명</label> <input type="text" name="menuNm"
					id="menuNm" style="display: block;">
				<div>
					<label for="menuHghRnkId">상위 메뉴 명</label> <input type="text"
						name="menuHghRnkId" id="menuHghRnkId" style="display: block;">
					<label for="menuUrl">메뉴 URL</label> <input type="text"
						name="menuUrl" id="menuUrl" style="display: block;">
					<h3>메뉴 사용 여부</h3>
					<input type="checkbox" name="menu-use-yn" id="menu-use-yn" value="Y" />사용 <input
						type="checkbox" name="menu-use-yn" id="menu-use-yn" value="N" />미사용
					<h3>접근 권한</h3>
					<!-- 슈퍼관리자는 session값이 슈퍼관리자일 때만 보이게하기. -->
					<c:choose>
						<c:when test="${not empty cmCdList }">
							<c:forEach items="${cmCdList}" var="cmcd" varStatus="status">
								<input type="checkbox" name="menuAcc-check"
									id="menuAcc${status.index}" value="${cmcd.cmcdId}" /> ${cmcd.cmcdNm}
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>등록된 권한이 없습니다. 슈퍼관리자에게 문의하세요</p>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="button-group">
					<button class="save-button" id="menu-save" type="button">저장</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>