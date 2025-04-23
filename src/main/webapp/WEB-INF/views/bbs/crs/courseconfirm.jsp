<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 확정</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course">

			<div class="main-wrapper course-confirm">
				<div class="main-wrapper-top">
					<h1>강의 확정</h1>
					<h2>강의명: ${courseName}</h2>
				</div>
				<div class="main-wrapper-body">
					<h3>해당 강의를 신청한 회원 내역</h3>

					<div class="applied-user-list-area">
						<c:choose>
							<c:when test="${empty confirmedUsers}">
								<p class="empty-user-list">신청한 회원이 없습니다.</p>
								<a class="btn-abandon" href="javascript:void(0);" data-id="${crsInfId}">폐강</a>
							</c:when>
							<c:otherwise>
								<form id="confirm-applied-user-form"
									action="/admin/confirmSelectedUsers" method="post">
									<div class="table-header">
										<div>선택</div>
										<div>회원 이름</div>
										<div>전화번호</div>
										<div>이메일</div>
										<div>주소</div>
										<div>신청일</div>
									</div>
									<c:forEach var="user" items="${confirmedUsers}">
										<div class="table-item">
											<div>
											     <input type="checkbox" name="selectedUserIds"
												    value="${user.usrId}" />
											</div>
											<div>${user.usrNm}</div>
											<div>${user.usrPn}</div>
											<div>${user.usrMl}</div>
											<div>${user.usrAdrs}</div>
											<div>${user.appHstrRgstDt}</div>
										</div>
									</c:forEach>
									<div class="btn-area">
										<button type="button" id="btn-real-confirm" data-id="${crsInfId}">강의 확정하기</button>
									</div>
								</form>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
			</div>

		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>

</html>