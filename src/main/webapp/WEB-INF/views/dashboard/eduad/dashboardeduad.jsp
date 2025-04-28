<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>대시보드-강사</title>
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
		<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />
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
									<span class="user-name">${inputEdit.myiNm}</span> 님 안녕하세요!
								</p>
							</div>
							<!-- 대시보드 좌측 탭 메뉴 -->
							<ul class="menu-wrapper">
								<li class="menu-item on"><a id="dashboard-instr-information" href="">개인정보관리</a></li>
								<li class="menu-item"><a href="/eduad/${insttnId}/dashboard/courselist">나의
										강의 목록</a></li>
								<li class="menu-item"><a href="/dashboard/eduad/consult">상담
										요청 목록</a></li>
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

										<!-- 
                    regist-usr-form -> regist-eduad-form으로 변경 -->
										<div class="regist-eduad-form">
											<div class="email-area">
												<label for="email">이메일</label> <input id="myiLgnId"
													name="myiLgnId" type="email" value="${inputEdit.myiLgnId}" />
											</div>

											<div class="name-area">
												<label for="name">이름</label> <input id="myiNm" name="myiNm"
													type="text" value="${inputEdit.myiNm}" required />
											</div>

											<div class="password-area">
												<label for="password">비밀번호</label> <input id="myiLgnPw"
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
