<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 상세보기</title>
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
			<div class="main-wrapper course-detail">
				<div class="course-detail-content1">
					<h2 class="section-title">강좌 교육과정</h2>
					<div class="course-info">
						<div class="course-name-label">강좌명</div>
						<div class="course-name">${courseDetail.crsInfNm}</div>
						<div class="course-startDate-label">교육시작일</div>
						<div class="course-startDate">${courseDetail.crsInfStDt}</div>
						<div class="course-endDate-label">교육종료일</div>
						<div class="course-endDate">${courseDetail.crsInfEndDt}</div>
						<div class="course-registStartDate-label">신청시작일</div>
						<div class="course-registStartDate">
							${courseDetail.crsInfAppDt}</div>
						<div class="course-registEndDate-label">신청마감일</div>
						<div class="course-registEndDate">
							${courseDetail.crsInfDdlnDt}</div>
						<div class="course-registEndDate-label">강의실</div>
						<div class="course-registEndDate">
							${courseDetail.crsInfCrsRoomNm}</div>
						<div class="course-registEndDate-label">강사</div>
						<div class="course-registEndDate">
							${instrName}
						</div>
					</div>
				</div>

				<div class="course-detail-content2">
					<h2 class="section-title">상세정보</h2>
					<c:forEach var="curriculum" items="${courseDetail.curriculumList}">
						<div class="course-subjectName"
							style="font-weight: 700; font-size: 24px;">${curriculum.sbjNm}</div>
						<div class="course-subjectDesc">${curriculum.crclmDesc}</div>
					</c:forEach>
				</div>

				<div class="button-wrapper">
				    <c:if test="${!isPltadm}">
				        <c:choose>
				            <c:when test="${!isLoginUser}">
				                <span class="status-text login-required">로그인이 필요합니다.</span>
				            </c:when>
				            
				            <c:when test="${courseDetail.crsInfAbdnYn == 'Y'}">
				                <span class="status-text abandoned">폐강된 강좌입니다.</span>
				            </c:when>
				
				            <c:when test="${courseDetail.crsInfDdlnYn == 'Y'}">
				                <span class="status-text closed">마감된 강좌입니다.</span>
				            </c:when>
				
				            <c:otherwise>
				                <c:choose>
				                    <c:when test="${showCancelButton}">
				                        <a href="javascript:void(0);" class="btn-cancel"
				                           data-id="${courseDetail.crsInfId}"> 신청 취소 </a>
				                    </c:when>
				                    <c:otherwise>
				                        <a href="javascript:void(0);" class="btn-regist"
				                           data-id="${courseDetail.crsInfId}"> 강좌 신청 </a>
				                    </c:otherwise>
				                </c:choose>
				            </c:otherwise>
				        </c:choose>
				    </c:if>

				    <c:choose>
				        <c:when test="${isPltadm}">
				            <a class="btn-back" href="javascript:history.back();" type="button">뒤로</a>
				        </c:when>
				        <c:otherwise>
				            <a class="btn-back" href="javascript:history.back();" type="button">뒤로</a>
				        </c:otherwise>
				    </c:choose>
				</div>
			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>
</body>

</html>