<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>러뉴얼 홈</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include
		page="/WEB-INF/views/common/component/quicknav/quicknavlearnual.jsp" />

	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/common/component/header/learnualheader.jsp" />

		<div class="home-main">

			<div style="display: none">
				<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />
			</div>
			<div class="visual">main visual</div>

			<div class="contents">
				<div class="learnual-notice article">
					<div>
						<h2>러뉴얼 공지사항</h2>
						<a href="learnual/ntc/list">더보기</a>
					</div>

					<div>
						<ul class="article-content">
							<li class="empty-notice-list">작성한 공지사항이 없습니다.</li>
						</ul>
					</div>
				</div>

				<div class="usr-section">

					<div class="login-status-section">
						<c:choose>
							<c:when
								test="${empty sessionScope.__LOGIN_USER__ and empty sessionScope.__LOGIN_PLTADM__ and empty sessionScope.__LOGIN_INSTR__ and empty sessionScope.__LOGIN_SPRAD__}">
								<p>학원 또는 강좌명 검색은 로그인이 필요합니다.</p>
								<div class="btn-area">
									<a href="/login">
										<div class="login-overlay">login-overlay</div> <span>러뉴얼
											로그인</span>
									</a> <a href="/regist/agreement">
										<div class="login-overlay">login-overlay</div> <span>회원
											가입</span>
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="lgn-info-area">
									<c:if test="${not empty sessionScope.__LOGIN_SPRAD__}"><div class="badge-lgn-info spradm">슈퍼관리자</div></c:if>
									<c:if test="${not empty sessionScope.__LOGIN_PLTADM__}"><div class="badge-lgn-info pltadm">플랫폼관리자</div></c:if>
									<c:if test="${not empty sessionScope.__LOGIN_INSTR__}"><div class="badge-lgn-info instr">학습관리자</div></c:if>
									<c:if test="${not empty sessionScope.__LOGIN_USER__}"><div class="badge-lgn-info usr">사용자</div></c:if>
									
									<c:if test="${not empty sessionScope.__LOGIN_USER__.usrNm}">
										<div class="lgn-name-area data-area">
											<span>${sessionScope.__LOGIN_USER__.usrNm}</span> 님 환영합니다!
										</div>
									</c:if>
									<c:if
										test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmNm}">
										<div class="lgn-name-area data-area">
											<span>${sessionScope.__LOGIN_PLTADM__.pltadmNm}</span> 님
											환영합니다!
										</div>
									</c:if>
									<c:if test="${not empty sessionScope.__LOGIN_INSTR__.instrNm}">
										<div class="lgn-name-area data-area">
											<span>${sessionScope.__LOGIN_INSTR__.instrNm}</span> 님 환영합니다!
										</div>
									</c:if>
									<c:if test="${not empty sessionScope.__LOGIN_SPRAD__.spradmNm}">
										<div class="lgn-name-area data-area">
											<span>${sessionScope.__LOGIN_SPRAD__.spradmNm}</span> 님
											환영합니다!
										</div>
									</c:if>
									<c:if test="${not empty sessionScope.__LOGIN_USER__.usrMl}">
										<div class="lgn-email-area data-area">계정아이디:
											${sessionScope.__LOGIN_USER__.usrMl}</div>
									</c:if>
									<c:if
										test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmLgnId}">
										<div class="lgn-id-area data-area">계정아이디:
											${sessionScope.__LOGIN_PLTADM__.pltadmLgnId}</div>
									</c:if>
									<c:if
										test="${not empty sessionScope.__LOGIN_INSTR__.instrLgnId}">
										<div class="lgn-id-area data-area">계정아이디:
											${sessionScope.__LOGIN_INSTR__.instrLgnId}</div>
									</c:if>
									<c:if
										test="${not empty sessionScope.__LOGIN_SPRAD__.spradmLgnId}">
										<div class="lgn-id-area data-area">계정아이디:
											${sessionScope.__LOGIN_SPRAD__.spradmLgnId}</div>
									</c:if>
									<c:if test="${not empty sessionScope.__LOGIN_USER__.insttnId}">
										<div class="lgn-insttn-id-area data-area">기관아이디: ${sessionScope.__LOGIN_USER__.insttnId}</div>
									</c:if>
									<c:if
										test="${not empty sessionScope.__LOGIN_PLTADM__.insttnId}">
                        <div class="lgn-insttn-id-area data-area">기관아이디: ${sessionScope.__LOGIN_PLTADM__.insttnId}</div>
                    </c:if>
									<c:if test="${not empty sessionScope.__LOGIN_INSTR__.insttnId}">
                        <div class="lgn-insttn-id-area data-area">기관아이디: ${sessionScope.__LOGIN_INSTR__.insttnId}</div>
                    </c:if>
								</div>
								<div class="logout-area">
									<c:choose>
										<c:when test="${not empty sessionScope.__LOGIN_USER__}">
											<a class="btn-logout" href="/usr/logout">로그아웃</a>
										</c:when>
										<c:when test="${not empty sessionScope.__LOGIN_PLTADM__}">
											<a class="btn-logout" href="/plta/logout">로그아웃</a>
										</c:when>
										<c:when test="${not empty sessionScope.__LOGIN_INSTR__}">
											<a class="btn-logout" href="/instr/logout">로그아웃</a>
										</c:when>
										<c:when test="${not empty sessionScope.__LOGIN_SPRAD__}">
											<a class="btn-logout" href="/sprad/logout">로그아웃</a>
										</c:when>
									</c:choose>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- 로그인했을 경우 보이는 div / search 활성 -->
					<div class="search-section">

						<div class="search-area academy">
							<form id="search-academy-form" class="search-form" action="#">
								<div class="search-input-area">
									<select id="select-search-cat" name="select-search-cat">
										<option selected>학원</option>
										<option>과정</option>
										<c:if test="${not empty Search.writeInsttnNm }">
											<option selected>학원</option>
											<option>과정</option>
										</c:if>
										<c:if test="${not empty Search.writeCrsInfNm }">
											<option>학원</option>
											<option selected>과정</option>
										</c:if>
									</select> <label for="search-academy">과정 명 검색 입력란</label>
									<c:choose>
										<c:when test="${not empty Search.writeInsttnNm }">
											<input id="search-academy" type="text"
												placeholder="${ Search.writeInsttnNm }"
												value="${ Search.writeInsttnNm }" />
										</c:when>
										<c:when test="${not empty Search.writeCrsInfNm }">
											<input id="search-academy" type="text"
												placeholder="${ Search.writeCrsInfNm }"
												value="${ Search.writeCrsInfNm }" />
										</c:when>
										<c:otherwise>
											<input id="search-academy" type="text"
												placeholder="학원 / 과정 명을 입력해주세요" />
										</c:otherwise>
									</c:choose>
								</div>
								<div class="search-button-area">
									<button class="insttn-search-button btn3" type="button">검색</button>
								</div>
							</form>
						</div>

						<ul class="search-academy-list-wrapper list-wrapper">
							<!-- search item forEach start -->
							<c:choose>
								<c:when test="${not empty insttnList}">
									<c:forEach items="${insttnList}" var="insttn">
										<c:forEach items="${insttn.crsInfList}" var="crsInf">
											<li><a href="/${insttn.insttnId}">
													<p>${crsInf.crsInfNm}</p> <span>(주)${insttn.insttnNm}</span>
													<span>${insttn.insttnAdrs}</span>
											</a></li>
										</c:forEach>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<li class="empty-search-result">일치하는 학원 / 과정이 없습니다.</li>
								</c:otherwise>
							</c:choose>
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
			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>
</html>
