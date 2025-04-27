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
		<div class="header dashboard student">
			<div class="header-top">
				<div class="header-top-wrapper">
					<!-- 관리자 권한이 있는 사람만 보임 -->
					<div class="header-left">
						<div class="btn-menu">
							<a href="#">menu</a>
						</div>
						<div class="insttn-area">
							<div class="insttn-logo">
								<a href="/insttn">학원 logo</a>
							</div>
						</div>
					</div>

					<div class="header-right">
						<div class="btn-direct">
							<a href="/">러뉴얼 바로가기</a>
						</div>
						<div class="btn-notification">
							<a href="#">notification</a>
							<div class="badge"></div>
						</div>
					</div>
					<div class="notification-box">
						<div class="notification-deco">
							<div class="tri"></div>
						</div>
						<ul class="notification-content">
							<li><a href="#"> 과제게시판 알림이 도착했습니다. </a></li>
							<li><a href="#"> 과제게시판 알림이 도착했습니다. </a></li>
							<li><a href="#"> 과제게시판 알림이 도착했습니다. </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="sidebar student">
			<div class="btn-close">
				<a href="#">close</a>
			</div>
			<div class="user-info">
				<div class="user-info-img">user-info-img</div>
				<p class="user-greeting">
					<span class="user-name">홍길동</span> 님 안녕하세요!
				</p>
				<div class="user-info-btns">
					<a class="btn-mypage btn" href="#">마이페이지</a> <a
						class="btn-logout btn" href="#">로그아웃</a>
				</div>
			</div>
			<!-- sidebar menu wrapper -->
			<div class="menu-wrapper">
				<!-- sidebar menu1 -->
				<ul class="menu1 sidebar-menu">
					<li class="sidebar-main-menu"><a href="#">나의 정보</a>
						<div class="btn-toggle on">
							<a href="#">toggle</a>
						</div></li>
					<ul class="menu-list">
						<li><a href="#">마이페이지</a></li>
						<li><a href="#">출결현황</a></li>
						<li><a href="#">내가 쓴 글</a></li>
						<li><a href=/viewmyinfo>나의 정보 수정</a></li>
					</ul>
				</ul>
				<!-- sidebar menu2 -->
				<ul class="menu2 sidebar-menu">
					<li class="sidebar-main-menu"><a href="#">게시판</a>
						<div class="btn-toggle on">
							<a href="#">toggle</a>
						</div></li>
					<ul class="menu-list">
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자료실</a></li>
						<li><a href="#">과제 게시판</a></li>
						<li><a href="#">시험 게시판</a></li>
						<li><a href="#">질문 게시판</a></li>
					</ul>
				</ul>
				<!-- sidebar menu3 -->
				<ul class="menu3 sidebar-menu">
					<li class="sidebar-main-menu"><a href="#">문의하기</a>
						<div class="btn-toggle on">
							<a href="#">toggle</a>
						</div></li>
					<ul class="menu-list">
						<li><a href="#">상담 신청 및 현황</a></li>
						<li><a href="#">관리자 문의</a></li>
					</ul>
				</ul>
			</div>
		</div>

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
									<span class="user-name">홍길동</span> 님 안녕하세요!
								</p>
							</div>
							<!-- 대시보드 좌측 탭 메뉴 -->
							<ul class="menu-wrapper">
								<li class="menu-item"><a href="/dashboard/usr">개인정보관리</a></li>
								<li class="menu-item on"><a href="/dashboard/usr/course">나의
										수강 목록</a></li>
								<li class="menu-item"><a href="/dashboard/usr/resume">나의
										이력서 목록</a></li>
							</ul>
						</div>

						<div class="dashboard-content-area">
							<!-- view content insert start -->
							<div class="mycourse manage-board view">
								<div class="manage-board-wrapper">
									<div class="manage-board-header">
										<h2>나의 수강 목록</h2>
									</div>

									<div class="manage-board-body">
										<!-- view main content insert start -->
										<div class="usr-courses-area">
											<div class="board-list-top">
												<div>강좌명</div>
												<div>강사명</div>
												<div>강의 시작일</div>
												<div>강의 종료일</div>
											</div>

											<ul class="board-list-wrapper">
												<!-- forEach start -->
												<li class="list-item"><a href="#">
														<div class="item-course-name">풀스택 25기 전문가 양성과정</div>
														<div class="item-instr-name">장민창</div>
														<div class="item-course-start-time">2025.04.23 오후
															18:00</div>
														<div class="item-course-end-time">2025.04.25 오후
															12:00</div>
												</a></li>
												<li class="list-item"><a href="#">
														<div class="item-course-name">자바</div>
														<div class="item-instr-name">장민창</div>
														<div class="item-course-start-time">2025.04.23 오후
															18:00</div>
														<div class="item-course-end-time">2025.04.25 오후
															12:00</div>
												</a></li>
												<li class="list-item"><a href="#">
														<div class="item-course-name">(재직자 대상) React 실무 과정</div>
														<div class="item-instr-name">장민창</div>
														<div class="item-course-start-time">2025.04.23 오후
															18:00</div>
														<div class="item-course-end-time">2025.04.25 오후
															12:00</div>
												</a></li>
												<!-- forEach end -->
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
										<!-- view main content insert end -->
									</div>
								</div>
							</div>
							<!-- view content insert end -->
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
									<button class="btn">출석 요청</button>
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