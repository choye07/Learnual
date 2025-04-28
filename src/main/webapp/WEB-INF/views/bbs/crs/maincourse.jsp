<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 메인</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<ul class="quick-navbar course">
		<li class="quick-menu learnual"><a href="/learnual">
				<div class="quick-icon">img</div>
				<p>러뉴얼 홈</p>
		</a></li>
		<li class="quick-menu insttn"><a href="${insttnId}">
				<div class="quick-icon">img</div>
				<p>학원 홈</p>
		</a></li>
		<li class="quick-menu course"><a href="/insttn/crs">
				<div class="quick-icon">img</div>
				<p>강좌 홈</p>
		</a></li>
        <li class="quick-menu dashboard" id="dashboard-usr-insttnid"><a href="">
                <div class="quick-icon">img</div>
                <p>대시보드(학생)</p>
        </a></li>
        <li class="quick-menu dashboard " id="dashboard-instr-insttnid"><a href="">
                <div class="quick-icon">img</div>
                <p>대시보드(강사)</p>
        </a></li>
		<!-- 슈퍼관리자 계정만 활성화 -->
		<li class="quick-menu super"><a href="#">
				<div class="quick-icon">img</div>
				<p>슈퍼관리자 메뉴</p>
		</a></li>
	</ul>

	<div class="dashboard course">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp">
		    <jsp:param name="insttnId" value="${insttnId}" />
		    <jsp:param name="crsInfId" value="${courseDetail.crsInfId}" />
		</jsp:include>
		
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course">
			<div class="main-wrapper course-main">
				<div class="widget-wrapper">
					<div class="dashboard-row1">
						<div class="course-info">
							<div class="course-info-wrapper">
								<div class="course-info-title">
									<p>강의명:</p>
									<h2>${courseDetail.crsInfNm}</h2>
								</div>
								<div class="course-info-period">
									   <p>
									        강의신청일: <span>${fn:substring(courseDetail.crsInfAppDt, 0, 10)}</span>
									    </p>
									    <p>
									        신청마감일: <span>${fn:substring(courseDetail.crsInfDdlnDt, 0, 10)}</span>
									    </p>
									    <p>
									        강의시작일: <span>${fn:substring(courseDetail.crsInfStDt, 0, 10)}</span>
									    </p>
									    <p>
									        강의종료일: <span>${fn:substring(courseDetail.crsInfEndDt, 0, 10)}</span>
									    </p>
								</div>
							</div>

						</div>
						<!-- <div class="course-goal">강의학습목표 widget 예정</div> -->
					</div>
					<div class="dashboard-row2">
						<div class="course-notice widget-article">
							<div>
								<h2>강좌 공지사항</h2>
								<a href="/usr/${insttnId}/${courseDetail.crsInfId}/ARTC-20240427-000001/list">더보기</a>
							</div>

							<div>
								<ul class="article-content">
									<li class="empty-notice-list">작성한 공지사항이 없습니다.</li>
								</ul>
							</div>
						</div>
						<div class="course-qna widget-article">
							<div>
								<h2>강좌 QnA 게시판</h2>
								<a href="#">더보기</a>
							</div>

							<div>
								<ul class="article-content">
									<li><a href="#">
											<h3>QnA item1</h3> <span>2025.04.13 홍길동</span>
									</a></li>

									<li><a href="#">
											<h3>QnA item2</h3> <span>2025.04.13 홍길동</span>
									</a></li>
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