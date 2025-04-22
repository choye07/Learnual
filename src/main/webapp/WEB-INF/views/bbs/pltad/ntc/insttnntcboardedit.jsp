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

					<div class="notice insttn-notice board edit">
						<div class="board-header">
							<h1>러뉴얼 공지사항 수정</h1>
						</div>

						<form:form modelAttribute="ntcUpdateRequestVO"
							id="insttn-notice-form">
							<input type="hidden" name="ntcId" value="${toModifyInsttnNtcVO.ntcId}" />
							<div class="writer-area form-group">
								<label for="writer">작성자</label> <input type="text" id="writer"
									name="writer" value="작성자" required />
							</div>
							<div class="ntcTtl-area form-group">
								<label for="ntcTtl">제목</label> <input type="text" id="ntcTtl"
									value="${toModifyInsttnNtcVO.ntcTtl}" name="ntcTtl" required />
							</div>
							<form:errors path="ntcTtl" element="div" cssClass="error" />
							<div class="ntcCtt-area form-group">
								<label for="ntcCtt">내용</label>
								<textarea id="ntcCtt" name="ntcCtt" rows="5" required>${toModifyInsttnNtcVO.ntcCtt}</textarea>
							</div>
							<form:errors path="ntcCtt" element="div" cssClass="error" />
							<div class="btn-area">
								<button type="button" class="btn-list btn"
									onclick='location.href="/ntc/list"'>목록 보기</button>
								<button type="button" class="btn-submit btn">수정 완료</button>
							</div>
						</form:form>
					</div>

				</div>

			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/insttnfooter.jsp" />
	</div>
</body>

</html>