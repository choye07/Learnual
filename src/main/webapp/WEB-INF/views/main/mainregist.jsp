<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>러뉴얼 회원가입</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/common/component/header/learnualheader.jsp" />

		<div class="regist-main">
			<div class="regist-section1">
				<div class="text-area">
					<div class="text-title">
						<h1>러뉴얼 회원 가입</h1>
						<p>모두를 위한 학습 관리 플랫폼</p>
						<p>러뉴얼을 찾아주셔서 감사합니다.</p>
					</div>
					<div class="text-sub">
						<p>수강생과 강사, 플랫폼 관리자 모두를 위한 지침서</p>
						<p>Learn-you-all, Learn-manual</p>
					</div>
				</div>
				<div class="img-area">visual-image</div>
			</div>

			<div class="regist-section2">
				<form:form modelAttribute="usrRegistRequestVO" class="regist-usr-form">
					<div class="email-area">
						<label for="email">이메일</label>
						<div class="email-input-area">
							<input id="usrMl" name="usrMl" type="email"
								value="${userInputRegist.usrMl}" />
								<!-- 추후 해당 버튼 구현 예정  -->
							<!-- <button class="btn2 btn-email-check">이메일 중복체크</button> -->
						</div>

 						<c:if test="${not empty emailErrorMessage}">
                <div class="error emailDuplicateError">
                  ${emailErrorMessage}
                </div>
              </c:if>
              <form:errors
                path="usrMl"
                element="div"
                cssClass="error emailDuplicateError"
              />
					</div>

					<div class="name-area">
						<label for="name">이름</label> <input id="usrNm" name="usrNm"
							type="text" value="${userInputRegist.usrNm}" required />
						 <form:errors path="usrNm" element="div" cssClass="error" /> 
					</div>

					<div class="password-area">
						<label for="password">비밀번호</label> <input id="usrPw" name="usrPw"
							type="password" required />
						 <c:if test="${not empty errorMessage}">
                <div class="error passwordEqualError">${errorMessage}</div>
              </c:if>
              <form:errors
                path="usrPw"
                element="div"
                cssClass="error passwordPatternError"
              /> 
					</div>
					<div class="confirm-password-area">
						<label for="password" >비밀번호 확인</label> <input id="confirmUsrPw"
							name="confirmUsrPw" type="password" required />
						 <c:if test="${not empty errorMessage}">
                <div class="error passwordEqualError">${errorMessage}</div>
              </c:if>
              <form:errors
                path="confirmUsrPw"
                element="div"
                cssClass="error passwordPatternError"
              /> 
					</div>

					<div class="address-area">
						<label for="address">주소</label> <input id="usrAdrs" name="usrAdrs"
							type="text" value="${userInputRegist.usrAdrs}" required />
							<button type="button" id="daumPostcode" class="btn2 btn-address-search">주소 검색</button>
						 <form:errors path="usrAdrs" element="div" cssClass="error" />
					</div>
					<div class="phone-area">
						<label for="phone">전화번호</label> <input id="usrPn" name="usrPn"
							type="text" value="${userInputRegist.usrPn}" required />
						 <form:errors path="usrPn" element="div" cssClass="error" />
					</div>

					<div class="btn-area">
						<button class="btn2 btn-regist" type="submit">회원가입</button>
					</div>
				</form:form>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>
</body>
</html>
