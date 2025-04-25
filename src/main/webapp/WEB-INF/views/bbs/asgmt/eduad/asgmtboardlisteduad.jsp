<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-과제목록-강사</title>
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
			<div class="main-wrapper assignment">
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
				<div class="assignment-board board list">
					<div class="board-header">
						<h1>과제 목록(강사)</h1>
						<div class="board-toolbox">
							<div class="btn-goMain">
								<a href="/insttn/crs">홈으로</a>
								<!-- 수정예정 -->
							</div>
							<div class="btn-add-assignment">
								<a href="#">과제 등록</a>
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="assignments-history">
							<div class="eduad-assignments assignments-wrapper">
								<h2>강사가 제출한 과제 내역</h2>
								<div class="board-list-top">
									<div>강좌명</div>
									<div>과제 제목</div>
									<div>제출 시작 날짜</div>
									<div>제출 마감 날짜</div>
									<div>과제 상태</div>
									<div>과제 파일</div>
								</div>
								<ul class="board-list-wrapper">
									<!-- forEach start -->
									<li class="list-item"><a href="#">
											<div class="item-course-name">풀스택 25기 전문가 양성과정</div>
											<div class="item-assignment-name">Front-End 과제-전체리뷰</div>
											<div class="item-assignment-submit-start-time">
												2025.04.23 오후 18:00</div>
											<div class="item-assignment-submit-end-time">2025.04.25
												오후 12:00</div>
											<div class="item-assignment-status">Y</div>
											<div class="item-assignment-file">
												<input type="file" id="assignmentFile" name="assignmentFile" />
												<!-- 파일 처리 로직 필요 -->
											</div>
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

							<div class="usr-assignments assignments-wrapper">
								<h2>학생이 제출한 과제 내역</h2>
								<div class="board-list-top">
									<div>강좌명</div>
									<div>과제 제목</div>
									<div>제출 시작 날짜</div>
									<div>제출 마감 날짜</div>
									<div>과제 상태</div>
									<div>과제 파일</div>
								</div>

								<ul class="board-list-wrapper">
									<!-- forEach start -->
									<li class="list-item"><a href="#">
											<div class="item-course-name">풀스택 25기 전문가 양성과정</div>
											<div class="item-assignment-name">Front-End 과제-전체리뷰</div>
											<div class="item-assignment-submit-start-time">
												2025.04.23 오후 18:00</div>
											<div class="item-assignment-submit-end-time">2025.04.25
												오후 12:00</div>
											<div class="item-assignment-status">Y</div>
											<div class="item-assignment-file">
												<input type="file" id="assignmentFile" name="assignmentFile" />
												<!-- 파일 처리 로직 필요 -->
											</div>
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
						</div>

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

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>
</html>
