<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 정보 수정</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="wrapper">
		<div class="myinfo manage-board edit">
			<div class="manage-board-wrapper">
				<div class="manage-board-header">
					<h1>개인 정보 수정</h1>
				</div>

				<div class="manage-board-body">
					<form:form modelAttribute="myInformationRequestVO"
					action="/pltad/editmyinformation"
   					 method="POST"
						class="regist-usr-form">
							<div class="email-area">
								<label for="email">계정</label> <input id="myiLgnId"
								name="myiLgnId" value="${inputEdit.myiLgnId}" />
							<form:errors path="myiLgnId" cssClass="error myiLgnId" />
						</div>

							<div class="name-area">
								<label for="name">이름</label> <input id="myiNm" name="myiNm"
									type="text" value="${inputEdit.myiNm}" />
								 <c:if test="${not empty errorMessage}">
									<div class="error myiNm">${errorMessage}</div>
								</c:if>
								 <form:errors path="myiNm" element="div" cssClass="error" /> 
							</div>

							<div class="password-area">
								<label for="password">비밀번호</label> <input id="myiLgnPw"
									name="myiLgnPw" type="password"  />
								<c:if test="${not empty errorMessage}">
									<div class="error myiLgnPw">${errorMessage}</div>
								</c:if>
								<form:errors path="myiLgnPw" element="div"
									cssClass="error myiLgnPw" />
							</div>
							<div class="confirm-password-area">
								<label for="password">비밀번호 확인</label> <input id="myiConfirlgnPw"
									name="myiConfirlgnPw" type="password" />
								<c:if test="${not empty errorMessage}">
									<div class="error myiConfirlgnPw">${errorMessage}</div>
								</c:if>
								<form:errors path="myiConfirlgnPw" element="div"
									cssClass="error myiConfirlgnPw" />
							</div>

							<div class="address-area">
								<label for="address">주소</label> <input id="myiAdrs"
									name="myiAdrs" type="text" value="${inputEdit.myiAdrs}"
									 />
								<c:if test="${not empty errorMessage}">
									<div class="error myiAdrs">${errorMessage}</div>
								</c:if>
								<form:errors path="myiAdrs" element="div" cssClass="error" />
							</div>
							<div class="phone-area">
								<label for="phone">전화번호</label> <input id="myiPn" name="myiPn"
									type="text" value="${inputEdit.myiPn}"  />
								<c:if test="${not empty errorMessage}">
									<div class="error myiPn">${errorMessage}</div>
								</c:if>
								<form:errors path="myiPn" element="div" cssClass="error myiPn" />
							</div>

							<div class="btn-area">
								<button class="btn2 btn-save" type="submit">변경 내용 저장</button>
							</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
