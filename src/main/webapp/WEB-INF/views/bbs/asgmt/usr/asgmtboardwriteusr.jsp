<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-과제제출-학생</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course student">
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course student">
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

				<div class="assignment-board board write">
					<div class="board-header">
						<h1>과제 제출(학생)</h1>
						<div class="board-toolbox">
							<div class="btn-goMain">
								<a href="/insttn/crs">홈으로</a>
								<!-- 수정예정 -->
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="board-wrapper">
							<form id="assignment-submit-form">
								<!-- form id, name, VO 확인하며 맞출 예정 -->
								<div class="nameA-area">
									<label>강좌명</label> <input type="text" value="현재 강의명이 들어옴" />
								</div>
								<div class="nameB-area">
									<label>과제 제목</label> <input type="text" />
								</div>
								<div class="nameC-area">
									<label>과제 내용</label>
									<textarea name="" id=""></textarea>
								</div>
								<div class="nameD-area">
									<label>제출 파일</label>
									<input type="file" />
								</div>
								<div class="btn-area">
									<button type="submit">과제 제출</button>
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
