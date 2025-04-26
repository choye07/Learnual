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

					<div class="notice course-notice board list">
						<div class="board-header">
							<h1>강좌 공지사항</h1>
							<div class="board-toolbox">
								<div class="btn-goMain">
									<a href="/insttn/crs">홈으로</a>
									<!-- 수정예정 -->
								</div>
								<div class="btn-add-notice">
									<a href="/crntc/write">공지글 작성</a>
								</div>
							</div>
						</div>

						<div class="board-body">
							<div class="board-list-top">
								<div>제목</div>
								<div>작성자</div>
								<div>작성시간</div>
							</div>
							<ul class="board-list-wrapper">
								<c:choose>
									<c:when test="${not empty crntcList.ntcList}">
										<c:set var="hasVisibleNotice" value="false" />

										<!-- 상단 고정 체크된 게시글 -->
										<c:forEach items="${crntcList.ntcList}" var="crntc">
											<c:if
												test="${crntc.crntcDelYn != 'Y' && crntc.crntcPinnedYn == 'Y'}">
												<li class="pinned-notice-list"><a
													href="/crntc/view/${crntc.crntcId}">
														<div class="board-list-title">${crntc.crntcTtl}</div>
														<div class="board-list-writer">작성자이름</div>
														<div class="board-list-time">${crntc.crntcRgstDt}</div>
												</a></li>
												<c:set var="hasVisibleNotice" value="true" />
											</c:if>
										</c:forEach>

										<!-- 상단 고정 체크되지 않은 게시글 -->
										<c:forEach items="${crntcList.ntcList}" var="crntc">
											<c:if
												test="${crntc.crntcDelYn != 'Y' && crntc.crntcPinnedYn == 'N'}">
												<li><a href="/crntc/view/${crntc.crntcId}">
														<div class="board-list-title">${crntc.crntcTtl}</div>
														<div class="board-list-writer">작성자이름</div>
														<div class="board-list-time">${crntc.crntcRgstDt}</div>
												</a></li>
												<c:set var="hasVisibleNotice" value="true" />
											</c:if>
										</c:forEach>

										<c:if test="${not hasVisibleNotice}">
											<li class="empty-notice-list">작성된 공지사항이 없습니다.</li>
										</c:if>
									</c:when>
									<c:otherwise>
										<li class="empty-notice-list">작성된 공지사항이 없습니다.</li>
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
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>

</html>