<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
<title>board-view</title>
</head>

<body>
	<div class="flarch-one-board board">
		<div class="board-header">
			<h1>자료실 게시판</h1>
			<div class="board-toolbox">
				<div class="board-user-toolbox">
					<div class="btn-go-list">
						<a href="/eduad/flarch/list">목록 보기</a>
					</div>
					<div class="btn-add">
						<a href="/eduad/flarch/write">게시글 작성</a>
					</div>
					<div class="btn-modify">
						<a href="/eduad/flarch/modify/${flArchVO.flArchId}">게시글 수정</a>
					</div>
					<div class="btn-delete">
						<a href="/eduad/flarch/delete/${flArchVO.flArchId}"
							onclick="return confirm('정말 삭제하시겠습니까?')">게시글 삭제</a>
					</div>
				</div>
			</div>
		</div>

		<div class="board-body">
			<div class="board-list-top"></div>
			<div class="board-wrapper">
				<div class="board-info">
					<label>작성자</label>
					<div>조인해서 나올 작성자 이름-지금은 폼 이름으로 나옴!</div>
					<label>작성날짜</label>
					<div>${flArchVO.flArchRgstDt}</div>
					<label>이메일</label>
					<div>${flArchVO.instrId}</div>
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
										<a href="/eduad/file/${flArchVO.flArchId}/${file.flId}">
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
</body>

</html>