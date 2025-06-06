<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학원 메인</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>

</head>

<body>
	<jsp:include
		page="/WEB-INF/views/common/component/quicknav/quicknavinsttn.jsp" />


	<div class="dashboard insttn">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->

		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/insttnsidebar.jsp" />

		<jsp:include
			page="/WEB-INF/views/common/component/header/insttnheader.jsp" />

		<div class="dashboard-main insttn">
			<div class="main-wrapper">
				<div class="visual insttn">
					<img src="/asset/isttn/lecture1.jpg" alt="insttn-visual-img01">
					<img src="/asset/isttn/lecture2.jpg" alt="insttn-visual-img02">
				</div>
				<div class="widget-wrapper">
					<div class="dashboard-row1">
						<div class="insttn-notice widget-article">
							<div>
								<h2>학원 공지사항</h2>
								<a href="/insttnntc/list">더보기</a>
							</div>

							<div>
								<ul class="article-content">
									<li class="empty-notice-list">작성한 공지사항이 없습니다.</li>
								</ul>
							</div>
						</div>
						<div class="insttn-qna widget-article">
							<div>
								<h2>학원 QnA 게시판</h2>
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
					<div class="dashboard-row2">
						<!-- 세션값에 따라 현재 개설강좌목록 or 나의 수강강좌목록이 출력됨 start -->
						<div class="notice widget-article">
							<div>
								<h2>
									<c:choose>
										<c:when test="${isInstr}">
                                            나의 가르칠 강좌
                                        </c:when>
										<c:when test="${isRegistered}">
							                수강 중인 강좌 목록
							            </c:when>
										<c:otherwise>
							                학원 강좌 목록
							            </c:otherwise>
									</c:choose>
								</h2>
								<c:choose>
									<c:when test="${isAdmin}">
										<a href="/pltad/${sessionScope.__LOGIN_PLTADM__.insttnId}">관리하기</a>
									</c:when>
									<c:when test="${isStudent}">
										<a href="/usr/${sessionScope.__LOGIN_USER__.insttnId}">신청하기</a>
									</c:when>
									<c:when test="${isInstr}">
										<a href="/eduad/${sessionScope.__LOGIN_INSTR__.insttnId}">강사
											강좌</a>
									</c:when>
									<c:otherwise>
										<span>로그인이 필요합니다.</span>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="course-wrapper">
								<div class="course-article">
									<ul class="article-content">
										<c:set var="linkBase" value="${'/usr/'}" />

										<c:choose>
											<c:when test="${isInstr}">
												<c:choose>
													<c:when test="${empty instrCourses}">
														<li>강사가 맡고 있는 강좌가 없습니다.</li>
													</c:when>
													<c:otherwise>
														<c:forEach var="instrCourse" items="${instrCourses}">
															<li><a
																href="eduad/${sessionScope.__LOGIN_INSTR__.insttnId}/${instrCourse.crsInfId}/course">
																	<h3>${instrCourse.crsInfNm}</h3>
															</a>
																<p class="period">
																	<span>${instrCourse.crsInfStDt}</span> ~ <span>${instrCourse.crsInfEndDt}</span>
																</p></li>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${not empty availableCourses}">
												<c:forEach var="availableCourse" items="${availableCourses}">
													<li><c:choose>
															<c:when test="${isRegistered}">
																<a
																	href="${linkBase}${insttnId}/${availableCourse.crsInfId}/course">
															</c:when>
															<c:otherwise>
																<a
																	href="${linkBase}${insttnId}/${availableCourse.crsInfId}/detail">
															</c:otherwise>
														</c:choose>
														<h3>${availableCourse.crsInfNm}</h3> </a>
														<p class="period">
															<span>${availableCourse.crsInfStDt}</span> ~ <span>${availableCourse.crsInfEndDt}</span>
														</p></li>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<li>현재 신청 가능한 강좌가 없습니다.</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</div>
						</div>
						<!-- 세션값에 따라 현재 개설강좌목록 or 나의 수강강좌목록이 출력됨 end -->
						<div class="recruit-info widget-article">
							<div>
								<h2>실시간 채용 정보</h2>
								<a href="#">더보기</a>
							</div>

							<div>
								<ul class="article-content">
									<li><a href="#">
											<h3>개발자 / 프론트엔드 / 판교 / (주)하이테크</h3> <span>2025.04.13
												등록</span>
									</a></li>

									<li><a href="#">
											<h3>Spring 백엔드 개발자 / 강남 / (주)Hitek</h3> <span>2025.04.11
												등록</span>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/insttnfooter.jsp" />
	</div>
</body>

</html>