<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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