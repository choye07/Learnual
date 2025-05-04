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
									<span class="user-name">${sessionScope.__LOGIN_USER__.usrNm}</span>
									님 안녕하세요!
								</p>
							</div>
							<!-- 대시보드 좌측 탭 메뉴 -->
							<ul class="menu-wrapper">
								<li class="menu-item"><a href="/usr/${insttnId}/dashboard">개인정보관리</a></li>
								<li class="menu-item"><a
									href="/usr/${insttnId}/dashboard/courselist">나의 수강 목록</a></li>
								<li class="menu-item on"><a
									href="/usr/${insttnId}/dashboard/rsm/list">나의 이력서 목록</a></li>
							</ul>
						</div>

						<div class="dashboard-content-area">
							<!-- view content 삽입 start -->
							<div class="rsm-board board student">
								<div class="board-header">
									<h1>이력서 목록</h1>
									<div class="board-toolbox">
										<div class="btn-write">
											<button type="button" class="btn-rsm-regist">이력서 등록</button>
										</div>
									</div>
								</div>

								<div class="board-body rsm-body">
									<div class="board-list-top">
										<div>이력서 제목</div>
										<div>이력서 관리</div>
									</div>
									<!-- 이력서 목록 -->
									<ul class="board-list-wrapper"
										data-insttn-id="${sessionScope.__LOGIN_USER__.insttnId}">
										<!-- 이력서 view 페이지가 없기 때문에 a태그로 감싸지 않음 -->
										<c:choose>
											<c:when test="${not empty rsmListVO.rsmList}">
												<c:forEach items="${rsmListVO.rsmList}" var="rsm"
													varStatus="status">

													<li data-rsm-id="${rsm.rsmId}">
														<div class="rsm-content-area">
															<div class="rsm-content-title">${rsm.rsmTtl}</div>
															<span class="rsm-content-time">${rsm.rsmRgstDt}</span>
														</div>
														<div class="rsm-manage-area">
															<a href="/file/${rsm.rsmId}/${rsm.file.flId}">다운로드</a>
															<button type="button" class="btn-file-remove btn">삭제</button>
														</div>
													</li>

												</c:forEach>
											</c:when>
											<c:otherwise>
												<li class="empty">등록된 이력서가 없습니다.</li>
											</c:otherwise>
										</c:choose>
										<!-- 등록/수정 폼이 붙을 영역 -->
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
								</div>
								<div class="btn-req-out">
									<button class="btn" id=course-out-status>외출</button>
								</div>
								<div class="btn-req-early">
									<button class="btn" id=course-leave-early>조퇴</button>
								</div>
								<div class="btn-req-attd">
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
	<template class="rsm-form-container">
		<form class="rsm-write-form" enctype="multipart/form-data">
			<div class="title-area form-group">
				<label for="title">제목</label> 
				<input type="text" id="title" name="rsmTtl" placeholder="이력서 제목 입력" required />
				<div class="error rsmTtl-error"></div>
			</div>
			<div class="file-area form-group">
				<label>첨부파일</label>
				<div class="file-container">
					<div class="file-item">
						<input type="file" id="file" name="file" />
						<button type="button" class="btn-rsm-remove btn">x</button>
					</div>
				</div>
			</div>
			<div class="form-submit">
				<button type="submit">등록</button>
			</div>
		</form>
	</template>
</body>

</html>