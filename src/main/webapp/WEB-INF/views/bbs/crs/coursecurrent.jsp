<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 신청자 목록</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
    <div class="dashboard course">
        <jsp:include page="/WEB-INF/views/common/component/sidebar/insttnsidebar.jsp" />
        <jsp:include page="/WEB-INF/views/common/component/header/insttnheader.jsp" />

        <div class="dashboard-main course">
            <div class="main-wrapper course-confirm">
                <div class="main-wrapper-top">
                    <h1>강좌 신청자 목록</h1>
                    <h2>강좌명: ${courseName}</h2>
                </div>

                <div class="main-wrapper-body">
                    <h3>현재 해당 강좌를 신청한 회원 내역</h3>

                    <div class="applied-user-list-area">
                        <c:choose>
                            <c:when test="${empty currentUsers}">
                                <p class="empty-user-list">신청한 회원이 없습니다.</p>
                            </c:when>
                            <c:otherwise>
                                <form id="confirm-applied-user-form">
                                <div class="table-header">
                                    <div>회원 이름</div>
                                    <div>전화번호</div>
                                    <div>이메일</div>
                                    <div>주소</div>
                                    <div>신청일</div>
                                </div>
                                <c:forEach var="user" items="${currentUsers}">
                                    <div class="table-item">
                                        <div>${user.usrNm}</div>
                                        <div>${user.usrPn}</div>
                                        <div>${user.usrMl}</div>
                                        <div>${user.usrAdrs}</div>
                                        <div>${user.appHstrRgstDt}</div>
                                    </div>
                                </c:forEach>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <a class="btn-back" href="javascript:history.back();" type="button">뒤로</a>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
    </div>
</body>

</html>