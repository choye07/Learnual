<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>플랫폼 관리자 관리</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/common/component/header/learnualheader.jsp" />

		<div class="managepltad-main manage-board">
			<div class="manage-board-wrapper">
				<div class="manage-board-header">
					<h1>플랫폼 관리자 관리</h1>
				</div>
				<div class="manage-board-body">
			<form:form class="pltad-regist-form">
					<div class="email-area">
						<div class="email-input-area">
						<label for="pltadmLgnId">이메일</label>
							<input id="pltadmLgnId" name="pltadmLgnId" type="email"
								 />
								<!-- 추후 해당 버튼 구현 예정  -->
							<!-- <button class="btn2 btn-email-check">이메일 중복체크</button> -->
						</div>
					</div>

					<div class="name-area">
						<label for="pltadmNm">이름</label> <input id="pltadmNm" name="pltadmNm"
							type="text" value="${userInputRegist.usrNm}" required />
					</div>

					<div class="password-area">
						<label for="password">비밀번호</label> <input id="pltadmLgnPw" name="pltadmLgnPw"
							type="password" required />
	
					</div>

					<div class="phone-area">
						<label for="pltadmPn">전화번호</label> <input id="pltadmPn" name="pltadmPn"
							type="text" required />
					</div>
					<div class="btn-area">
						<button class="btn2 btn-regist" id="pltad-regist"type="button">등록</button>
					</div>
				</form:form>
				</div>
			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>
</html>
