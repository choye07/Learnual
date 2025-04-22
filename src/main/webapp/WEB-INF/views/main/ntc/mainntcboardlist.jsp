<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>러뉴얼 공지사항</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
</head>

<body>
	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/common/component/header/learnualheader.jsp" />

		<div class="home-main">
			<div class="visual">main visual</div>

			<div class="contents">

				<div class="notice learnual-notice board">
					<div class="board-header">
						<h1>러뉴얼 공지사항</h1>
						<div class="board-toolbox">
							<div class="btn-goMain">
								<a href="/">홈으로</a>
							</div>
							<div class="btn-add-notice">
								<a href="/ntc/write">공지글 작성</a>
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
								<c:when test="${not empty mainNtcList.ntcList}">
									<c:set var="hasVisibleNotice" value="false" />

									<!-- 상단 고정 체크된 게시글 -->
									<c:forEach items="${mainNtcList.ntcList}" var="mainNtc">
										<c:if
											test="${mainNtc.ntcDelYn != 'Y' && mainNtc.ntcPinnedYn == 'Y'}">
											<li class="pinned-notice-list"><a href="/ntc/view/${mainNtc.ntcId}">
													<div class="board-list-title">${mainNtc.ntcTtl}</div>
													<div class="board-list-writer">작성자이름</div>
													<div class="board-list-time">${mainNtc.ntcRgstDt}</div>
											</a></li>
											<c:set var="hasVisibleNotice" value="true" />
										</c:if>
									</c:forEach>

									<!-- 상단 고정 체크되지 않은 게시글 -->
									<c:forEach items="${mainNtcList.ntcList}" var="mainNtc">
										<c:if
											test="${mainNtc.ntcDelYn != 'Y' && mainNtc.ntcPinnedYn == 'N'}">
											<li><a href="/ntc/view/${mainNtc.ntcId}">
													<div class="board-list-title">${mainNtc.ntcTtl}</div>
													<div class="board-list-writer">작성자이름</div>
													<div class="board-list-time">${mainNtc.ntcRgstDt}</div>
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

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>

</html>