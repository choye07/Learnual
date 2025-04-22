<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
