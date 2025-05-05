<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>러뉴얼 홈</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
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

			<c:choose>
				<c:when test="${not empty sessionScope.__LOGIN_SPRAD__}">
					<div class="contents">

						<div class="notice learnual-notice board write">
							<div class="board-header">
								<h1>러뉴얼 공지사항 작성</h1>
							</div>

							<form:form modelAttribute="ntcWriteRequestVO"
								id="learnual-notice-form">
								<div class="ntcPinnedYn-area form-group">
									<label for="ntcPinnedYn">상단 고정</label> <input type="checkbox"
										id="ntcPinnedYn" name="ntcPinnedYn" />
								</div>
								<div class="writer-area form-group">
									<label for="ntcWrtrId">작성자 아이디</label> <input type="text" id="ntcWrtrId"
										name="ntcWrtrId" value="${spradmVO.spradmId}" />
								</div>
								<div class="ntcTtl-area form-group">
									<label for="ntcTtl">제목</label> <input type="text" id="ntcTtl"
										value="${usrWriteNtc.ntcTtl}" name="ntcTtl" required />
								</div>

								<form:errors path="ntcTtl" element="div" cssClass="error" />
								<div class="ntcCtt-area form-group">
									<label for="ntcCtt">내용</label>
									<textarea id="ntcCtt" name="ntcCtt" rows="5" required>${usrWriteNtc.ntcCtt}</textarea>
								</div>
								<form:errors path="ntcCtt" element="div" cssClass="error" />
								<div class="btn-area">
									<button type="button" class="btn-list btn"
										onclick='location.href="/learnual/ntc/list"'>목록 보기</button>
									<button type="button" class="btn-submit btn">작성 완료</button>
								</div>
							</form:form>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="access-denied-container learnual">
						<p>공지글 작성 권한이 존재하지 않습니다.</p>
						<button type="button" class="btn"
							onclick='location.href="/learnual/ntc/list"'>목록 보기</button>
					</div>
				</c:otherwise>
			</c:choose>




		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>

</html>