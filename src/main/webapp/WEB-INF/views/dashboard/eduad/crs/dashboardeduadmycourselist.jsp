<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>대시보드-강사-나의강의목록</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard tutor">
	
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/eduadsidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/dashboardheadereduad.jsp" />

		<!-- student -> tutor class 변환 -->
		<div class="dashboard-main tutor">
			<div class="main-wrapper">
				<div class="dashboard-col1">
					<!-- student -> tutor class 변환 -->
					<div class="dashboard-contents tutor">

						<!-- usr sidebar -->
						<!-- student -> tutor class 변환 -->
						<div class="sidemenu tutor">
							<div class="user-info">
								<div class="user-info-img">
									<a href="#">user-info-img</a>
								</div>
								<p class="user-greeting">
									<span class="user-name">${instrName}</span> 님 안녕하세요!
								</p>
							</div>
							<!-- 대시보드 좌측 탭 메뉴 -->
							<ul class="menu-wrapper">
								<li class="menu-item"><a href="/eduad/${insttnId}/dashboard">개인정보관리</a></li>
								<li class="menu-item on"><a href="/eduad/${insttnId}/dashboard/courselist">나의
										강의 목록</a></li>
								<li class="menu-item"><a href="/dashboard/eduad/consult">상담
										요청 목록</a></li>
							</ul>
						</div>

						<div class="dashboard-content-area">
							<!-- view content 삽입 start -->
							<div class="mycourse manage-board">
								<div class="manage-board-wrapper">
									<div class="manage-board-header">
										<h2>나의 강의 목록</h2>
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
											    <c:forEach var="course" items="${courseList}">
											        <li class="list-item">
											            <a href="/eduad/${insttnId}/${course.crsInfId}/course">
											                <div class="item-course-name">${course.crsInfNm}</div>
											                <div class="item-instr-name">${course.instrNm}</div>
											                <div class="item-course-start-time">${course.crsInfStDt}</div>
											                <div class="item-course-end-time">${course.crsInfEndDt}</div>
											            </a>
											        </li>
											    </c:forEach>
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
							<!-- view content 삽입 end -->
						</div>

					</div>
				</div>
				<div class="dashboard-col2">
					<!-- right-widget1 출석현황 start -->
					<div class="attd-status-widget right-widget tutor">
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
					<!-- right-widget2 todo start -->
					<div class="todo right-widget">
						<div class="widget-wrapper">
							<div class="todo-contents">
								<div class="todo-date">
									<div class="todo-date1">
										<div class="todo-date1-box1">
											<!-- 일 -->
											<div class="todo-date1-date"></div>
										</div>
										<div class="todo-date1-box2">
											<!-- 월 -->
											<div class="todo-date1-month"></div>
											<!-- 년 -->
											<div class="todo-date1-year"></div>
										</div>
									</div>
									<div class="todo-date2">
										<!-- 요일 -->
										<div class="todo-date2-day"></div>
									</div>
								</div>
							</div>
							<!-- 강의계획서 엑셀에서 만약 해당 날짜에
                       데이터가 존재한다면 로딩하는 영역 -->
							<div class="today-course">
								<p>금일 예정 계획</p>
								<!-- 04.26 강의계획서 투두 수정 -->
								<c:choose>
									<c:when test="${not empty todoList.todoList}">
										<!-- todoList.todoList가 있을 때 출력 -->
										<div class="today-todo">
											<ul>
												<c:forEach var="todo" items="${todoList.todoList}">
													<li>${todo.todoCtt}</li>
												</c:forEach>
											</ul>
										</div>
									</c:when>
									<c:otherwise>
										<!-- todoList.todoList가 없을 때 파일 첨부 영역 -->
										<div class="file-area form-group">
											<label>강의계획서</label>
											<div class="file-container">
												<div class="file-item">
													<input type="file" id="file" name="file" />
													<button type="button" class="btn-planner-remove btn">삭제</button>
												</div>
											</div>
										</div>
										<button type="button" class="btn-planner-add">등록</button>
									</c:otherwise>
								</c:choose>
							</div>

							<div class="todo-custom">
								<p>추가 계획</p>
								<!-- 강사가 추가한 todo list 목록 -->
								<ul class="todo-item-wrapper">
									<!-- 템플릿으로 추가될 todo list item -->
								</ul>
								<!-- 숨겨져 있다가 btn-todo-edit클릭 시 나타나는 영역 -->
								<div class="todo-edit-area">
									<input class="custom-todo-input" type="text"
										placeholder="추가할 계획을 작성하세요" />
									<button class="btn-add">추가</button>
								</div>
							</div>
						</div>

						<div class="btn-todo-edit">
							<a href="#">+</a>
						</div>
					</div>
					<!-- right-widget2 todo end -->
				</div>
			</div>
		</div>
	</div>

	<!-- 0419 todo 추가 start -->
	<template id="todo-item-template">
		<li class="todo-item">
			<div class="todo-item-content"></div>
			<div class="todo-item-manage on">
				<div class="btn-todo-delete">
					<a href="#">del</a>
				</div>
			</div>
		</li>
	</template>
	<!-- 0419 todo 추가 end -->
</body>

</html>
