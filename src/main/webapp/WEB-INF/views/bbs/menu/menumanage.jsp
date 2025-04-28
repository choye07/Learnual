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
			<a href="/sprad/menumanage" class="main-home-btn">러뉴얼</a>
			<button class="insttn-home">학원 홈페이지</button>
			<div class="insttn-button-group">
				<c:choose>
					<c:when test="${not empty menuListVO.insttnList }">
						<c:forEach items="${menuListVO.insttnList}" var="insttn">
							<a href="/sprad/${insttn.insttnId}/insttnmenumanage" class="insttn-btn">${insttn.insttnNm}</a>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>불러올 수 있는 학원 목록이 없습니다</p>
					</c:otherwise>
				</c:choose>
			</div>
			<button class="crs-home">강좌 홈페이지</button>
			<div class="crsinf-button-group">
			<c:choose>
				<c:when test="${not empty menuListVO.crsinfList }">
					<c:forEach items="${menuListVO.crsinfList}" var="crsinf">
					<input type="hidden" name="crsinfId" id="crsinfId" value="${crsinf.crsInfId}">
							<a href="/sprad/${crsinf.insttnId }/${crsinf.crsInfId}/crsinfmenumanage" class="crsinf-btn">${crsinf.crsInfNm}</a>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>불러올 수 있는 강좌 목록이 없습니다</p>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<p class="check-manage-cat"></p>
		<a class="menu btn-edit">메뉴 수정</a> <a class="menu btn-del">메뉴 삭제</a>
		<form:form class="menu-regist-form"
			modelAttribute="menuRegistRequestVO">
			<input type="hidden" name="insttnId" id="insttnId" value="${insttnId}" />
			<input type="hidden" name="crsinfId" id="crsinfId" value="${crsInfId}" />
			<input type="hidden" name="menuAcc" id="menuAcc" value="SPRACC" />
			<input type="hidden" name="menuUsYn" id="menuUsYn" value="Y" />
			<div class="menu-Item-container">
				<h3>개설된 메뉴</h3>
				<ul class="menu-item-box"
					style="list-style: none; border: 1px solid #7cb3d3">
					<c:choose>
						<c:when test="${not empty menuListVO.menuList }">
							<c:forEach items="${menuListVO.menuList}" var="menu">
								<li><a href="${menu.menuId}">${menu.menuNm}</a></li>
								<a class="menu add-menu">메뉴 추가</a>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li>개설된 메뉴가 없습니다.</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="artc-Item-container">
				<h3>개설된 게시판</h3>
				<ul class="artc-item-box"
					style="list-style: none; border: 1px solid #126291">
					<c:choose>
						<c:when test="${not empty menuListVO.artcList }">
							<c:forEach items="${menuListVO.artcList}" var="artc">
								<li><a href="${artc.artcId}">${artc.artcNm}</a></li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li>개설된 게시판이 없습니다.</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div>
				<label for="menuNm">메뉴 명</label> <input type="text" name="menuNm"
					id="menuNm" value="${menuRegistRequestVO.menuNm}"
					style="display: block;">
				<form:errors path="menuNm" element="div" cssClass="error menuNm" />
				<div>
					<label for="menuHghRnkId">상위 메뉴 명</label> <input type="text"
						name="menuHghRnkId" id="menuHghRnkId" style="display: block;">

					<label for="menuUrl">메뉴 URL</label> <input type="text"
						name="menuUrl" id="menuUrl" value="${menuRegistRequestVO.menuUrl}"
						style="display: block;">
					<form:errors path="menuUrl" element="div" cssClass="error menuUrl" />
					<h3>메뉴 사용 여부</h3>
					<input type="checkbox" name="menu-use-yn" id="menu-use-yn"
						value="Y" checked />사용 <input type="checkbox" name="menu-use-yn"
						id="menu-use-yn" value="N" />미사용
					<form:errors path="menuUsYn" element="div"
						cssClass="error menuUsYn" />
					<h3>접근 권한</h3>
					<!-- 슈퍼관리자는 session값이 슈퍼관리자일 때만 보이게하기. -->
					<c:choose>
						<c:when test="${not empty menuListVO.cmCdList  }">
							<c:forEach items="${menuListVO.cmCdList}" var="cmcd"
								varStatus="status">
								<input type="checkbox" name="menuAcc-check"
									id="menuAcc${status.index}" value="${cmcd.cmcdId}" /> ${cmcd.cmcdNm}
								 <form:errors path="menuAcc" element="div"
									cssClass="error menuAcc" />
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