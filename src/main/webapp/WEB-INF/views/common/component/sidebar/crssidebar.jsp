<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar course">
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
			<li class="sidebar-main-menu"><a href="#">학습관리자 메인메뉴1</a>
				<div class="btn-toggle on">
					<a href="#">toggle</a>
				</div></li>
			<ul class="menu-list">
				<li><a href="#">학습관리자 sub메뉴1</a></li>
				<li><a href="#">학습관리자 sub메뉴2</a></li>
				<li><a href="#">학습관리자 sub메뉴3</a></li>
				<li><a href="#">학습관리자 sub메뉴4</a></li>
			</ul>
		</ul>
		<!-- sidebar menu2 -->
		<ul class="menu2 sidebar-menu">
			<li class="sidebar-main-menu"><a href="#">게시판 바로가기</a>
				<div class="btn-toggle on">
					<a href="#">toggle</a>
				</div></li>
			<ul class="menu-list">
				<li><a href="/usr/${param.insttnId}/${param.crsInfId}/ARTC-20240427-000001/list">강좌공지사항</a></li>
				<li><a href="/eduad/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/list">강사자료실</a></li>
				<li><a href="/usr/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/list">학생자료실</a></li>
				<li><a href="#">시험게시판</a></li>
				<li><a href="#">과제게시판</a></li>
			</ul>
		</ul>
	</div>
</div>