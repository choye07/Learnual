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

				<div class="contents">

					<div class="notice course-notice board write">
						<div class="board-header">
							<h1>강좌 공지사항 작성</h1>
						</div>

						<form:form modelAttribute="crntcWriteRequestVO"
							id="crntc-notice-form">
							<div class="crntcPinnedYn-area form-group">
								<label for=crntcPinnedYn>상단 고정</label> <input type="checkbox"
									id="crntcPinnedYn" name="crntcPinnedYn" />
							</div>
							<div class="writer-area form-group">
								<label for="writer">작성자</label> <input type="text" id="writer"
									name="writer" value="작성자" required />
							</div>
							<div class="crntcTtl-area form-group">
								<label for="crntcTtl">제목</label> <input type="text" id="crntcTtl"
									value="${usrWriteCrntc.crntcTtl}" name="crntcTtl" required />
							</div>

							<form:errors path="crntcTtl" element="div" cssClass="error" />
							<div class="crntcCtt-area form-group">
								<label for="crntcCtt">내용</label>
								<textarea id="crntcCtt" name="crntcCtt" rows="5" required>${usrWriteCrntc.crntcCtt}</textarea>
							</div>
							<form:errors path="crntcCtt" element="div" cssClass="error" />
							<div class="btn-area">
								<button type="button" class="btn-list btn"
									onclick='location.href="/crntc/list"'>목록 보기</button>
								<button type="button" class="btn-submit btn">작성 완료</button>
							</div>
						</form:form>
					</div>

				</div>

			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>

</html>