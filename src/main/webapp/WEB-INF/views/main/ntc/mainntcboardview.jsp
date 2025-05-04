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
			<div>
				<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />
			</div>
			<div class="visual">main visual</div>

			<div class="contents">

				<div class="notice learnual-notice board">
					<div class="board-header">
						<h1>러뉴얼 공지사항</h1>
						<div class="board-toolbox">
							<div class="board-user-toolbox">
								<div class="btn-go-list">
									<a href="/learnual/ntc/list">목록 보기</a>
								</div>
								<c:if test="${not empty sessionScope.__LOGIN_SPRAD__}">
									<div class="btn-modify">
										<a href="/learnual/ntc/modify/${selectedNotice.ntcId}">게시글
											수정</a>
									</div>
									<div class="btn-delete">
										<a href="/learnual/ntc/delete/${selectedNotice.ntcId}">게시글
											삭제</a>
									</div>
								</c:if>
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
								<label>제목</label>
								<div>${selectedNotice.ntcTtl}</div>
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

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>

</html>