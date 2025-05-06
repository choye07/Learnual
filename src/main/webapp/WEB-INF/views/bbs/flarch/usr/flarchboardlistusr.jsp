<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-과제목록-학생</title>
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

				<div class="flarch-board board">
					<div class="board-header">
						<h1>자료실 게시판</h1>
						<div class="board-toolbox">
							<div class="board-user-toolbox">
								<div class="btn-goHome">
									<a href="/usr/INSTTN-20250424-000001/CRS_INF-20250420-000003/course">홈으로</a>
								</div>
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="board-list-top">
							<div>No</div>
							<div>제목</div>
							<div>작성자</div>
							<div>작성날짜</div>
						</div>
						<ul class="board-list-wrapper">
							<c:choose>
								<c:when test="${not empty flArchList.flArchList}">
									<c:forEach items="${flArchList.flArchList}" var="board"
										varStatus="status">

										<li><a href="/usr/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/view/${board.flArchId}">
												<div class="board-list-no">${flArchList.flArchCnt - status.index}</div>
												<div class="board-list-title">${board.flArchTtl}</div>
												<div class="board-list-writer">${board.instrVO.instrNm}</div>
												<div class="board-list-time">${board.flArchRgstDt}</div>
										</a></li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<li class="empty">게시글이 비어있습니다.</li>
								</c:otherwise>
							</c:choose>
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

				</div>
			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>
</html>
