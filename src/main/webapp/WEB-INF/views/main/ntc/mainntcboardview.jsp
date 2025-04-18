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
		<jsp:include page="/WEB-INF/views/common/component/learnualheader.jsp" />

		<div class="home-main">
			<div class="visual">main visual</div>

			<div class="contents">

				<div class="learnual-notice board">
					<div class="board-header">
						<h1>러뉴얼 공지사항</h1>
						<div class="board-toolbox">
							<div class="board-user-toolbox">
								<div class="btn-go-list">
									<a href="/ntc/list">목록 보기</a>
								</div>
								<div class="btn-add">
									<a href="#">게시글 작성</a>
								</div>
								<div class="btn-modify">
									<a href="/ntc/modify/${selectedNotice.ntcId}">게시글 수정</a>
								</div>
								<div class="btn-delete">
									<a href="/ntc/delete/${selectedNotice.ntcId}">게시글 삭제</a>
								</div>
							</div>
							<div class="board-manager-toolbox">
								<div class="btn-add-notice">
									<a href="#">공지글 작성</a>
								</div>
							</div>
						</div>
					</div>

					<div class="board-body">
						<div class="board-wrapper">
							<div class="board-info">
								<label>작성자</label>
								<div>${selectedNotice.ntcWrtrId}</div>
								<label>작성시간</label>
								<div>${selectedNotice.ntcRgstDt}</div>
							</div>
							<div class="board-content">
								<label>내용</label>
								<div class="board-content-text">${selectedNotice.ntcCtt}</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<jsp:include page="/WEB-INF/views/common/component/learnualfooter.jsp" />
	</div>

</body>

</html>