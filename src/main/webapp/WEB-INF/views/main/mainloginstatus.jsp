<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="login-status-wrapper">
    <ul>
        <c:choose>
             <c:when test="${empty sessionScope.__LOGIN_USER__ and empty sessionScope.__LOGIN_PLTADM__ and empty sessionScope.__LOGIN_INSTR__}">
                로그인 해주세요.
            </c:when> 
            <c:otherwise>
                <li>
                    <!-- 사용자명 (사용자 이메일) -->
                    <a href="/">
                         <c:if test="${not empty sessionScope.__LOGIN_USER__.usrNm}">
                            ${sessionScope.__LOGIN_USER__.usrNm}
                        </c:if>
                        <c:if test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmNm}">
                            ${sessionScope.__LOGIN_PLTADM__.pltadmNm}
                        </c:if>
                         <c:if test="${not empty sessionScope.__LOGIN_INSTR__.instrNm}">
                            ${sessionScope.__LOGIN_INSTR__.instrNm}
                        </c:if>

                    </a>
                      <c:if test="${not empty sessionScope.__LOGIN_USER__.usrMl}">
                        (${sessionScope.__LOGIN_USER__.usrMl})
                    </c:if>
                    <c:if test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmLgnId}">
                        (${sessionScope.__LOGIN_PLTADM__.pltadmLgnId})
                    </c:if>
                    <c:if test="${not empty sessionScope.__LOGIN_INSTR__.instrLgnId}">
                        (${sessionScope.__LOGIN_INSTR__.instrLgnId})
                    </c:if> 
                    <c:if test="${not empty sessionScope.__LOGIN_PLTADM__.cmcdId}">
                        (${sessionScope.__LOGIN_PLTADM__.cmcdId})
                    </c:if>
                    <c:if test="${not empty sessionScope.__LOGIN_INSTR__.cmcdId}">
                        (${sessionScope.__LOGIN_INSTR__.cmcdId})
                    </c:if>
                    <c:if test="${not empty sessionScope.__LOGIN_PLTADM__.insttnId}">
                        (${sessionScope.__LOGIN_PLTADM__.insttnId})
                    </c:if>
                    <c:if test="${not empty sessionScope.__LOGIN_INSTR__.insttnId}">
                        (${sessionScope.__LOGIN_INSTR__.insttnId})
                    </c:if>
                </li>
                <li>
                    <c:choose>
                        <c:when test="${not empty sessionScope.__LOGIN_USER__}">
                            <a href="/usr/logout">로그아웃</a>
                        </c:when>
                        <c:when test="${not empty sessionScope.__LOGIN_PLTADM__}">
                            <a href="/plta/logout">로그아웃</a>
                        </c:when>
                        <c:when test="${not empty sessionScope.__LOGIN_INSTR__}">
                            <a href="/instr/logout">로그아웃</a>
                        </c:when>
                    </c:choose>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
