<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>대시보드-학생</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>

</head>

<body>
	<div class="dashboard student">
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/usrsidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/dashboardheaderusr.jsp" />
		<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />

		<div class="dashboard-main student">
			<div class="main-wrapper">
				<div class="dashboard-col1">
					<div class="dashboard-contents student">

						<!-- usr sidebar -->
						<div class="sidemenu student">
							<div class="user-info">
								<div class="user-info-img">
									<a href="#">user-info-img</a>
								</div>
								<p class="user-greeting">
									<span class="user-name">${inputEdit.myiNm}</span> 님 안녕하세요!
								</p>
							</div>
							<!-- 대시보드 좌측 탭 메뉴 -->
							<ul class="menu-wrapper">
								<li class="menu-item on"><a id="dashboard-usr-information" href="">개인정보관리</a></li>
								<li class="menu-item"><a href="/usr/${insttnId}/dashboard/courselist">나의 수강 목록</a></li>
								<li class="menu-item"><a href="/dashboard/usr/resume">나의 이력서 목록</a></li>
							</ul>
						</div>

						<div class="dashboard-content-area">
							<!-- view content 삽입 start -->
							<div class="myinfo manage-board view">
								<div class="manage-board-wrapper">
									<div class="manage-board-header">
										<h2>개인 정보 관리</h2>
									</div>

									<div class="manage-board-body">

										<div class="regist-usr-form">
											<div class="email-area">
												<label for="email">이메일</label> <input id="myiLgnId"
													name="myiLgnId" type="email" value="${inputEdit.myiLgnId}" />
											</div>

											<div class="name-area">
												<label for="name">이름</label> <input id="myiNm" name="myiNm"
													type="text" value="${inputEdit.myiNm}" required />
											</div>

											<div class="password-area">
												<label for="password">비밀번호 수정</label> <input id="myiLgnPw"
													name="myiLgnPw" type="password" required />
											</div>
											<!-- 개인 정보 관리 쪽이라 비밀번호 확인은 필요없다 판단. -->
											<!-- <div class="confirm-password-area">
												<label for="password">비밀번호 확인</label> <input
													id="confirmUsrPw" name="confirmUsrPw" required="password" />
											</div> -->
											<div class="address-area">
												<label for="address">주소</label> <input id="myiAdrs"
													name="myiAdrs" type="text"
													value="${inputEdit.myiAdrs}" required />
											</div>
											<div class="phone-area">
												<label for="phone">전화번호</label> <input id="myiPn"
													name="myiPn" type="text" value="${inputEdit.myiPn}"
													required />
											</div>

											<div class="btn-area">
												<form action="/editmyinformation" method="get">
													<button class="btn2 btn-edit" type="submit">수정</button>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- view content 삽입 end -->
						</div>

					</div>
				</div>
				<div class="dashboard-col2">
					<!-- right-widget1 출석현황 start -->
					<div class="attd-status-widget right-widget student">
						<div class="widget-wrapper">
							<h2>출석현황</h2>
							<div class="attd-status-data">
								<div class="attd-data1">
									<p>출석</p>
									<span>20</span>
								</div>
								<div class="attd-data1">
									<p>결석</p>
									<span>0</span>
								</div>
								<div class="attd-data1">
									<p>지각</p>
									<span>0</span>
								</div>
							</div>
							<div class="btn-area">
								<div class="btn-req-attd">
									<button class="btn" id=course-attd>출석 요청</button>
									<button class="btn" id=course-out-status>외출</button>
									<button class="btn" id=course-leave-early>조퇴</button>
									<button class="btn" id=course-absence>결석</button>
								</div>
							</div>
						</div>
					</div>
					<!-- right-widget1 출석현황 end -->
					<!-- right-widget2 dday start -->
					<div class="dday-widget right-widget">
						<ul class="dday-list-wrapper">
							<!-- forEach start -->
							<li class="dday-item">
								<div class="course-info">
									<label>과목명:</label>
									<p class="dday-item-course-name">kt ds 25기 풀스택 전문가 양성과정</p>
								</div>
								<div class="test-info">
									<label>다음 시험까지</label>
									<p class="dday-date">
										D-<span class="dday-date-target">11</span>
									</p>
									<p>2025.04.13(일)</p>
								</div>
							</li>
							<li class="dday-item">
								<div class="course-info">
									<label>과목명:</label>
									<p class="dday-item-course-name">(재직자 대상) React 실무 과정</p>
								</div>
								<div class="test-info">
									<label>다음 시험까지</label>
									<p class="dday-date">
										D-<span class="dday-date-target">23</span>
									</p>
									<p>2025.04.28(일)</p>
								</div>
							</li>
							<!-- forEach end -->
						</ul>
					</div>
					<!-- right-widget2 dday end -->
				</div>
			</div>
		</div>
	</div>
</body>

</html>