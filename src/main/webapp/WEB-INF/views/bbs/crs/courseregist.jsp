<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강의 등록(사용자/강사)</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/insttnsidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/insttnheader.jsp" />

		<div class="dashboard-main course">

			<div class="main-wrapper course-regist">
				<div class="main-wrapper-top">
					<h1>현재 개설 강좌 목록</h1>
				</div>

				<div class="course-wrapper">
					<div class="course-article widget-article">
						<div class="article-title">
							<h2>현재 개설 중인 강좌</h2>
						</div>

						<div>
							<ul class="article-content">
								<c:forEach var="availableCourse" items="${availableCourses}">
									<li><a
										href="/insttn/usr/detail/${availableCourse.crsInfId}">
											<h3>${availableCourse.crsInfNm}</h3>

											<p class="period">
												<span>${availableCourse.crsInfStDt}</span> ~ <span>${availableCourse.crsInfEndDt}</span>
											</p>
											<p class="available-capa">
												수강인원 : <span class="current-capa">${availableCourse.crsCurPrsCnt}</span>
												/ <span class="max-capa">${availableCourse.crsInfPrsCnt}</span>
												명
											</p>
									</a> 
									<c:choose>
									    <c:when test="${availableCourse.status eq 'abandon'}">
									        <p class="status">폐강된 강좌입니다.</p>
									    </c:when>
									    <c:when test="${availableCourse.status eq 'finish'}">
									        <p class="status">마감된 강좌입니다.</p>
									    </c:when>
									    <c:otherwise>
									        <p class="status">신청 가능한 강좌입니다.</p>
									    </c:otherwise>
									</c:choose>
									</li>
								</c:forEach>
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

		</div>

	</div>

	<jsp:include
		page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>

</html>