<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학원 메인</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard insttn">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->

		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/insttnsidebar.jsp" />

		<jsp:include
			page="/WEB-INF/views/common/component/header/insttnheader.jsp" />

		<div class="dashboard-main insttn">
			<div class="main-wrapper">
				<div class="visual insttn">
					<img src="/asset/isttn/visual01.jpg" alt="insttn-visual-img01">
					<img src="/asset/isttn/visual02.jpg" alt="insttn-visual-img02">
				</div>

				<div class="contents">

					<div class="notice insttn-notice board">
						<div class="board-header">
							<h1>학원 공지사항</h1>
							<div class="board-toolbox">
								<div class="board-user-toolbox">
									<div class="btn-go-list">
										<a href="/insttnntc/list">목록 보기</a>
									</div>
								</div>
								<div class="board-manager-toolbox">
									<div class="btn-modify">
										<a href="/insttnntc/modify/${selectedInsttnNotice.ntcId}">게시글 수정</a>
									</div>
									<div class="btn-delete">
										<a href="/insttnntc/delete/${selectedInsttnNotice.ntcId}">게시글 삭제</a>
									</div>
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
									<div>${selectedInsttnNotice.ntcWrtrId}</div>
									<label>작성시간</label>
									<div>${selectedInsttnNotice.ntcRgstDt}</div>
									<label>제목</label>
									<div>${selectedInsttnNotice.ntcTtl}</div>
								</div>
								<div class="board-content">
									<label>내용</label>
									<div class="board-content-text">${selectedInsttnNotice.ntcCtt}</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/insttnfooter.jsp" />
	</div>
</body>

</html>