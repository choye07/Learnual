<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-상담읽기-강사</title>
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

				<div class="cnsl-board board view">
					<div class="board-header">
						<h1>상담 요청 확인</h1>
						<div class="board-toolbox">
							<div class="board-user-toolbox">
								<div class="btn-go-list">
									<a href="/crntc/list">목록 보기</a>
								</div>
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="board-wrapper">
							<form id="cnsl-accept-form">
								<!-- form id, name, VO 확인하며 맞출 예정 -->
								<div class="1-area form-group">
									<label>제목</label> <input type="text" value="자격증 관련 상담요청입니다." />
								</div>
								<div class="2-area form-group">
									<label>회원명</label> <input type="text" value="홍길동" />
								</div>
								<div class="3-area form-group">
									<label>상담요청일</label> <input type="text"
										value="2025-04-25 오후 18:38" />
								</div>
								<div class="6-area form-group">
									<label>상담 내용</label>
									<textarea name="" id="">동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</textarea>
								</div>
								<div class="cnslUsrCnclCtt-area form-group">
									<label>취소 사유</label>
									<textarea name="cnslUsrCnclCtt" id="cnslUsrCnclCtt">야간 수업 일정으로 불가능</textarea>
								</div>
								<div class="btn-area">
									<button type="submit" class="btn-accept">상담 승인</button>
									<button type="submit" class="btn-reject">상담 취소</button>
								</div>
							</form>
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