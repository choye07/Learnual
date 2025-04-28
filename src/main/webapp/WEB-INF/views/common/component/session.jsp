<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
	
<div class="login-status-wrapper">
	<ul>
		<c:choose>
			<c:otherwise>
				<li>
					<!-- 사용자명 (사용자 이메일) --> <a href="/"> <c:if
							test="${not empty sessionScope.__LOGIN_USER__.usrNm}">
                            ${sessionScope.__LOGIN_USER__.usrNm}
                        </c:if> <c:if
							test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmNm}">
                            ${sessionScope.__LOGIN_PLTADM__.pltadmNm}
                        </c:if> <c:if
							test="${not empty sessionScope.__LOGIN_INSTR__.instrNm}">
                            ${sessionScope.__LOGIN_INSTR__.instrNm}
                        </c:if> <c:if
							test="${not empty sessionScope.__LOGIN_SPRAD__.spradmNm}">
                            ${sessionScope.__LOGIN_SPRAD__.spradmNm}
                        </c:if>
				</a> <c:if test="${not empty sessionScope.__LOGIN_USER__.usrMl}">
                        (${sessionScope.__LOGIN_USER__.usrMl})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_PLTADM__.pltadmLgnId}">
                        (${sessionScope.__LOGIN_PLTADM__.pltadmLgnId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_INSTR__.instrLgnId}">
                        (${sessionScope.__LOGIN_INSTR__.instrLgnId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_SPRAD__.spradmLgnId}">
                        (${sessionScope.__LOGIN_SPRAD__.spradmLgnId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_PLTADM__.cmcdId}">
                        (${sessionScope.__LOGIN_PLTADM__.cmcdId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_INSTR__.cmcdId}">
                        (${sessionScope.__LOGIN_INSTR__.cmcdId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_SPRAD__.cmcdId}">
                        (${sessionScope.__LOGIN_SPRAD__.cmcdId})
                    </c:if>
                     <c:if
						test="${not empty sessionScope.__LOGIN_USER__.insttnId}">
                        (${sessionScope.__LOGIN_USER__.insttnId})
                    </c:if>
                     <c:if
						test="${not empty sessionScope.__LOGIN_PLTADM__.insttnId}">
                        (${sessionScope.__LOGIN_PLTADM__.insttnId})
                    </c:if> <c:if
						test="${not empty sessionScope.__LOGIN_INSTR__.insttnId}">
                        (${sessionScope.__LOGIN_INSTR__.insttnId})
                    </c:if>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
