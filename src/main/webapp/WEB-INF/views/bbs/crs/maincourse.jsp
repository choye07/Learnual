<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="dashboard course">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
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
									<h2>Kt ds 25기 풀스택 전문가 양성과정</h2>
								</div>
								<div class="course-info-period">
									<p>
										강의신청일: <span>2024.11.01</span>
									</p>
									<p>
										신청마감일: <span>2025.01.10</span>
									</p>
									<p>
										강의시작일: <span>2025.01.14</span>
									</p>
									<p>
										강의종료일: <span>2025.06.20</span>
									</p>
								</div>
							</div>

						</div>
						<div class="course-goal">강의학습목표 widget 예정</div>
					</div>
					<div class="dashboard-row2">
						<div class="course-notice widget-article">
							<div>
								<h2>강좌 공지사항</h2>
								<a href="/crntc/list">더보기</a>
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