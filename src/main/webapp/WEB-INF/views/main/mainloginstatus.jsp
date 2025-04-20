<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="login-status-wrapper">
    <ul>
        <c:choose>
            <c:when test="${empty sessionScope.__LOGIN_USER__ }">

				로그인 해주세요.
            </c:when>
            <c:otherwise>
                <!-- 사용자명 (사용자 이메일) -->       
		        <li>
		        <!-- 둘다 href url 바뀔 가능성 있음.  -->
		          <a href="/">${sessionScope.__LOGIN_USER__.usrNm}</a>   
		          (${sessionScope.__LOGIN_USER__.usrMl})
		          (${sessionScope.__LOGIN_USER__.cmcdId})
		          (${sessionScope.__LOGIN_USER__.insttnId})
		        </li> 
		        <li>
		          <a href="/usr/logout">로그아웃</a> 
		        </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>