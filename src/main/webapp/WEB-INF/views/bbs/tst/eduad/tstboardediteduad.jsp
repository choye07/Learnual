<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-시험수정-강사</title>
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
			<div class="main-wrapper tst">
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

				<div class="tst-board board tutor edit">
					<div class="board-header">
						<h1>시험 게시판</h1>
						<div class="board-toolbox">
							<div class="board-tutor-toolbox">
								<div class="btn-go-list">
									<a href="#">목록 보기</a>
								</div>
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="board-wrapper">
							<form id="tst-form" action="#">
								<!-- 모든 input의 id명을 name과 통일 시키는걸 추천! -->
								<!-- name은 VO의 멤버변수 값과 똑같이 만드세요 -->
								<!-- p.s 직접 하시는 게 좋을 것 같아 놔두었어요. -->
								<div class="tstTtl-area">
									<label>시험명</label> <input type="text" value="자바 기초 시험" />
								</div>
								<div class="currTstExamDt-area">
									<label>기존 시험 날짜</label> <input type="text"
										value="2025-04-25 09:00:00" />
								</div>
								<div class="newTstExamDt-area">
									<label>수정 시험 날짜</label> <input type="datetime-local" />
								</div>
								<!-- VO에 없음 주의 -->
								<div class="tutorNm-area">
									<label>강사명</label> <input type="text" value="박성연" />
								</div>
								<div class="tstRspnsPth-area">
									<label>응답 URL</label> <input type="text"
										value="https://google.com/forms/asdf" />
								</div>
								<div class="tstEdtPth-area">
									<label>편집 URL</label> <input type="text"
										value="https://google.com/forms/asdf" />
								</div>
								<div class="btn-area">
									<button type="submit">변경사항 저장</button>
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