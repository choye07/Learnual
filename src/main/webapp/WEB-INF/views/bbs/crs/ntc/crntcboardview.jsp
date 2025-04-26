<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 메인</title>
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
			<div class="main-wrapper">
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

				<div class="contents">

					<div class="notice course-notice board view">
						<div class="board-header">
							<h1>강좌 공지사항</h1>
							<div class="board-toolbox">
								<div class="board-user-toolbox">
									<div class="btn-go-list">
										<a href="/crntc/list">목록 보기</a>
									</div>
								</div>
								<div class="board-manager-toolbox">
									<div class="btn-modify">
										<a href="/crntc/modify/${selectedCrNotice.crntcId}">게시글 수정</a>
									</div>
									<div class="btn-delete">
										<a href="/crntc/delete/${selectedCrNotice.crntcId}">게시글 삭제</a>
									</div>
									<div class="btn-add-notice">
										<a href="/crntc/write">공지글 작성</a>
									</div>
								</div>
							</div>
						</div>

						<div class="board-body">
							<div class="board-wrapper">
								<div class="board-info">
									<label>작성자</label>
									<div>강사(추후 수정)</div>
									<label>작성시간</label>
									<div>${selectedCrNotice.crntcRgstDt}</div>
									<label>제목</label>
									<div>${selectedCrNotice.crntcTtl}</div>
								</div>
								<div class="board-content">
									<label>내용</label>
									<div class="board-content-text">${selectedCrNotice.crntcCtt}</div>
								</div>
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