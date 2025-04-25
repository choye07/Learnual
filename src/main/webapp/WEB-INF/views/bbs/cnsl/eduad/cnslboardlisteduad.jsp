<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-상담요청목록-강사</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course">
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course">
			<div class="main-wrapper cnsl">
				<div class="course-info v2">
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

				<div class="cnsl-board board list">
					<div class="board-header">
						<h1>상담 요청 목록(강사)</h1>
						<div class="board-toolbox">
							<div class="btn-goMain">
								<a href="/insttn/crs">홈으로</a>
								<!-- 수정예정 -->
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="cnsl-not-complete-area">
							<h2>상담 대기 목록</h2>
							<div class="board-list-top">
								<div>회원명</div>
								<div>상담요청일</div>
								<div>제목</div>
								<div>상담 내용</div>
								<div>상담완료여부</div>
								<div>상담취소여부</div>
								<div>상담취소사유</div>
							</div>

							<ul class="board-list-wrapper">
								<!-- forEach start -->
								<li class="list-item"><a href="#">
										<div class="item-usr-name">홍길동</div>
										<div class="item-cnsl-request-date">상담요청일</div>
										<div class="item-cnsl-title">자격증 관련 상담요청입니다.</div>
										<div class="item-cnsl-content">동해물과 백두산이 마르고 닳도록 하느님이
											보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</div>
										<div class="item-cnsl-complete-yn">N</div>
										<div class="item-cnsl-cancel-yn">N</div>
										<div class="item-cnsl-cancel-content">야간 수업 일정으로 불가능</div>
								</a></li>
								<li class="list-item"><a href="#">
										<div class="item-usr-name">홍길동</div>
										<div class="item-cnsl-request-date">상담요청일</div>
										<div class="item-cnsl-title">자격증 관련 상담요청입니다.</div>
										<div class="item-cnsl-content">동해물과 백두산이 마르고 닳도록 하느님이
											보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</div>
										<div class="item-cnsl-complete-yn">N</div>
										<div class="item-cnsl-cancel-yn">N</div>
										<div class="item-cnsl-cancel-content">야간 수업 일정으로 불가능</div>
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

							<div class="search-area">
								<select name="search-option" id="search-option">
									<option value="title">제목</option>
									<option value="content">내용</option>
									<option value="writer">작성자</option>
								</select> <input class="search-input" type="text" />
								<button type="button" class="btn-search">검색</button>
							</div>
						</div>

						<div class="cnsl-complete-area">
							<h2>상담 완료 목록</h2>
							<div class="board-list-top">
								<div>회원명</div>
								<div>상담요청일</div>
								<div>제목</div>
								<div>상담 내용</div>
								<div>상담완료여부</div>
								<div>상담취소여부</div>
								<div>상담취소사유</div>
							</div>

							<ul class="board-list-wrapper">
								<!-- forEach start -->
								<li class="list-item"><a href="#">
										<div class="item-usr-name">홍길동</div>
										<div class="item-cnsl-request-date">상담요청일</div>
										<div class="item-cnsl-title">자격증 관련 상담요청입니다.</div>
										<div class="item-cnsl-content">동해물과 백두산이 마르고 닳도록 하느님이
											보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</div>
										<div class="item-cnsl-complete-yn">N</div>
										<div class="item-cnsl-cancel-yn">N</div>
										<div class="item-cnsl-cancel-content">야간 수업 일정으로 불가능</div>
								</a></li>
								<li class="list-item"><a href="#">
										<div class="item-usr-name">홍길동</div>
										<div class="item-cnsl-request-date">상담요청일</div>
										<div class="item-cnsl-title">자격증 관련 상담요청입니다.</div>
										<div class="item-cnsl-content">동해물과 백두산이 마르고 닳도록 하느님이
											보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</div>
										<div class="item-cnsl-complete-yn">N</div>
										<div class="item-cnsl-cancel-yn">N</div>
										<div class="item-cnsl-cancel-content">야간 수업 일정으로 불가능</div>
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

							<div class="search-area">
								<select name="search-option" id="search-option">
									<option value="title">제목</option>
									<option value="content">내용</option>
									<option value="writer">작성자</option>
								</select> <input class="search-input" type="text" />
								<button type="button" class="btn-search">검색</button>
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
