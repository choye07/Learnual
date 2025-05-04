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

				<div class="flarch-one-board board">
		<div class="board-header">
			<h1>자료실 게시판</h1>
			<div class="board-toolbox">
				<div class="board-user-toolbox">
					<div class="btn-go-list">
						<a href="/usr/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/list">목록 보기</a>
					</div>
				</div>
			</div>
		</div>

		<div class="board-body">
			<div class="board-list-top"></div>
			<div class="board-wrapper">
				<div class="board-info">
					<label>작성자</label>
					<div>김강사</div>
					<label>작성날짜</label>
					<div>${flArchVO.flArchRgstDt}</div>
					<label>이메일</label>
					<div>instr@learnual.com</div>
					<label>조회수</label>
					<div>${flArchVO.flArchViewCnt}</div>
					<label>제목</label>
					<div class="board-title-text">${flArchVO.flArchTtl}</div>
				</div>

				<div class="board-file-info">
					<label>첨부파일</label>
					<div class="file-container">
						<c:choose>
							<c:when test="${empty flArchVO.flList}">
								<div>첨부파일 없음</div>
							</c:when>
							<c:otherwise>
								<c:forEach items="${flArchVO.flList}" var="file">
									<div>
										<a href="/file/${flArchVO.flArchId}/${file.flId}">
											${file.flNm}</a>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="board-content">
					<label>내용</label>
					<div class="board-content-text">${flArchVO.flArchCtt}</div>
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
